package br.com.julios.ccc.daos;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.FluxoCaixa;
import br.com.julios.ccc.domains.TipoFluxoCaixa;

@Repository
@Transactional
public interface FluxoCaixaDAO extends JpaRepository<FluxoCaixa, Long> {

	public FluxoCaixa findByValor(double valor);
	
	public FluxoCaixa findByDescricao(String descricao);
	
	public FluxoCaixa findByDataFluxo(Date datafluxo);

	@Query("select sum(valor) from FluxoCaixa where dataFluxo < :data")
	public double getSaldoAteData(@Param("data") Date data);
	
	public List<FluxoCaixa> findByDataFluxoBetweenOrderByDataFluxoDesc(Date dataInicial, Date dataFinal);
	
	
	@Query("select sum(f.valor), f.tipoFluxo.nome from FluxoCaixa f where f.tipoFluxo.indEntrada = :indEntrada and f.dataFluxo between :datInicial and :datFinal group by f.tipoFluxo")
	public Object[] findSum(@Param("datInicial")Date datInicial, @Param("datFinal")Date datFinal , @Param("indEntrada") boolean indEntrada);
	
	
//	
//	public List<FluxoCaixa> getExtratoMensal(int ano, int mes);
//	
	
}



