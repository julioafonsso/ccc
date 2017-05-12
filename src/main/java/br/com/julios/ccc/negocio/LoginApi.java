package br.com.julios.ccc.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.UsuarioDAO;
import br.com.julios.ccc.infra.bd.model.UsuarioDO;

@Service
public class LoginApi {

	@Autowired
	UsuarioDAO usuarioDAO;
	
	public UsuarioDO login(UsuarioDO usuario) throws Exception{
//		UsuarioDO user = usuarioDAO.findByLoginAndSenha(usuario.getLogin(), usuario.getSenha());
//		if(user == null)
//			throw new Exception("Usuario ou Senha Invalida");
//		return user;	
		return null;
	}
	
}
