package br.com.julios.ccc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
import br.com.julios.ccc.infra.dto.matricula.ConsultaMatriculaDTO;
import br.com.julios.ccc.infra.dto.menslidade.ConsultaMensalidadeDTO;
import br.com.julios.ccc.negocio.aluno.AlunoRepositorio;
import br.com.julios.ccc.negocio.funcionario.Funcionario;
import br.com.julios.ccc.negocio.funcionario.FuncionarioRepositorio;
import br.com.julios.ccc.negocio.mensalidade.Mensalidade;
import br.com.julios.ccc.negocio.mensalidade.MensalidadeRepositorio;

@Controller
@ResponseBody
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	AlunoRepositorio alunoRepositorio;
	
	@Autowired
	MensalidadeRepositorio mensalidadeRepositorio;
	
	@Autowired
	FuncionarioRepositorio funcionarioRepositorio;

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
	public void efetuarPagamento(@PathVariable("idAluno") Long idAluno, @PathVariable("idMensalidade") Long idMensalidade, @RequestBody Double valor) throws Exception
	{
		Mensalidade mensalidade = 		mensalidadeRepositorio.getMensalidade(idMensalidade);
		Funcionario prof1 = mensalidade.getMatricula().getTurma().getProfessor1();
		Funcionario prof2 = mensalidade.getMatricula().getTurma().getProfessor2();
		
		mensalidade.pagar(valor);
		
		if(prof1 != null)
			prof1.criarComissaoProfessor(mensalidade, valor);
		
		
		if(prof2 != null)
			prof2.criarComissaoProfessor(mensalidade, valor);
	}

	// @RequestMapping(method = RequestMethod.PUT)
	// public void atualizarAluno(@RequestBody AlunoDO aluno) throws Exception {
	// }
	//
	// @RequestMapping(method = RequestMethod.DELETE)
	// public void apagarAluno(AlunoDO aluno) {
	// }
	//
	// @RequestMapping(value = "{id}/pagamentos/{dataInicio}/{dataFim}", method
	// = RequestMethod.GET)
	// public List<MensalidadeDO> getPagamentos(@PathVariable("id") Long
	// idAluno, @PathVariable("dataInicio") String dataInicio,
	// @PathVariable("dataFim") String dataFim) throws Exception {
	//
	//
	// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
	//
	// Date diaInicio = sdf.parse(dataInicio);
	// Date diaFim = sdf.parse(dataFim);
	//
	// Calendar c = Calendar.getInstance();
	// c.setTime(diaFim);
	// c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
	// diaFim = c.getTime();
	//
	//
	// return alunoFacade.getPagamentos(idAluno, diaInicio, diaFim);
	// return null;
	// }
	//
	//
	//
	//
	//
	// @RequestMapping(value = "{id}/aula-particular", method =
	// RequestMethod.POST)
	// public void cadastrarAulaParticular(@PathVariable("id") Long idAluno,
	// @RequestBody AulaParticularDO aula) throws Exception {
	//
	// }
	//
	// @RequestMapping(value = "{id}/aula-particular/{dataInicio}/{dataFim}",
	// method = RequestMethod.GET)
	// public List<MensalidadeDO> consultarAulaParticular(@PathVariable("id")
	// Long idAluno, @PathVariable("dataInicio") String dataInicio,
	// @PathVariable("dataFim") String dataFim) throws Exception {
	//
	// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
	//
	// Date diaInicio = sdf.parse(dataInicio);
	// Date diaFim = sdf.parse(dataFim);
	//
	// Calendar c = Calendar.getInstance();
	// c.setTime(diaFim);
	// c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
	// diaFim = c.getTime();
	//
	// return null;
	// }
	//

}
