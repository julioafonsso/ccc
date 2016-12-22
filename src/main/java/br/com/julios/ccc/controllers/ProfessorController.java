package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.Professor;
import br.com.julios.ccc.negocio.ProfessorApi;

@Controller
@ResponseBody
@RequestMapping("/professores")
public class ProfessorController {
	
	@Autowired
	ProfessorApi professor;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Professor> getProfessores(){
		return professor.getProfessores();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarProfessor(){
		professor.cadastrarProfessor();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarProfessor(){
		professor.atualizarProfessor();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void apagarProfessor(){
		professor.apagarProfessor();
	}

}
