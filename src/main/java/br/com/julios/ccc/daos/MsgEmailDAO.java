package br.com.julios.ccc.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.MensagemEmail;

@Repository
public interface MsgEmailDAO extends JpaRepository<MensagemEmail, Long>{

	@Query("select msg from MensagemEmail where id=1")
	public String getMesage();
	
	@Query("select m from MensagemEmail m where m.id=1")
	public MensagemEmail getMensagemEmail();
}
