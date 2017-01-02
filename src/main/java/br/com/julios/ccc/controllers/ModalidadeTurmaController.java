package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.ModalidadeTurma;
import br.com.julios.ccc.negocio.ModalidadeTurmaApi;

@Controller
@ResponseBody
@RequestMapping("/modalidades/turmas")
public class ModalidadeTurmaController {
	
	@Autowired
	ModalidadeTurmaApi modalidadeTurmaApi;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<ModalidadeTurma> getmodalidadeTurma()
	{
		return modalidadeTurmaApi.getmodalidadeTurma();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarModalidade(@RequestBody ModalidadeTurma modalidade)
	{
		modalidadeTurmaApi.cadastarModalidade(modalidade);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarModalidade(@RequestBody ModalidadeTurma modalidadeTurma)
	{
		modalidadeTurmaApi.atualizarModalidade(modalidadeTurma);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void apagarModalidade(@RequestBody 	ModalidadeTurma modalidadeTurma)
	{
		modalidadeTurmaApi.apagarModalidade(modalidadeTurma);
	}
	

}
