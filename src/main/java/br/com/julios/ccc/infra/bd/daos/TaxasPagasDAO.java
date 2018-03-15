package br.com.julios.ccc.infra.bd.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.julios.ccc.infra.bd.model.TaxasPagasDO;

public interface TaxasPagasDAO extends JpaRepository<TaxasPagasDO, Long>{

}
