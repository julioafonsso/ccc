package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.NivelTurma;
import br.com.julios.ccc.negocio.NivelTurmaApi;

@Controller
@ResponseBody
@RequestMapping("/niveisTurma")
public class NivelTurmaController {
	
	@Autowired
	NivelTurmaApi nivelTurmaApi;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<NivelTurma> getnivelTurma(){
		return nivelTurmaApi.getnivelTurma();
	}

}
