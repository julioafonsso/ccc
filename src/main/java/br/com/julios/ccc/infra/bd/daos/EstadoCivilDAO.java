package br.com.julios.ccc.infra.bd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.EstadoCivilDO;
import br.com.julios.ccc.infra.dto.EstadoCivilDTO;

@Repository
public interface EstadoCivilDAO extends JpaRepository<EstadoCivilDO, Long>{


	@Query("select new br.com.julios.ccc.infra.dto.EstadoCivilDTO(b.id, b.nome) from EstadoCivilDO b")
	public List<EstadoCivilDTO> getEstadoCivil();
	
}
