package br.com.julios.ccc.daos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.FluxoCaixa;
import br.com.julios.ccc.domains.Mensalidades;
import br.com.julios.ccc.domains.PagamentoProfessor;
import br.com.julios.ccc.domains.Professor;

@Repository
public interface PagamentoProfessorDAO extends CrudRepository<PagamentoProfessor, Long> {

	public List<PagamentoProfessor> findByMensalidade(Mensalidades mensalidade);

	@Query("select p from PagamentoProfessor p where p.fluxoCaixa is null and p.mensalidade.fluxoCaixa is not null and p.professor.id = ?1")
	public List<PagamentoProfessor> getPagamentosPendentes(Long id);

	
	@Query("select distinct p.fluxoCaixa from PagamentoProfessor p  where p.professor = ?1 and p.fluxoCaixa.data between ?2 and ?3")
	public List<FluxoCaixa> getRecibosCosolidados(Professor professor, Date diaInicio, Date diaFim);

	@Query("select p from PagamentoProfessor p  where p.fluxoCaixa = ?1")
	public List<PagamentoProfessor> getDetalheRecibo(FluxoCaixa fluxo);
	
}