package br.com.julios.ccc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.Professor;
import br.com.julios.ccc.domains.TurmaProfessor;
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
	public void cadastrarProfessor(@RequestBody Professor professor){
		
		professorFacade.cadastrarProfessor(professor);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarProfessor(@RequestBody Professor professor){
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
	
	@RequestMapping(value = "{id}/turmas", method = RequestMethod.GET)
	public List<TurmaProfessor> getTurmas(@PathVariable("id") Long idProfessor) {
		return professorFacade.getTurmas(idProfessor);
	}

}
