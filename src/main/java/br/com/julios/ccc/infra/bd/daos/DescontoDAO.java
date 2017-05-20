package br.com.julios.ccc.infra.bd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.DescontosDO;
import br.com.julios.ccc.infra.dto.DescontoDTO;

@Repository
public interface DescontoDAO extends JpaRepository<DescontosDO, Long> {

	@Query("select new br.com.julios.ccc.infra.dto.DescontoDTO(d.id, d.nome, d.valor) "
			+ "from DescontosDO d where d.dataExclusao is null")
	public List<DescontoDTO> getDescontos();

	
	@Query("select new br.com.julios.ccc.infra.dto.DescontoDTO(d.id, d.nome, d.valor) "
			+ "from DescontosDO d where d.id = ?1")
	public DescontoDTO getDescontos(Long id);

}
