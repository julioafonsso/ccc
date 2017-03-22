package br.com.julios.ccc.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.MesReferencia;

@Repository
public interface MesReferenciaDAO extends JpaRepository<MesReferencia, Long> {

	public MesReferencia findByMesAndAno(long mes, long ano);
	
	
}
