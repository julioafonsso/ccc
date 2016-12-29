package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.DiasSemana;
import br.com.julios.ccc.negocio.DiasSemanaApi;

@Controller
@ResponseBody
@RequestMapping("/diasSemana")
public class DiasSemanaController {
	
	@Autowired
	DiasSemanaApi diasSemanaApi;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<DiasSemana> getdiasSemana(){
		return diasSemanaApi.getdiasSemana();
	}

}
