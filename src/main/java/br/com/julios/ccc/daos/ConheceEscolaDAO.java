package br.com.julios.ccc.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.ConheceEscola;

@Repository
public interface ConheceEscolaDAO extends CrudRepository<ConheceEscola, Long>{
	

}
