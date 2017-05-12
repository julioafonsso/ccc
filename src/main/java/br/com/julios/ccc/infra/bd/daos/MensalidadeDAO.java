package br.com.julios.ccc.infra.bd.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.MensalidadeDO;

@Repository
public interface MensalidadeDAO extends JpaRepository<MensalidadeDO, Long>{

}
