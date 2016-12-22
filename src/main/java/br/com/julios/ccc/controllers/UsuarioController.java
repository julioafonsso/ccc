package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.Usuario;
import br.com.julios.ccc.negocio.UsuarioApi;

@Controller
@ResponseBody
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioApi usuario;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Usuario> getUsuarios(){
		return usuario.getUsuarios();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarUsuario(){
		usuario.cadastrarUsuario();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarUsuario(){
		usuario.atualizarUsuario();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void apagarUsuario(){
		usuario.apagarUsuario();
	}

}
