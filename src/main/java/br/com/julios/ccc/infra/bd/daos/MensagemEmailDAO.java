package br.com.julios.ccc.infra.bd.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.MensagemEmailDO;

@Repository
public interface MensagemEmailDAO extends JpaRepository<MensagemEmailDO, Long>{

	@Query("select m from MensagemEmailDO m where m.id = 1 ")
	public MensagemEmailDO getMensagem();
	
}
