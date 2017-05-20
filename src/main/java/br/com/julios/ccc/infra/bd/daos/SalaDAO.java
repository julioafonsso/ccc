package br.com.julios.ccc.infra.bd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.julios.ccc.infra.bd.model.SalaDO;
import br.com.julios.ccc.infra.dto.turma.SalaDTO;

public interface SalaDAO extends JpaRepository<SalaDO, Long>{

	
	@Query("select new br.com.julios.ccc.infra.dto.turma.SalaDTO(s.id, s.nome) from SalaDO s ")
	public List<SalaDTO> getSalas();
}
