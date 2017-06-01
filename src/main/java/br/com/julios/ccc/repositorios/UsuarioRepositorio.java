package br.com.julios.ccc.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.UsuarioDAO;
import br.com.julios.ccc.infra.bd.model.UsuarioDO;

@Service
public class UsuarioRepositorio {

	@Autowired
	UsuarioDAO uDAO;
	
	public UsuarioDO get(String login, String senha)
	{
		return uDAO.findByLoginAndSenha(login, senha);
	}
	
}
