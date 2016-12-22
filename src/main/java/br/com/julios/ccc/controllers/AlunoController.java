package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.Aluno;
import br.com.julios.ccc.negocio.AlunoApi;

@Controller
@ResponseBody
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	AlunoApi aluno;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Aluno> getAlunos()
	{
		return aluno.getAlunos();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarAluno()
	{
		aluno.cadastrarAluno();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarAluno()
	{
		aluno.atualizarAluno();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void apagarAluno()
	{
		aluno.apagarAluno();
	}
}
