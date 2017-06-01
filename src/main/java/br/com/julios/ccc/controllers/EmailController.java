package br.com.julios.ccc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.bd.model.MensagemEmailDO;

@Controller
@ResponseBody
@RequestMapping("/email")
public class EmailController {

	
	@RequestMapping(value = "mensagem", method = RequestMethod.GET)
	public MensagemEmailDO getMensagemEmail(){
		return null;
	}
	
	@RequestMapping(value = "mensagem", method = RequestMethod.PUT)
	public void atualizarMensagemEmail(@RequestBody MensagemEmailDO msg){
	}
	
}
