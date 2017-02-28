package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.Turma;
import br.com.julios.ccc.facade.MatriculaFacade;
import br.com.julios.ccc.facade.TurmaFacade;

@Controller
@ResponseBody
@RequestMapping("/turmas")
public class TurmaController {
	
	@Autowired
	TurmaFacade turmaFacade;
	
	@Autowired 
	MatriculaFacade matriculaFacade;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Turma> getTurmas(){
		return turmaFacade.getTurmas();
	}

	@RequestMapping(value="{id}/alunos" ,method = RequestMethod.GET)
	public Iterable<Matricula> getAlunos(@PathVariable("id") Long idTurma){
		return turmaFacade.getAlunosTurma(idTurma);
	}

	
	@RequestMapping(value = "{id}", method= RequestMethod.GET)
	public Turma getTurma(@PathVariable("id") long id)
	{
		return turmaFacade.getTurma(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarTurma(@RequestBody Turma turma) throws Exception{
		turmaFacade.cadastrarTurma(turma);
	}
	
	@RequestMapping(value = "matricula", method = RequestMethod.POST)
	public void matricularAluno(@RequestBody Matricula matricula) throws Exception{
		matriculaFacade.matricularAluno(matricula);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarTurma(@RequestBody Turma turma){
		turmaFacade.atualizarTurma(turma);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void apagarTurma(@RequestBody Turma turma){
		turmaFacade.apagarTurma(turma);
	}

	@RequestMapping(value="matricula/{id}" , method = RequestMethod.DELETE)
	public void apagarTurma(@PathVariable("id") long id){
		matriculaFacade.excluirMatricula(id);
	}
}
