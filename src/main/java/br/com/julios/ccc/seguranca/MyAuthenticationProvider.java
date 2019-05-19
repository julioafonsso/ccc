package br.com.julios.ccc.seguranca;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.UsuarioDAO;
import br.com.julios.ccc.infra.bd.model.UsuarioDO;

@Service
public class MyAuthenticationProvider implements AuthenticationProvider {

	
	@Autowired
	private UsuarioDAO userDAO;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String name = authentication.getName();
		String password = authentication.getCredentials().toString();

		UsuarioDO user = userDAO.findByLoginAndSenha(name, password);
		
		
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		if(user != null)
			return new UsernamePasswordAuthenticationToken(name, password, roles);
		
		throw new BadCredentialsException("Invalid credentials!!");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
