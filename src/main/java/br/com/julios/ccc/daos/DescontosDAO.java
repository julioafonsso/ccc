package br.com.julios.ccc.daos;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.Descontos;


@Repository
@Transactional
public interface DescontosDAO extends CrudRepository<Descontos, Long>{

}
