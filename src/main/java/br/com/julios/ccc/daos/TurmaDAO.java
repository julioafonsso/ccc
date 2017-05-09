package br.com.julios.ccc.daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.ModalidadeTurma;
import br.com.julios.ccc.domains.Professor;
import br.com.julios.ccc.domains.Salas;
import br.com.julios.ccc.domains.Turma;


@Repository
public interface TurmaDAO extends CrudRepository<Turma, Long> {

	@Query("select t from Turma t where t.sala = ?1 and (t.dataTermino is null or t.dataTermino > CURRENT_DATE) and t.tipo.id = 1")
	public List<Turma> getTurmasPorSala(Salas sala);

	
	@Query("select t from Turma t where (t.professor1 = ?1 or t.professor2 = ?1 ) and (t.dataTermino is null or t.dataTermino > CURRENT_DATE) and t.tipo.id = 1")
	public List<Turma> getTurmaPorProfessor(Professor professor);

	
	@Query("select t from Turma t where (t.dataTermino is null or t.dataTermino > CURRENT_DATE) and t.tipo.id = 1")
	public List<Turma> getTurmas();
	
	@Query("select t from Turma t where t.modalidade = ?1 and (t.dataTermino is null or t.dataTermino > CURRENT_DATE) and t.tipo.id = 1")
	public List<Turma> getTurmas(ModalidadeTurma modalidade);

	

	
}
