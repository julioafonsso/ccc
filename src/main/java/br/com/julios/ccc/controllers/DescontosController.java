package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.Descontos;
import br.com.julios.ccc.negocio.DescontosApi;

@Controller
@ResponseBody
@RequestMapping("/descontos")
public class DescontosController {
	
	@Autowired
	DescontosApi descontosApi;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Descontos> getdescontos(){
		return descontosApi.getdescontos();
	}	
}
