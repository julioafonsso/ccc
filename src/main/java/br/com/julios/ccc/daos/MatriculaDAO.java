package br.com.julios.ccc.daos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.Aluno;
import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.Turma;

@Repository
public interface MatriculaDAO extends JpaRepository<Matricula, Long>{
	
	@Query("select m from Matricula m where m.aluno = ?1 and m.turma = ?2 and ( m.dataExclusao is null or m.dataExclusao > CURRENT_DATE)")
	public Matricula getMatricula(Aluno aluno, Turma turma);

	
	@Query("select m from Matricula m where m.aluno = ?1 and m.turma.tipo.id = ?2 and ( m.dataExclusao is null or m.dataExclusao > CURRENT_DATE )")
	public List<Matricula> getMatriculas(Aluno a, long tipoTurma);
	
	
	@Query("select m from Matricula m where m.aluno = ?1 and m.turma.tipo.id = ?2 and ( m.dataExclusao is null or m.dataExclusao > CURRENT_DATE ) and (m.dataMatricula between ?3 and ?4)")
	public List<Matricula> getMatriculas(Aluno a, long tipoTurma, Date dataInicio, Date dataFim);
	
	
	

}
