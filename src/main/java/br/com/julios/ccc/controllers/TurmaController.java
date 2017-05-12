package br.com.julios.ccc.controllers;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.facade.MatriculaFacade;
import br.com.julios.ccc.facade.TurmaFacade;
import br.com.julios.ccc.infra.bd.model.MatriculaDO;
import br.com.julios.ccc.infra.bd.model.TurmaDO;

@Controller
@ResponseBody
@RequestMapping("/turmas")
public class TurmaController {
	
	@Autowired
	TurmaFacade turmaFacade;
	
	@Autowired 
	MatriculaFacade matriculaFacade;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<TurmaDO> getTurmas(){
		return null;
	}

	@RequestMapping(value="{id}/alunos" ,method = RequestMethod.GET)
	public Iterable<MatriculaDO> getAlunos(@PathVariable("id") Long idTurma){
		return null;
	}

	
	@RequestMapping(value = "{id}", method= RequestMethod.GET)
	public TurmaDO getTurma(@PathVariable("id") long id)
	{
		return null;
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarTurma(@RequestBody TurmaDO turma) throws Exception{
	}
	
	@RequestMapping(value = "matricula", method = RequestMethod.POST)
	public void matricularAluno(@RequestBody MatriculaDO matricula) throws Exception{
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarTurma(@RequestBody TurmaDO turma) throws Exception{
	}
	
	@RequestMapping(value="{id}" , method = RequestMethod.DELETE)
	public void apagarTurma(@PathVariable("id") long id) throws Exception{
	}
	
	@RequestMapping(value="matricula/{id}/desconto" , method = RequestMethod.DELETE)
	public void apagarDesconto(@PathVariable("id") long id) throws Exception{
	}

	@RequestMapping(value="matricula/{id}/desconto/{idDesconto}" , method = RequestMethod.PUT)
	public void alterarDesconto(@PathVariable("id") long id, @PathVariable("idDesconto") long idDesconto) throws Exception{
	}
	
	@RequestMapping(value="matricula/{id}" , method = RequestMethod.DELETE)
	public void excluirMatricula(@PathVariable("id") long id) throws ParseException{
	}
}
