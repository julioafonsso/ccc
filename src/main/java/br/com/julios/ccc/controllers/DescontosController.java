	package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.facade.DescontosFacade;
import br.com.julios.ccc.infra.bd.model.DescontosDO;

@Controller
@ResponseBody
@RequestMapping("/descontos")
public class DescontosController {
	
	@Autowired
	DescontosFacade descontoFacade;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<DescontosDO> getdescontos(){
		return null;
	}	
	
	
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public DescontosDO getdesconto(@PathVariable("id") Long id){
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarDesconto(@RequestBody DescontosDO desconto){
	}
	
	
	@RequestMapping(method = RequestMethod.PUT)
	public void altearrDesconto(@RequestBody DescontosDO desconto){
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable("id") Long id) throws Exception{
	}
}
