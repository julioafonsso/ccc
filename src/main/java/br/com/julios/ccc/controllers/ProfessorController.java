package br.com.julios.ccc.controllers;

import java.text.ParseException;
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
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.FluxoCaixa;
import br.com.julios.ccc.domains.PagamentoProfessor;
import br.com.julios.ccc.domains.Professor;
import br.com.julios.ccc.domains.Turma;
import br.com.julios.ccc.facade.ProfessorFacade;

@Controller
@ResponseBody
@RequestMapping("/professores")
public class ProfessorController {
	
	@Autowired
	ProfessorFacade professorFacade;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Professor> getProfessores(){
		return professorFacade.getProfessores();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarProfessor(@RequestBody Professor professor) throws Exception{
		professorFacade.cadastrarProfessor(professor);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarProfessor(@RequestBody Professor professor) throws Exception{
		professorFacade.atualizarProfessor(professor);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void apagarProfessor(@RequestBody Professor professor){
		professorFacade.apagarProfessor(professor);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Professor getProfessor(@PathVariable("id") Long idProfessor){
		return professorFacade.getProfessor(idProfessor);
	}
	
	@RequestMapping(value = "detalhe-pagamento/{id}", method = RequestMethod.GET)
	public List<PagamentoProfessor> getDetalhePagamento(@PathVariable("id") Long idProfessor){
		return professorFacade.getDetalhePagamento(idProfessor);
	}
	
	@RequestMapping(value = "{id}/turmas", method = RequestMethod.GET)
	public List<Turma> getTurmas(@PathVariable("id") Long idProfessor) {
		return professorFacade.getTurmas(idProfessor);
	}
	
	@RequestMapping(value = "{id}/recibos/{dataInicio}/{dataFim}", method = RequestMethod.GET)
	public List<FluxoCaixa> getRecibos(@PathVariable("id") Long idProfessor, @PathVariable("dataInicio") String dataInicio, @PathVariable("dataFim") String dataFim) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		
		Date diaInicio = sdf.parse(dataInicio);
		Date diaFim = sdf.parse(dataFim);
		
		Calendar c = Calendar.getInstance();
		c.setTime(diaFim);
		c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
		diaFim = c.getTime();
		
		return professorFacade.getRecibos(idProfessor,diaInicio, diaFim);
	}
	
	@RequestMapping(value = "{id}/salario", method = RequestMethod.POST)
	public void cadastrarRecebimento(@PathVariable("id") Long idProfessor) throws Exception{
		 professorFacade.pagamentoProfessor(idProfessor);
	}
	
	@RequestMapping(value = "{id}/salario-pendente", method = RequestMethod.GET)
	public List<PagamentoProfessor> getSalarioProfessorPendente(@PathVariable("id") Long idProfessor){
		return professorFacade.getSalarioProfessorPendente(idProfessor);
	}

}
