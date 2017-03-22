package br.com.julios.ccc.daos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.TipoFluxoCaixa;

@Repository
public interface TipoFluxoCaixaDAO extends CrudRepository<TipoFluxoCaixa, Long> {

	public TipoFluxoCaixa findByNome(String nome);
	
	public List<TipoFluxoCaixa> findByIndEntradaAndDataExclusaoIsNull(boolean indentrada);

	public Iterable<TipoFluxoCaixa> findByDataExclusaoIsNull();

}
