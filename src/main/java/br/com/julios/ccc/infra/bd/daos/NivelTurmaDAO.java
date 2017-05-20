package br.com.julios.ccc.infra.bd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.NivelTurmaDO;
import br.com.julios.ccc.infra.dto.turma.NivelTurmaDTO;

@Repository
public interface NivelTurmaDAO extends JpaRepository<NivelTurmaDO, Long>{

	@Query("select new br.com.julios.ccc.infra.dto.turma.NivelTurmaDTO(s.id, s.nome) from NivelTurmaDO s ")
	public List<NivelTurmaDTO> getNiveis();
	
}
