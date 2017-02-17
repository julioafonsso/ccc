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
import br.com.julios.ccc.domains.Salario;
import br.com.julios.ccc.domains.TurmaProfessor;
import br.com.julios.ccc.negocio.ProfessorApi;

@Controller
@ResponseBody
@RequestMapping("/professores")
public class ProfessorController {
	
	@Autowired
	ProfessorApi professorApi;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Professor> getProfessores(){
		return professorApi.getProfessores();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarProfessor(@RequestBody Professor professor){
		
		professorApi.cadastrarProfessor(professor);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarProfessor(@RequestBody Professor professor){
		professorApi.atualizarProfessor(professor);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void apagarProfessor(@RequestBody Professor professor){
		professorApi.apagarProfessor(professor);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Professor getProfessor(@PathVariable("id") Long idProfessor){
		return professorApi.getProfessor(idProfessor);
	}
	
	@RequestMapping(value = "{id}/turmas", method = RequestMethod.GET)
	public List<TurmaProfessor> getTurmas(@PathVariable("id") Long idProfessor) {
		return professorApi.getTurmas(idProfessor);
	}
	
	@RequestMapping(value = "{id}/salario-pendente", method = RequestMethod.GET)
	public List<Salario> getSalarioProfessorPendente(@PathVariable("id") Long idProfessor){
		return professorApi.getSalarioProfessorPendente(idProfessor);
	}

}
