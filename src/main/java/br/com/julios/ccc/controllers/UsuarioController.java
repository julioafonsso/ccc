package br.com.julios.ccc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.Usuario;

@Controller
@ResponseBody
@RequestMapping("/usuarios")
public class UsuarioController {

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<Usuario> getUsuarios()
	{
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarUsuario(Usuario usuario)
	{
		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarUsuario(Usuario usuario)
	{
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void apagarUsuario(Usuario usuario)
	{
	}

}
