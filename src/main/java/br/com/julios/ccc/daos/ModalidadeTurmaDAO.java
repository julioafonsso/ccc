package br.com.julios.ccc.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.ModalidadeTurma;


@Repository
public interface ModalidadeTurmaDAO extends CrudRepository<ModalidadeTurma, Long> {

	
	public ModalidadeTurma findByNome(String modalidade);
	
	public List<ModalidadeTurma> findByDataExclusaoIsNull();
	

}
