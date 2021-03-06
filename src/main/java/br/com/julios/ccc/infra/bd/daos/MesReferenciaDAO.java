package br.com.julios.ccc.infra.bd.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.MesReferenciaDO;


@Repository
public interface MesReferenciaDAO extends JpaRepository<MesReferenciaDO, Long>{

	MesReferenciaDO findByMesAndAno(Long mes, Long ano);

}
