package br.com.julios.ccc.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.UsuarioDAO;
import br.com.julios.ccc.domains.Usuario;

@Service
public class LoginApi {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	public Usuario login(Usuario usuario) throws Exception{
		Usuario user = usuarioDAO.findByLoginAndSenha(usuario.getLogin(), usuario.getSenha());
		if(user == null)
			throw new Exception("Usuario ou Senha Invalida");
		return user;	
	}
	
}
