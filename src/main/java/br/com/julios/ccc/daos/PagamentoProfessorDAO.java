package br.com.julios.ccc.daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.julios.ccc.domains.Mensalidades;
import br.com.julios.ccc.domains.PagamentoProfessor;

public interface PagamentoProfessorDAO extends CrudRepository<PagamentoProfessor, Long> {

	public List<PagamentoProfessor> findByMensalidade(Mensalidades mensalidade);

	@Query("select p from PagamentoProfessor p where p.fluxoCaixa is null and p.mensalidade.fluxoCaixa is not null and p.professor.id = ?1")
	public List<PagamentoProfessor> getPagamentosPendentes(Long id);
	
}
