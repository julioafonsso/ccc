package br.com.julios.ccc.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.Professor;

@Repository
public interface ProfessorDAO extends CrudRepository<Professor, Integer> {

	public Professor findOne(Integer id);
	
	public Professor findByCpf(int cpf);
}
