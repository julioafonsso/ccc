package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.facade.ModalidadeTurmaFacade;
import br.com.julios.ccc.infra.bd.model.ModalidadeTurmaDO;

@Controller
@ResponseBody
@RequestMapping("/modalidades")
public class ModalidadeTurmaController {
	
	@Autowired
	ModalidadeTurmaFacade modalidadeTurmaFacade;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<ModalidadeTurmaDO> getmodalidadeTurma()
	{
		return null;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ModalidadeTurmaDO getdesconto(@PathVariable("id") Long id){
		return null;
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarModalidade(@RequestBody ModalidadeTurmaDO modalidade)
	{
		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarModalidade(@RequestBody ModalidadeTurmaDO modalidadeTurma)
	{
		
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void apagarModalidade(@PathVariable("id") Long id) throws Exception
	{
	}
	

}
