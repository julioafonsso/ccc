package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarDesconto(@RequestBody Descontos desconto){
		descontoFacade.cadastrarDesconto(desconto);
	}
	
	
}
