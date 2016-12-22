package br.com.julios.ccc.daos;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.FluxoCaixa;

@Repository
@Transactional
public interface FluxoCaixaDAO extends CrudRepository<FluxoCaixa, Long> {

	public FluxoCaixa findByValor(double valor);
	
	public FluxoCaixa findByDescricao(String descricao);
	
	public FluxoCaixa findByDataFluxo(Date datafluxo);

}
