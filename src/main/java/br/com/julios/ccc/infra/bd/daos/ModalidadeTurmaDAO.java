package br.com.julios.ccc.infra.bd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.ModalidadeTurmaDO;
import br.com.julios.ccc.infra.dto.turma.ModalidadeDTO;

@Repository
public interface ModalidadeTurmaDAO extends JpaRepository<ModalidadeTurmaDO, Long>{

	@Query("select new br.com.julios.ccc.infra.dto.turma.ModalidadeDTO(m.id, m.nome) from ModalidadeTurmaDO m where m.dataExclusao is null ")
	public List<ModalidadeDTO> getModalidades();

	@Query("select m from ModalidadeTurmaDO m where upper(m.nome) = upper(?1)")
	public ModalidadeTurmaDO getModalidadePorNome(String nome);

	@Query("select new br.com.julios.ccc.infra.dto.turma.ModalidadeDTO(m.id, m.nome) from ModalidadeTurmaDO m where m.id = ?1 ")
	public ModalidadeDTO get(Long id);

}
