package br.com.julios.ccc.daos;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.ModalidadeTurma;


@Repository
@Transactional
public interface ModalidadeTurmaDAO extends CrudRepository<ModalidadeTurma, Long> {

	public ModalidadeTurma findOne(Long id);
	
	public ModalidadeTurma findByModalidade(String modalidade);
	

}
