package br.com.julios.ccc.infra.bd.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.ModalidadeTurmaDO;

@Repository
public interface ModalidadeTurmaDAO extends JpaRepository<ModalidadeTurmaDO, Long>{

}
