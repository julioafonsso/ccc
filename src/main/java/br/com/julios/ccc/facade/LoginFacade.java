package br.com.julios.ccc.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.domains.Usuario;
import br.com.julios.ccc.negocio.LoginApi;

@Service
public class LoginFacade {

	@Autowired
	LoginApi login;
	
	public Usuario login(Usuario usuario) throws Exception {
		return login.login(usuario);
	}

}
