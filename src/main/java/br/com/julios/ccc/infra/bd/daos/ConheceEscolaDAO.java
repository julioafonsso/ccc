package br.com.julios.ccc.infra.bd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.ConheceEscolaDO;
import br.com.julios.ccc.infra.dto.ComoConheceuEscolaDTO;

@Repository
public interface ConheceEscolaDAO extends JpaRepository<ConheceEscolaDO, Long> {


	@Query("select new br.com.julios.ccc.infra.dto.ComoConheceuEscolaDTO(b.id, b.nome) from ConheceEscolaDO b")
	public List<ComoConheceuEscolaDTO> getListaComoConheceu();
	
}

