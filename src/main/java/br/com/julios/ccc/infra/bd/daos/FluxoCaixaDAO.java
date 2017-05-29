package br.com.julios.ccc.infra.bd.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.FluxoCaixaDO;
import br.com.julios.ccc.infra.bd.model.TipoFluxoCaixaDO;

@Repository
public interface FluxoCaixaDAO extends JpaRepository<FluxoCaixaDO, Long>{

	
	@Query("select count(*) from FluxoCaixaDO f where f.tipoFluxo = ?1")
	public Long getQtdFluxoCadastrados(TipoFluxoCaixaDO tipoFluxoCaixaDO);

}
