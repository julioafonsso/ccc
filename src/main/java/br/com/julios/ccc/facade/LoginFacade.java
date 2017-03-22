package br.com.julios.ccc.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.julios.ccc.domains.Usuario;
import br.com.julios.ccc.negocio.LoginApi;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class LoginFacade {

	@Autowired
	LoginApi login;
	
	public Usuario login(Usuario usuario) throws Exception {
		return login.login(usuario);
	}

}
