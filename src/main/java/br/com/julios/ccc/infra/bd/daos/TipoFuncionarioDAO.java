package br.com.julios.ccc.infra.bd.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.TipoFuncionarioDO;

@Repository
public interface TipoFuncionarioDAO extends JpaRepository<TipoFuncionarioDO, Long>{

}
