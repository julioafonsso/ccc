package br.com.julios.ccc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.componentes.EmailApi;
import br.com.julios.ccc.infra.bd.daos.AlunoDAO;
import br.com.julios.ccc.infra.bd.daos.ModalidadeTurmaDAO;
import br.com.julios.ccc.infra.bd.daos.TurmaDAO;
import br.com.julios.ccc.infra.bd.model.MensagemEmailDO;
import br.com.julios.ccc.infra.dto.EmailDTO;

@Controller
@ResponseBody
@RequestMapping("/email")
public class EmailController {

	@Autowired
	EmailApi email;

	@Autowired
	AlunoDAO alunoDAO;

	@Autowired
	ModalidadeTurmaDAO modDAO;

	@Autowired
	TurmaDAO turmaDAO;

	@RequestMapping(value = "teste", method = RequestMethod.GET)
	public void teste() throws Exception {
		this.email.emailContatoTeste();
		this.email.emailReciboTeste();
	}

	@RequestMapping(value = "mensagem", method = RequestMethod.GET)
	public MensagemEmailDO getMensagemEmail() {
		return this.email.getMensagemEmail();
	}

	@RequestMapping(value = "mensagem", method = RequestMethod.PUT)
	public void atualizarMensagemEmail(@RequestBody MensagemEmailDO msg) {
		this.email.atualizarMensagem(msg);
	}

	@RequestMapping(value = "mkt", method = RequestMethod.POST)
	public void enviarEmailMarketing(@RequestBody EmailDTO emailDTO) throws Exception {
		this.email.enviarEmailMKT(emailDTO);
	}

	@RequestMapping(value = "alunos", method = RequestMethod.GET)
	public String getEmailsTodosAlunos(@RequestParam("idModalidade") Long idModalidade,
			@RequestParam("ativo") boolean ativo) throws Exception {
		return this.email.getEmailsAlunos(idModalidade, ativo);
	}

}
