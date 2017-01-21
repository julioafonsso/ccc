package br.com.julios.ccc.daos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.Turma;
import br.com.julios.ccc.domains.TurmaProfessor;

@Repository
@Transactional
public interface TurmaProfessorDAO extends JpaRepository<TurmaProfessor, Long> {
	
	public Iterable<TurmaProfessor> findByTurmaAndDataExclusaoIsNull(Turma turma);

}
