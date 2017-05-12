package br.com.julios.ccc.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.UsuarioDAO;
import br.com.julios.ccc.infra.bd.model.UsuarioDO;

@Service
public class UsuarioApi {
	
	@Autowired
	UsuarioDAO usuarioDAO;

	public Iterable<UsuarioDO> getUsuarios() {
				return usuarioDAO.findAll();
	}

	public void cadastrarUsuario(UsuarioDO usuario) {
		usuarioDAO.save(usuario);
				
	}

	public void atualizarUsuario(UsuarioDO usuario) {
		usuarioDAO.save(usuario);
				
	}

	public void apagarUsuario(UsuarioDO usuario) {
		usuarioDAO.delete(usuario);
				
	}

}
