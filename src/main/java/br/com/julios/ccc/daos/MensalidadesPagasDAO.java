package br.com.julios.ccc.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.Mensalidades;

@Repository
public interface MensalidadesPagasDAO extends JpaRepository<Mensalidades, Long>{

}
