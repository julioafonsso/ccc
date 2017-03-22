package br.com.julios.ccc.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.Descontos;


@Repository
public interface DescontosDAO extends CrudRepository<Descontos, Long>{

	Iterable<Descontos> findByDataExclusaoIsNull();

}
