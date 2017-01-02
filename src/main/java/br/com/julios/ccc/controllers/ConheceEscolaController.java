package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.ConheceEscola;
import br.com.julios.ccc.negocio.ConheceEscolaApi;

@Controller
@ResponseBody
@RequestMapping("/conhece-escola")
public class ConheceEscolaController {
	@Autowired
	ConheceEscolaApi conheceEscolaApi;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<ConheceEscola> getconheceEscola(){
		return conheceEscolaApi.getconheceEscola();
	}

}
