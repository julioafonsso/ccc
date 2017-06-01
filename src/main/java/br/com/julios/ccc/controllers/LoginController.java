package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.bd.model.UsuarioDO;
import br.com.julios.ccc.repositorios.UsuarioRepositorio;

@Controller
@ResponseBody
@RequestMapping("/login")
public class LoginController {

	@Autowired
	UsuarioRepositorio usuarioRepositorio;
	
	@RequestMapping(method = RequestMethod.POST)
	public UsuarioDO login(@RequestBody UsuarioDO usuario) throws Exception{
		UsuarioDO retorno =  usuarioRepositorio.get(usuario.getLogin(), usuario.getSenha());
		if(retorno == null)
			throw new Exception("Login ou Senha invalidos");
		return retorno;
	}
	
}
