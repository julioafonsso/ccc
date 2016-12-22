package br.com.julios.ccc.daos;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.ConheceEscola;

@Repository
@Transactional
public interface ConheceEscolaDAO extends CrudRepository<ConheceEscola, Long>{
	

}
