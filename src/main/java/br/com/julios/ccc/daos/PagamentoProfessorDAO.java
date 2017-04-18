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

	@Query("select p from PagamentoProfessor p where p.fluxoCaixa is null and p.mensalidade.fluxoCaixa is not null and p.professor.id = ?1 order by p.mensalidade.matricula.turma.codigo, p.mensalidade.matricula.aluno.nome")
	public List<PagamentoProfessor> getPagamentosPendentes(Long id);
	
	@Query("select p from PagamentoProfessor p where p.fluxoCaixa is null and p.mensalidade.fluxoCaixa is not null and p.professor.id = ?1 and p.mensalidade.fluxoCaixa.data between ?2 and ?3 order by p.mensalidade.matricula.turma.codigo, p.mensalidade.matricula.aluno.nome")
	public List<PagamentoProfessor> getPagamentosPendentesNoPeriodo(Long id, Date dataInicio, Date dataFim);

	
	@Query("select distinct p.fluxoCaixa from PagamentoProfessor p  where p.professor = ?1 and p.fluxoCaixa.data between ?2 and ?3 order by p.fluxoCaixa.id")
	public List<FluxoCaixa> getRecibosCosolidados(Professor professor, Date diaInicio, Date diaFim);

	@Query("select p from PagamentoProfessor p  where p.fluxoCaixa = ?1 order by p.mensalidade.matricula.turma.codigo, p.mensalidade.matricula.aluno.nome")
	public List<PagamentoProfessor> getDetalheRecibo(FluxoCaixa fluxo);
	
}
