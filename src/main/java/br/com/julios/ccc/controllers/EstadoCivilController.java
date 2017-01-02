package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.EstadoCivil;
import br.com.julios.ccc.negocio.EstadoCivilApi;

@Controller
@ResponseBody
@RequestMapping("/estadosCivis")
public class EstadoCivilController {
	
	@Autowired
	EstadoCivilApi estadoCivilApi;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<EstadoCivil> getestadoCivil(){
		return estadoCivilApi.getestadoCivil();
		
	}

}