package br.com.julios.ccc.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.julios.ccc.domains.Salario;

public interface SalarioDAO extends JpaRepository<Salario, Long>{
	
	public List<Salario> findByIdProfessor(Long professor);

}
