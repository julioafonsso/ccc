package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.componentes.EmailApi;
import br.com.julios.ccc.infra.bd.daos.MensagemEmailDAO;
import br.com.julios.ccc.infra.bd.model.MensagemEmailDO;

@Controller
@ResponseBody
@RequestMapping("/email")
public class EmailController {

	@Autowired
	EmailApi email;
	
	@Autowired
	MensagemEmailDAO msgDAO;
	
	@RequestMapping(value = "teste", method = RequestMethod.GET)
	public void teste() throws Exception {
		this.email.emailContatoTeste();
		this.email.emailReciboTeste();
	}
	
	@RequestMapping(value = "mensagem", method = RequestMethod.GET)
	public MensagemEmailDO getMensagemEmail(){
		return msgDAO.getMensagem();
	}
	
	@RequestMapping(value = "mensagem", method = RequestMethod.PUT)
	public void atualizarMensagemEmail(@RequestBody MensagemEmailDO msg){
		MensagemEmailDO msgAntiga = msgDAO.getMensagem();
		msgAntiga.setMsg(msg.getMsg());
		msgDAO.save(msgAntiga);
	}
	
}
