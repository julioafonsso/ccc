package br.com.julios.ccc.infra.bd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.AlunoDO;
import br.com.julios.ccc.infra.dto.aluno.ConsultaAlunoDTO;

@Repository
public interface AlunoDAO extends JpaRepository<AlunoDO, Long>{

	
	
	
	@Query("select new br.com.julios.ccc.infra.dto.aluno.ConsultaAlunoDTO(" +
			" a.id, " +
			" a.cpf, " +
			" a.nome, " +
			" a.rg, " +
			" a.email, " +
			" a.endereco, " +
			" a.numero, " +
			" a.complemento, " +
			" a.bairro.id, " +
			" a.bairro.nome, " +
			" a.cidade, " +
			" a.dataNascimento, " +
			" a.estadoCivil.id, " +
			" a.estadoCivil.nome, " +
			" a.profissao, " +
			" a.conheceEscola.id, " +
			" a.conheceEscola.nome, " +
			" a.sexo, " +
			" a.telefone, " +
			" a.observacao, " +
			" a.foto " +
			 ") from AlunoDO a ")
	public List<ConsultaAlunoDTO> getAlunos();
	
	@Query("select f from AlunoDO f where f.cpf = ?1")
	public AlunoDO getPorCPF(String cpf);

	@Query("select f from AlunoDO f where f.rg = ?1")
	public AlunoDO getPorRG(String rg);

	@Query("select f from AlunoDO f where f.email = ?1")
	public AlunoDO getPorEmail(String email);


	@Query("select new br.com.julios.ccc.infra.dto.aluno.ConsultaAlunoDTO(" +
			" a.id, " +
			" a.cpf, " +
			" a.nome, " +
			" a.rg, " +
			" a.email, " +
			" a.endereco, " +
			" a.numero, " +
			" a.complemento, " +
			" a.bairro.id, " +
			" a.bairro.nome, " +
			" a.cidade, " +
			" a.dataNascimento, " +
			" a.estadoCivil.id, " +
			" a.estadoCivil.nome, " +
			" a.profissao, " +
			" a.conheceEscola.id, " +
			" a.conheceEscola.nome, " +
			" a.sexo, " +
			" a.telefone, " +
			" a.observacao, " +
			" a.foto " +
			") from AlunoDO a "
			+ " where a.id = ?1 ")
	public ConsultaAlunoDTO getAlunos(Long idAluno);


}
