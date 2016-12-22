package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.Turma;
import br.com.julios.ccc.negocio.TurmaApi;

@Controller
@ResponseBody
@RequestMapping("/turmas")
public class TurmaController {
	
	@Autowired
	TurmaApi turma;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Turma> getTurmas(){
		return turma.getTurmas();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarTurma(){
		turma.cadastrarTurma();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarTurma(){
		turma.atualizarTurma();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void apagarTurma(){
		turma.apagarTurma();
	}

}
