package br.com.julios.ccc.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.Professor;
import br.com.julios.ccc.domains.Salas;
import br.com.julios.ccc.domains.Turma;


@Repository
@Transactional
public interface TurmaDAO extends CrudRepository<Turma, Long> {

	@Query("select t from Turma t where t.sala = ?1 ")
	public List<Turma> getTurmasPorSala(Salas sala);

	
	@Query("select t from Turma t where (t.professor1 = ?1 or t.professor2 = ?1 ) ")
	public List<Turma> getTurmaPorProfessor(Professor professor);


	public List<Turma> findByProfessor1OrProfessor2(Professor prof, Professor prof2);
}
