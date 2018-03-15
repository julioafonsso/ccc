package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.bd.model.MatriculaDO;
import br.com.julios.ccc.infra.bd.model.MensalidadeDO;
import br.com.julios.ccc.repositorios.MensalidadeRepositorio;

@Controller
@ResponseBody
@Transactional(propagation = Propagation.REQUIRED)
@RequestMapping("/mensalidades")
public class MensalidadeController {
	
	@Autowired
	MensalidadeRepositorio rep;
	
	@RequestMapping(value = "{idMensalidade}", method = RequestMethod.DELETE)
	public void excluir(@PathVariable("idMensalidade") Long idMensalidade) throws Exception{
		MensalidadeDO mensalidade = rep.getMensalidade(idMensalidade);
		
		mensalidade.apagar();
		
	}

}
