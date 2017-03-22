package br.com.julios.ccc.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.EstadoCivil;

@Repository
public interface EstadoCivilDAO extends CrudRepository<EstadoCivil, Long> {

}
