package br.com.julios.ccc.daos;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.Professor;

@Repository
@Transactional
public interface ProfessorDAO extends CrudRepository<Professor, Long> {

	public Professor findOne(Long id);
	
	public Professor findByCpf(String cpf);
	
	public Professor findByRg(String rg);
	
	public Professor findByNome(String nome);
	
	public Professor findByEmail(String email);
	
	public Professor findByEndereco(String endereco);
	
	public Professor findByTelefone(Long telefone);
	
	public Professor findByObservacao(String observavao);
	
}
