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

	@RequestMapping(value="{id}/alunos" ,method = RequestMethod.GET)
	public Iterable<Matricula> getAlunos(@PathVariable("id") Long idTurma){
		return turmaApi.getAlunosTurma(idTurma);
	}

	
	@RequestMapping(value = "{id}", method= RequestMethod.GET)
	public Turma getTurma(@PathVariable("id") long id)
	{
		return turmaApi.getTurma(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarTurma(@RequestBody Turma turma){
		turmaApi.cadastrarTurma(turma);
	}
	
	@RequestMapping(value = "matricula", method = RequestMethod.POST)
	public void cadastrarTurma(@RequestBody Matricula matricula){
		turmaApi.matricularAluno(matricula);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarTurma(@RequestBody Turma turma){
		turmaApi.atualizarTurma(turma);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void apagarTurma(@RequestBody Turma turma){
		turmaApi.apagarTurma(turma);
	}

	@RequestMapping(value="matricula" , method = RequestMethod.DELETE)
	public void apagarTurma(@RequestBody Matricula matricula){
		turmaApi.excluirAlunoTurma(matricula);
	}
}
