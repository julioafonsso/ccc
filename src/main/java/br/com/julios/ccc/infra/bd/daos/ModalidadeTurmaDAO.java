package br.com.julios.ccc.infra.bd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.ModalidadeTurmaDO;
import br.com.julios.ccc.infra.dto.turma.ModalidadeDTO;

@Repository
public interface ModalidadeTurmaDAO extends JpaRepository<ModalidadeTurmaDO, Long>{

	
	@Query("select count(*) from ModalidadeTurmaDO m where upper(m.nome) = upper(?1) and m.dataExclusao is null ")
	public Integer countModalidadePorNome(String nome);

	@Query("select new br.com.julios.ccc.infra.dto.turma.ModalidadeDTO(m.id, m.nome) from ModalidadeTurmaDO m where m.dataExclusao is null ")
	public List<ModalidadeDTO> getModalidades();

}
