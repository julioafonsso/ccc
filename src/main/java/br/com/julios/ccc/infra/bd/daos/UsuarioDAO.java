package br.com.julios.ccc.infra.bd.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.UsuarioDO;


@Repository
public interface UsuarioDAO extends CrudRepository<UsuarioDO, Long> {

	public UsuarioDO findByNomeUsuario(String nomeusuario);
	
	public UsuarioDO findByLoginAndSenha(String login, String senha);
	
}
