package br.com.julios.ccc.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.Usuario;


@Repository
public interface UsuarioDAO extends CrudRepository<Usuario, Long> {

	public Usuario findByNomeUsuario(String nomeusuario);
	
	public Usuario findByLoginAndSenha(String login, String senha);
	
}
