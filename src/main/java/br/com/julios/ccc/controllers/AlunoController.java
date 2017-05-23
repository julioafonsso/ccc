package br.com.julios.ccc.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.bd.daos.AlunoDAO;
import br.com.julios.ccc.infra.bd.daos.MatriculaDAO;
import br.com.julios.ccc.infra.bd.daos.MensalidadeDAO;
import br.com.julios.ccc.infra.dto.aluno.CadastroAlunoDTO;
import br.com.julios.ccc.infra.dto.aluno.ConsultaAlunoDTO;
import br.com.julios.ccc.infra.dto.matricula.CadastroMatriculaDTO;
import br.com.julios.ccc.infra.dto.matricula.ConsultaMatriculaDTO;
import br.com.julios.ccc.infra.dto.menslidade.ConsultaMensalidadeDTO;
import br.com.julios.ccc.infra.dto.turma.individual.CadastroAulaIndividualDTO;
import br.com.julios.ccc.infra.dto.turma.individual.ConsultaAulaIndividualDTO;
import br.com.julios.ccc.negocio.aluno.AlunoRepositorio;
import br.com.julios.ccc.negocio.fluxos.FluxoCaixa;
import br.com.julios.ccc.negocio.fluxos.FluxoCaixaRepositorio;
import br.com.julios.ccc.negocio.funcionario.Funcionario;
import br.com.julios.ccc.negocio.matricula.Matricula;
import br.com.julios.ccc.negocio.matricula.MatriculaRepositorio;
import br.com.julios.ccc.negocio.mensalidade.Mensalidade;
import br.com.julios.ccc.negocio.mensalidade.MensalidadeRepositorio;
import br.com.julios.ccc.negocio.turma.individual.AulaIndividual;
import br.com.julios.ccc.negocio.turma.individual.AulaIndividualRepositorio;

@Controller
@ResponseBody
@Transactional(propagation = Propagation.REQUIRED)
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	AlunoRepositorio alunoRepositorio;

	@Autowired
	MensalidadeRepositorio mensalidadeRepositorio;

	@Autowired
	AulaIndividualRepositorio aulaIndividualRepositorio;

	@Autowired
	FluxoCaixaRepositorio pagamentoRepositorio;

	@Autowired
	MatriculaRepositorio matriculaRepositorio;

	@Autowired
	AlunoDAO alunoDAO;

	@Autowired
	MatriculaDAO matriculaDAO;

	@Autowired
	MensalidadeDAO mensalidadeDAO;

	//
	// @Autowired
	// private HttpServletRequest http;

	// @RequestMapping(method = RequestMethod.GET)
	// public Iterable<AlunoDO> getAlunos(@RequestParam(value = "nome", required
	// = false) String nome,
	// @RequestParam(value = "cpf", required = false) String cpf,
	// @RequestParam(value = "email", required = false) String email) throws
	// Exception {
	//
	// return null;
	// }

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ConsultaAlunoDTO getAluno(@PathVariable("id") Long idAluno) {
		return alunoDAO.getAlunos(idAluno);
	}

	@RequestMapping(value = "{id}/turmas", method = RequestMethod.GET)
	public List<ConsultaMatriculaDTO> getTurmas(@PathVariable("id") Long idAluno) {
		return matriculaDAO.getMatriculas(idAluno);
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<ConsultaAlunoDTO> getAlunos() throws Exception {
		return alunoDAO.getAlunos();
	}

	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarAluno(@RequestBody CadastroAlunoDTO aluno) throws Exception {
		alunoRepositorio.getAluno(aluno).cadastrar();
		;
	}

	@RequestMapping(value = "{id}/debitos", method = RequestMethod.GET)
	public List<ConsultaMensalidadeDTO> getDebitos(@PathVariable("id") Long idAluno) throws Exception {
		return mensalidadeDAO.getMensalidadesAluno(idAluno);
	}

	@RequestMapping(value = "{idAluno}/debitos/{idMensalidade}/pagamento", method = RequestMethod.POST)
	public void efetuarPagamento(@PathVariable("idAluno") Long idAluno,
			@PathVariable("idMensalidade") Long idMensalidade, @RequestBody Double valor) throws Exception {
		Mensalidade mensalidade = mensalidadeRepositorio.getMensalidade(idMensalidade);

		Funcionario prof1 = mensalidade.getMatricula().getTurma().getProfessor1();
		Funcionario prof2 = mensalidade.getMatricula().getTurma().getProfessor2();

		FluxoCaixa pagamento = pagamentoRepositorio.getPagamentoMensalidade(mensalidade, valor);

		pagamento.cadastrar();

		mensalidade.pagar(pagamento);
		mensalidade.criarMensalidade();

		if (prof1 != null)
			prof1.criarComissaoProfessor(mensalidade, valor);

		if (prof2 != null)
			prof2.criarComissaoProfessor(mensalidade, valor);
	}

	@RequestMapping(value = "{id}/pagamentos/{dataInicio}/{dataFim}", method = RequestMethod.GET)
	public List<ConsultaMensalidadeDTO> getPagamentos(@PathVariable("id") Long idAluno,
			@PathVariable("dataInicio") String dataInicio, @PathVariable("dataFim") String dataFim) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

		Date diaInicio = sdf.parse(dataInicio);
		Date diaFim = sdf.parse(dataFim);

		Calendar c = Calendar.getInstance();
		c.setTime(diaFim);
		c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
		diaFim = c.getTime();

		return mensalidadeDAO.getMensalidadesPagasAluno(idAluno, diaInicio, diaFim);
	}

	@RequestMapping(value = "{id}/aula-particular", method = RequestMethod.POST)
	public void cadastrarAulaParticular(@PathVariable("id") Long idAluno,
			@RequestBody CadastroAulaIndividualDTO cadastro) throws Exception {

		AulaIndividual turma = this.aulaIndividualRepositorio.getAula(cadastro);

		turma.cadastrar();

		CadastroMatriculaDTO cadastroMatricula = new CadastroMatriculaDTO();

		cadastroMatricula.setDataMatricula(new Date());
		cadastroMatricula.setIdAluno(idAluno);
		cadastroMatricula.setIdTurma(turma.getId());
		cadastroMatricula.setValor(new Double(0));

		Matricula matricula = matriculaRepositorio.getMatricula(cadastroMatricula);
		matricula.cadastrar();

		Mensalidade mensalidade = mensalidadeRepositorio.getMensalidade(matricula);
		mensalidade.criarMensalidade(cadastro.getValorPago());

		FluxoCaixa pagamento = pagamentoRepositorio.getPagamentoAulaParticular(matricula.getAluno().getNome(),
				cadastro.getQtdAulas(), cadastro.getValorPago());

		pagamento.cadastrar();

		mensalidade.pagar(pagamento);

	}

	//
	@RequestMapping(value = "{id}/aula-particular/{dataInicio}/{dataFim}", method = RequestMethod.GET)
	public List<ConsultaAulaIndividualDTO> consultarAulaParticular(@PathVariable("id") Long idAluno,
			@PathVariable("dataInicio") String dataInicio, @PathVariable("dataFim") String dataFim) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

		Date diaInicio = sdf.parse(dataInicio);
		Date diaFim = sdf.parse(dataFim);

		Calendar c = Calendar.getInstance();
		c.setTime(diaFim);
		c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
		diaFim = c.getTime();

		return matriculaDAO.getAulasParticulares(idAluno, diaInicio, diaFim);
	}

}
