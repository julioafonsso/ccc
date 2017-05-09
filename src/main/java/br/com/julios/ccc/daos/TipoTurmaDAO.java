package br.com.julios.ccc.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.TipoTurma;

@Repository
public interface TipoTurmaDAO extends JpaRepository<TipoTurma, Long>{
	

}
