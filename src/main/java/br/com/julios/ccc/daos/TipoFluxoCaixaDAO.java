package br.com.julios.ccc.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.TipoFluxoCaixa;

@Repository
@Transactional
public interface TipoFluxoCaixaDAO extends CrudRepository<TipoFluxoCaixa, Long> {

	public TipoFluxoCaixa findByNome(String nome);
	
	public List<TipoFluxoCaixa> findByIndEntrada(boolean indentrada);

}
