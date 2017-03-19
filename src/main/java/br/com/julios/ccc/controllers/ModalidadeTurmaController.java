package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.ModalidadeTurma;
import br.com.julios.ccc.facade.ModalidadeTurmaFacade;

@Controller
@ResponseBody
@RequestMapping("/modalidades")
public class ModalidadeTurmaController {
	
	@Autowired
	ModalidadeTurmaFacade modalidadeTurmaFacade;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<ModalidadeTurma> getmodalidadeTurma()
	{
		return modalidadeTurmaFacade.getmodalidadeTurma();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ModalidadeTurma getdesconto(@PathVariable("id") Long id){
		return modalidadeTurmaFacade.getmodalidadeTurma(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarModalidade(@RequestBody ModalidadeTurma modalidade)
	{
		modalidadeTurmaFacade.cadastarModalidade(modalidade);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarModalidade(@RequestBody ModalidadeTurma modalidadeTurma)
	{
		modalidadeTurmaFacade.atualizarModalidade(modalidadeTurma);
		
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void apagarModalidade(@RequestBody 	ModalidadeTurma modalidadeTurma)
	{
		modalidadeTurmaFacade.apagarModalidade(modalidadeTurma);
	}
	

}
