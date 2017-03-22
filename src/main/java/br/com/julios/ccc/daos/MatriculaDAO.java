package br.com.julios.ccc.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.Aluno;
import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.Turma;

@Repository
public interface MatriculaDAO extends JpaRepository<Matricula, Long>{

	@Query("select m from Matricula m where m.turma = ?1 and (m.dataExclusao is null or m.dataExclusao > CURRENT_DATE)")
	public Iterable<Matricula> getAlunosDaTurma(Turma turma);
	
	
	@Query("select m from Matricula m where m.aluno = ?1 and m.turma = ?2 and (m.dataExclusao is null or m.dataExclusao > CURRENT_DATE)")
	public Matricula getMatricula(Aluno aluno, Turma turma);

}
