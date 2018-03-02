package br.com.julios.ccc.infra.bd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.TipoFluxoCaixaDO;
import br.com.julios.ccc.infra.dto.fluxo_caixa.ConsultaTipoFluxoDTO;

@Repository
public interface TipoFluxoCaixaDAO extends JpaRepository<TipoFluxoCaixaDO, Long>{

	@Query("select t from TipoFluxoCaixaDO t where upper(t.nome) = upper(?1) and  t.indEntrada = ?2 and t.dataExclusao is null ")
	public TipoFluxoCaixaDO get(String nome,boolean indEntrada);
	
	@Query("select new br.com.julios.ccc.infra.dto.fluxo_caixa.ConsultaTipoFluxoDTO(t.id, t.nome, t.indEntrada)"
			+ "from TipoFluxoCaixaDO t where  t.dataExclusao is null order by t.nome")
	public List<ConsultaTipoFluxoDTO> get();
	
	@Query("select new br.com.julios.ccc.infra.dto.fluxo_caixa.ConsultaTipoFluxoDTO(t.id, t.nome, t.indEntrada)"
			+ "from TipoFluxoCaixaDO t where t.indEntrada = ?1 and t.dataExclusao is null ")
	public List<ConsultaTipoFluxoDTO> get(boolean indEntrada);

	@Query("select new br.com.julios.ccc.infra.dto.fluxo_caixa.ConsultaTipoFluxoDTO(t.id, t.nome, t.indEntrada)"
			+ "from TipoFluxoCaixaDO t where t.id = ?1 ")
	public ConsultaTipoFluxoDTO get(Long id);

}
