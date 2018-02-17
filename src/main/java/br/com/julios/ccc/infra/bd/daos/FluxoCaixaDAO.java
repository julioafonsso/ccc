package br.com.julios.ccc.infra.bd.daos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.FluxoCaixaDO;
import br.com.julios.ccc.infra.bd.model.TipoFluxoCaixaDO;
import br.com.julios.ccc.infra.dto.extrato.ExtratoConsolidadoDTO;
import br.com.julios.ccc.infra.dto.extrato.ExtratoDetalhadoDTO;

@Repository
public interface FluxoCaixaDAO extends JpaRepository<FluxoCaixaDO, Long>{

	
	@Query("select count(*) from FluxoCaixaDO f where f.tipoFluxo = ?1")
	public Long getQtdFluxoCadastrados(TipoFluxoCaixaDO tipoFluxoCaixaDO);

	
	@Query("select new br.com.julios.ccc.infra.dto.extrato.ExtratoConsolidadoDTO("
			+ " f.tipoFluxo.id,"
			+ " f.tipoFluxo.nome , "
			+ " count(*),"
			+ " sum(f.valor) ) from FluxoCaixaDO f "
			+ " where (f.data between ?1 and ?2 ) and f.tipoFluxo.indEntrada = ?3 group by f.tipoFluxo ")
	public List<ExtratoConsolidadoDTO> getExtratoConsolidadodo(Date dInicio, Date dFim, boolean b);

	
	@Query("select new br.com.julios.ccc.infra.dto.extrato.ExtratoDetalhadoDTO("
			+ "f.id, "
			+ " f.data, "
			+ " f.valor, "
			+ " f.quantidade,"
			+ " f.observacao,"
			+ " f.descricao ) from FluxoCaixaDO f "
			+ " where (f.data between ?1 and ?2 ) and f.tipoFluxo.id = ?3  ")
	public List<ExtratoDetalhadoDTO> getExtratoDetalhado(Date dInicio, Date dFim, Long idTipo);
}
