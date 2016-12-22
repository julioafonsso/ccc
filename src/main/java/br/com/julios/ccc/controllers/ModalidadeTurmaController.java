package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.ModalidadeTurma;
import br.com.julios.ccc.negocio.ModalidadeTurmaApi;

@Controller
@ResponseBody
@RequestMapping("/modalidadesTurma")
public class ModalidadeTurmaController {
	
	@Autowired
	ModalidadeTurmaApi modalidadeTurma;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<ModalidadeTurma> getmodalidadeTurma(){
		return modalidadeTurma.getmodalidadeTurma();
	}

}
