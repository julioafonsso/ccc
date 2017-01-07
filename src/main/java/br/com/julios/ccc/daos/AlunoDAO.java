package br.com.julios.ccc.daos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.Aluno;

@Repository
@Transactional
public interface AlunoDAO extends JpaRepository<Aluno, Long>{
	
	public Aluno findByCpf(String cpf);
	
	public Aluno findByNome(String nome);
	
	public Aluno findByRg(String rg);
	
	public Aluno findByEmail(String email);
	
	public Aluno findByEndereco(String endereco);
	
	public Aluno findByBairro(String bairro);
	
	public Aluno findByCidade(String cidade);
	
	public Aluno findByProfissao(String profissao);
	
	public Aluno findBySexo(String sexo);
	
	public Aluno findByTelefone(int telefone);
	
	
	

}
