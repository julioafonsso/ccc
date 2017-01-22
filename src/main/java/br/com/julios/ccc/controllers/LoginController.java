package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.Usuario;
import br.com.julios.ccc.negocio.LoginApi;

@Controller
@ResponseBody
@RequestMapping("/login")
public class LoginController {

	@Autowired
	LoginApi login;
	
	@RequestMapping(method = RequestMethod.POST)
	public Usuario login(@RequestBody Usuario usuario) throws Exception{
		return login.login(usuario);
	}
	
}
