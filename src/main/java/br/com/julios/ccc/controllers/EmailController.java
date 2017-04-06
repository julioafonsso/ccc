package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.MensagemEmail;
import br.com.julios.ccc.negocio.EmailApi;

@Controller
@ResponseBody
@RequestMapping("/email")
public class EmailController {

	@Autowired
	EmailApi email;
	
	@RequestMapping(value = "mensagem", method = RequestMethod.GET)
	public MensagemEmail getMensagemEmail(){
		return email.getMensagemEmail();
	}
	
	@RequestMapping(value = "mensagem", method = RequestMethod.PUT)
	public void atualizarMensagemEmail(@RequestBody MensagemEmail msg){
		email.atualizarMensagem(msg);
	}
	
}
