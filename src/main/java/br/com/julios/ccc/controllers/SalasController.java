package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.bd.model.SalaDO;
import br.com.julios.ccc.negocio.SalasApi;

@Controller
@ResponseBody
@RequestMapping("/salas")
public class SalasController {
	
	@Autowired
	SalasApi salaApi;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<SalaDO> getsala(){
		return null;
	}

}
