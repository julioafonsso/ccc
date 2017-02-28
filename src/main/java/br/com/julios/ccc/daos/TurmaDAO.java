package br.com.julios.ccc.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.DiasSemana;
import br.com.julios.ccc.domains.Professor;
import br.com.julios.ccc.domains.Salas;
import br.com.julios.ccc.domains.Turma;


@Repository
@Transactional
public interface TurmaDAO extends CrudRepository<Turma, Long> {

	@Query("select t from Turma t JOIN t.diasSemana dia where t.sala = ?1 and dia in ?2")
	public List<Turma> getTurmasPorSalaEDias(Salas sala, List<DiasSemana> dias);

	
	@Query("select t from Turma t JOIN t.professores p JOIN t.diasSemana dia where p.professor = ?1 and dia in (?2)")
	public List<Turma> getTurmaPorProfessorEDia(Professor professor, List<DiasSemana> dias);
}
