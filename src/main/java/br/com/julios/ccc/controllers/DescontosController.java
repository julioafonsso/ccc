package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.Descontos;
import br.com.julios.ccc.facade.DescontosFacade;

@Controller
@ResponseBody
@RequestMapping("/descontos")
public class DescontosController {
	
	@Autowired
	DescontosFacade descontoFacade;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Descontos> getdescontos(){
		return descontoFacade.getdescontos();
	}	
	
	
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public Descontos getdesconto(@PathVariable("id") Long id){
		return descontoFacade.getdesconto(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarDesconto(@RequestBody Descontos desconto){
		descontoFacade.cadastrarDesconto(desconto);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT)
	public void altearrDesconto(@RequestBody Descontos desconto){
		descontoFacade.alterarDesconto(desconto);
	}
	
}
