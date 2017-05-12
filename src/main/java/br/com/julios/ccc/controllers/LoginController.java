package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.facade.LoginFacade;
import br.com.julios.ccc.infra.bd.model.UsuarioDO;

@Controller
@ResponseBody
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginFacade login;
	
	@RequestMapping(method = RequestMethod.POST)
	public UsuarioDO login(@RequestBody UsuarioDO usuario) throws Exception{
		return login.login(usuario);
	}
	
}
