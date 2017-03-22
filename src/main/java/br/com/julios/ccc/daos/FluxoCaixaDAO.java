package br.com.julios.ccc.daos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.FluxoCaixa;
import br.com.julios.ccc.domains.TipoFluxoCaixa;

@Repository
public interface FluxoCaixaDAO extends JpaRepository<FluxoCaixa, Long> {

	public FluxoCaixa findByValor(double valor);
	
	public FluxoCaixa findByDescricao(String descricao);
	
	public FluxoCaixa findByData(Date datafluxo);

	@Query("select sum(valor) from FluxoCaixa where data < :data")
	public Double getSaldoAteData(@Param("data") Date data);
	
	public List<FluxoCaixa> findByDataBetweenOrderByDataDesc(Date dataInicial, Date dataFinal);
	
	public List<FluxoCaixa> findByDataBetweenOrderByData(Date dataInicial, Date dataFinal);
	
	public List<FluxoCaixa> findByTipoFluxoAndDataBetweenOrderByData(TipoFluxoCaixa tipoFluxo, Date dataInicial, Date dataFinal);
	
	
	@Query("select count(*), sum(f.valor), f.tipoFluxo.nome, f.tipoFluxo.id from FluxoCaixa f where f.tipoFluxo.indEntrada = :indEntrada and f.data between :datInicial and :datFinal group by f.tipoFluxo")
	public Object[] findConsolidado(@Param("datInicial")Date datInicial, @Param("datFinal")Date datFinal , @Param("indEntrada") boolean indEntrada);
	
	
//	
//	public List<FluxoCaixa> getExtratoMensal(int ano, int mes);
//	
	
}



