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
import br.com.julios.ccc.infra.bd.model.AlunoDO;
import br.com.julios.ccc.infra.bd.model.AulaParticularDO;
import br.com.julios.ccc.infra.bd.model.ComissaoProfessorDO;
import br.com.julios.ccc.infra.bd.model.FluxoCaixaDO;
import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.bd.model.MatriculaDO;
import br.com.julios.ccc.infra.bd.model.MensalidadeDO;
import br.com.julios.ccc.infra.bd.model.TurmaColetivaDO;
import br.com.julios.ccc.infra.dto.aluno.CadastroAlunoDTO;
import br.com.julios.ccc.infra.dto.aluno.ConsultaAlunoDTO;
import br.com.julios.ccc.infra.dto.matricula.ConsultaMatriculaDTO;
import br.com.julios.ccc.infra.dto.menslidade.ConsultaMensalidadeDTO;
import br.com.julios.ccc.infra.dto.turma.individual.CadastroAulaIndividualDTO;
import br.com.julios.ccc.infra.dto.turma.individual.ConsultaAulaIndividualDTO;
import br.com.julios.ccc.repositorios.AlunoRepositorio;
import br.com.julios.ccc.repositorios.AulaIndividualRepositorio;
import br.com.julios.ccc.repositorios.FluxoCaixaRepositorio;
import br.com.julios.ccc.repositorios.MatriculaRepositorio;
import br.com.julios.ccc.repositorios.MensalidadeRepositorio;
import br.com.julios.ccc.repositorios.MesRerefenciaRepositorio;
import br.com.julios.ccc.repositorios.PagamentoFuncionarioRepositorio;

@Controller
@ResponseBody
@Transactional(propagation = Propagation.REQUIRED)
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	private AlunoRepositorio alunoRepositorio;

	@Autowired
	private MensalidadeRepositorio mensalidadeRepositorio;

	@Autowired
	private AulaIndividualRepositorio aulaIndividualRepositorio;

	@Autowired
	private FluxoCaixaRepositorio pagamentoRepositorio;

	@Autowired
	private MatriculaRepositorio matriculaRepositorio;

	@Autowired
	private AlunoDAO alunoDAO;

	@Autowired
	private MatriculaDAO matriculaDAO;

	@Autowired
	private MensalidadeDAO mensalidadeDAO;
	
	@Autowired
	private PagamentoFuncionarioRepositorio comissaoRepositorio;
	
	@Autowired
	private MesRerefenciaRepositorio mesRepositorio;

	//
	// @Autowired
	// private HttpServletRequest http;

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
	public ConsultaAlunoDTO cadastrarAluno(@RequestBody CadastroAlunoDTO aluno) throws Exception {
		return alunoRepositorio.getAluno(aluno).cadastrar();
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ConsultaAlunoDTO atualizarAluno(@RequestBody CadastroAlunoDTO aluno) throws Exception {
		return alunoRepositorio.getAluno(aluno.getId()).atualizar(aluno);
	}

	
	@RequestMapping(value = "{id}/debitos", method = RequestMethod.GET)
	public List<ConsultaMensalidadeDTO> getDebitos(@PathVariable("id") Long idAluno) throws Exception {
		return mensalidadeDAO.getMensalidadesAluno(idAluno);
	}

	@RequestMapping(value = "{idAluno}/debitos/{idMensalidade}/pagamento", method = RequestMethod.POST)
	public void efetuarPagamento(@PathVariable("idAluno") Long idAluno,
			@PathVariable("idMensalidade") Long idMensalidade, @RequestBody Double valor) throws Exception {
		MensalidadeDO mensalidade = mensalidadeRepositorio.getMensalidade(idMensalidade);

		TurmaColetivaDO turma = (TurmaColetivaDO) mensalidade.getTurma();

		FluxoCaixaDO pagamento = pagamentoRepositorio.getPagamentoMensalidade(mensalidade, valor);

		pagamento.cadastrar();

		mensalidade.cadastrarPagamento(pagamento);

		List<FuncionarioDO> professores = turma.getProfessores();

		for (FuncionarioDO func : professores) {
			ComissaoProfessorDO comissao = comissaoRepositorio.getComissao(mensalidade, this.mesRepositorio.getMesAtual(), func);
			comissao.cadastrar();
		}

		MensalidadeDO mensalidadeNova = mensalidadeRepositorio.getMensalidade(mensalidade.getMatricula(), mensalidade.getMesReferencia().getProximoMes());
		mensalidadeNova.cadastrar();

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

		AulaParticularDO turma = this.aulaIndividualRepositorio.getAula(cadastro);

		turma.cadastrar();

		AlunoDO aluno = this.alunoRepositorio.getAluno(idAluno);

		MatriculaDO matricula = matriculaRepositorio.getMatricula(aluno, turma);
		matricula.cadastrar();

		MensalidadeDO mensalidade = mensalidadeRepositorio.getMensalidade(matricula);

		FluxoCaixaDO pagamento = pagamentoRepositorio.getPagamentoAulaParticular(matricula.getAluno().getNome(),
				cadastro.getQtdAulas(), cadastro.getValorPago());

		pagamento.cadastrar();

		mensalidade.cadastrar();
		mensalidade.cadastrarPagamento(pagamento);
		

		ComissaoProfessorDO comissao = this.comissaoRepositorio.getComissao(mensalidade, this.mesRepositorio.getMesAtual(), turma.getProfessor1());
		comissao.cadastrar();
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

	@RequestMapping(value = "{id}/workshop/{dataInicio}/{dataFim}", method = RequestMethod.GET)
	public List<ConsultaMatriculaDTO> consultarWorkShops(@PathVariable("id") Long idAluno,
			@PathVariable("dataInicio") String dataInicio, @PathVariable("dataFim") String dataFim) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

		Date diaInicio = sdf.parse(dataInicio);
		Date diaFim = sdf.parse(dataFim);

		Calendar c = Calendar.getInstance();
		c.setTime(diaFim);
		c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
		diaFim = c.getTime();

		return matriculaDAO.getWorkShop(idAluno, diaInicio, diaFim);
	}
	
}
