package br.com.julios.ccc.infra.bd.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.EstadoCivilDO;

@Repository
public interface EstadoCivilDAO extends JpaRepository<EstadoCivilDO, Long>{

}
