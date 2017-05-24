package br.com.julios.ccc.infra.bd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.dto.funcionario.ConsultaFuncionarioDTO;

@Repository
public interface FuncionarioDAO extends JpaRepository<FuncionarioDO, Long>{

	
	
	@Query("SELECT new br.com.julios.ccc.infra.dto.funcionario.ConsultaFuncionarioDTO( "
			+ " f.id, "
			+ " f.nome, "
			+ " f.cpf, "
			+ " f.telefone, "
			+ " f.email, "
			+ " f.rg, "
			+ " f.foto, "
			+ " f.observacao,  "
			+ " f.dataNascimento, "
			+ " f.dataAdmissao, "
			+ " f.tipoFuncionario.id, "
			+ " f.tipoFuncionario.nome,"
			+ " f.salario,"
			+ " f.valeTransporte "
			+ ") FROM FuncionarioDO f "
			+ " where f.tipoFuncionario.id = 1 "
			)
	public List<ConsultaFuncionarioDTO> getProfessores();
	
	@Query("SELECT new br.com.julios.ccc.infra.dto.funcionario.ConsultaFuncionarioDTO( "
			+ " f.id, "
			+ " f.nome, "
			+ " f.cpf, "
			+ " f.telefone, "
			+ " f.email, "
			+ " f.rg, "
			+ " f.foto, "
			+ " f.observacao,  "
			+ " f.dataNascimento, "
			+ " f.dataAdmissao, "
			+ " f.tipoFuncionario.id, "
			+ " f.tipoFuncionario.nome,"
			+ " f.salario,"
			+ " f.valeTransporte "
			+ ") FROM FuncionarioDO f "
			+ " where f.tipoFuncionario.id = 2 "
			)
	public List<ConsultaFuncionarioDTO> getFuncionarios();
	

	@Query("SELECT new br.com.julios.ccc.infra.dto.funcionario.ConsultaFuncionarioDTO( "
			+ " f.id, "
			+ " f.nome, "
			+ " f.cpf, "
			+ " f.telefone, "
			+ " f.email, "
			+ " f.rg, "
			+ " f.foto, "
			+ " f.observacao,  "
			+ " f.dataNascimento, "
			+ " f.dataAdmissao, "
			+ " f.tipoFuncionario.id, "
			+ " f.tipoFuncionario.nome,"
			+ " f.salario,"
			+ " f.valeTransporte "
			+ ") FROM FuncionarioDO f "
			+ " where f.id = ?1"
			)
	public ConsultaFuncionarioDTO getFuncionario(Long idProfessor);

	@Query("select count(*) from FuncionarioDO f where f.cpf = ?1")
	public Long countByCpf(String cpf);

	@Query("select count(*) from FuncionarioDO f where f.rg = ?1")
	public Long countByRg(String rg);

	@Query("select count(*) from FuncionarioDO f where f.email = ?1")
	public Long countByEmail(String email);
	
}
