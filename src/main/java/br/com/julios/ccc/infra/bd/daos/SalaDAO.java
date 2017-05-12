package br.com.julios.ccc.infra.bd.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.julios.ccc.infra.bd.model.SalaDO;

public interface SalaDAO extends JpaRepository<SalaDO, Long>{

}
