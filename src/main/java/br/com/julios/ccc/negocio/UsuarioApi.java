package br.com.julios.ccc.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.UsuarioDAO;
import br.com.julios.ccc.domains.Usuario;

@Service
public class UsuarioApi {
	
	@Autowired
	UsuarioDAO usuarioDAO;

	public Iterable<Usuario> getUsuarios() {
				return usuarioDAO.findAll();
	}

	public void cadastrarUsuario() {
				
	}

	public void atualizarUsuario() {
				
	}

	public void apagarUsuario() {
				
	}

}
