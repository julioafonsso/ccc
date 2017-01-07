package br.com.julios.ccc.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.Turma;

public interface MatriculaDAO extends JpaRepository<Matricula, Long>{

	public Iterable<Matricula> findByTurmaAndDataExclusaoIsNull(Turma turma);

}
