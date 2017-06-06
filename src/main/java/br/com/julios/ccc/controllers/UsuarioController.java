package br.com.julios.ccc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.bd.model.UsuarioDO;

@Controller
@ResponseBody
@RequestMapping("/usuarios")
public class UsuarioController {

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<UsuarioDO> getUsuarios()
	{
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarUsuario(UsuarioDO usuario)
	{
		
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public void atualizarUsuario(UsuarioDO usuario)
	{
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void apagarUsuario(UsuarioDO usuario)
	{
	}

}
