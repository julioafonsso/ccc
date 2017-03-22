package br.com.julios.ccc.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.Salas;


@Repository
public interface SalasDAO extends CrudRepository<Salas, Long> {


}
