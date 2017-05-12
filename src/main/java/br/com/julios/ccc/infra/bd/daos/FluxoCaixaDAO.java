package br.com.julios.ccc.infra.bd.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.FluxoCaixaDO;

@Repository
public interface FluxoCaixaDAO extends JpaRepository<FluxoCaixaDO, Long>{

}
