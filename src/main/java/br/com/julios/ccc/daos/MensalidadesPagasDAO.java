package br.com.julios.ccc.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.julios.ccc.domains.Mensalidades;

public interface MensalidadesPagasDAO extends JpaRepository<Mensalidades, Long>{

}
