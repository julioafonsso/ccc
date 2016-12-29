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
	TurmaApi turmaApi;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Turma> getTurmas(){
		return turmaApi.getTurmas();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarTurma(Turma turma){
		turmaApi.cadastrarTurma(turma);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarTurma(Turma turma){
		turmaApi.atualizarTurma(turma);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void apagarTurma(Turma turma){
		turmaApi.apagarTurma(turma);
	}

}
