package br.com.julios.ccc.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.Aluno;
import br.com.julios.ccc.domains.AulaParticular;
import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.Mensalidades;
import br.com.julios.ccc.facade.AlunoFacade;
import br.com.julios.ccc.facade.FtpFacade;

@Controller
@ResponseBody
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	AlunoFacade alunoFacade;

	@Autowired
	FtpFacade fileFacade;

//
//	@Autowired
//	private HttpServletRequest http;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Aluno> getAlunos(@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "cpf", required = false) String cpf,
			@RequestParam(value = "email", required = false) String email) throws Exception {

		return alunoFacade.getAlunos(nome, cpf, email);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarAluno(@RequestBody Aluno aluno) throws Exception {
		alunoFacade.cadastrarAluno(aluno);
	}

	

	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarAluno(@RequestBody Aluno aluno) throws Exception {
		alunoFacade.atualizarAluno(aluno);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void apagarAluno(Aluno aluno) {
		alunoFacade.apagarAluno(aluno);
	}

	@RequestMapping(value = "pagamento", method = RequestMethod.POST)
	public void efetuarPagamento(@RequestBody Mensalidades mensalidade) throws Exception {
		alunoFacade.pagarMensalidade(mensalidade);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Aluno getAluno(@PathVariable("id") Long idAluno) {
		return alunoFacade.getAluno(idAluno);
	}

	@RequestMapping(value = "{id}/pagamentos/{dataInicio}/{dataFim}", method = RequestMethod.GET)
	public List<Mensalidades> getPagamentos(@PathVariable("id") Long idAluno, @PathVariable("dataInicio") String dataInicio, @PathVariable("dataFim") String dataFim) throws Exception {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		
		Date diaInicio = sdf.parse(dataInicio);
		Date diaFim = sdf.parse(dataFim);
		
		Calendar c = Calendar.getInstance();
		c.setTime(diaFim);
		c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
		diaFim = c.getTime();

		
		return alunoFacade.getPagamentos(idAluno, diaInicio, diaFim);
	}
	
	@RequestMapping(value = "{id}/turmas", method = RequestMethod.GET)
	public List<Matricula> getTurmas(@PathVariable("id") Long idAluno) {
		return alunoFacade.getMatriculas(idAluno);
	}

	@RequestMapping(value = "{id}/debitos", method = RequestMethod.GET)
	public List<Mensalidades> getDebitos(@PathVariable("id") Long idAluno) throws Exception {
		return alunoFacade.getDebitos(idAluno);
	}
	
	@RequestMapping(value = "{id}/aula-particular", method = RequestMethod.POST)
	public void cadastrarAulaParticular(@PathVariable("id") Long idAluno, @RequestBody AulaParticular aula) throws Exception {
		alunoFacade.cadastrarAulaParticular(aula, idAluno);
		
	}
	
	@RequestMapping(value = "{id}/aula-particular/{dataInicio}/{dataFim}", method = RequestMethod.GET)
	public List<Mensalidades> consultarAulaParticular(@PathVariable("id") Long idAluno, @PathVariable("dataInicio") String dataInicio, @PathVariable("dataFim") String dataFim) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		
		Date diaInicio = sdf.parse(dataInicio);
		Date diaFim = sdf.parse(dataFim);
		
		Calendar c = Calendar.getInstance();
		c.setTime(diaFim);
		c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
		diaFim = c.getTime();

		return alunoFacade.getAulasParticulares(idAluno, diaInicio, diaFim);
	}
	


}
