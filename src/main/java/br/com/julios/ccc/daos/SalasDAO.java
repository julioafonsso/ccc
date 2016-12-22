package br.com.julios.ccc.daos;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.Salas;


@Repository
@Transactional
public interface SalasDAO extends CrudRepository<Salas, Long> {


}
