package br.com.julios.ccc.daos;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.Usuario;


@Repository
@Transactional
public interface UsuarioDAO extends CrudRepository<Usuario, Long> {

	public Usuario findByNomeUsuario(String nomeusuario);
	
	public Usuario findByLogin(String login);
	
	public Usuario findBySenha(String senha);
	
	public Usuario findByDataExclusao(Date dataexclusao);

}
