package br.com.julios.ccc.infra.bd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.dto.funcionario.consulta.ConsultaFuncionario;

@Repository
public interface FuncionarioDAO extends JpaRepository<FuncionarioDO, Long>{

	
	
	@Query("SELECT new br.com.julios.ccc.infra.dto.funcionario.consulta.ConsultaFuncionario( "
			+ " f.id, "
			+ " f.cpf, "
			+ " f.telefone, "
			+ " f.email, "
			+ " f.rg, "
			+ " f.foto, "
			+ " f.observacao,  "
			+ " f.dataNascimento, "
			+ " f.dataAdmissao, "
			+ " f.tipoFuncionario.id, "
			+ " f.tipoFuncionario.nome "
			+ ") FROM FuncionarioDO f"
			+ " where f.tipoFuncionario.id = 1 "
			)
	public List<ConsultaFuncionario> getProfessores();

	@Query("SELECT new br.com.julios.ccc.infra.dto.funcionario.consulta.ConsultaFuncionario( "
			+ " f.id, "
			+ " f.cpf, "
			+ " f.telefone, "
			+ " f.email, "
			+ " f.rg, "
			+ " f.foto, "
			+ " f.observacao,  "
			+ " f.dataNascimento, "
			+ " f.dataAdmissao, "
			+ " f.tipoFuncionario.id, "
			+ " f.tipoFuncionario.nome "
			+ ") FROM FuncionarioDO f"
			+ " where f.tipoFuncionario.id = 1 "
			+ " and f.id = ?1"
			)
	public ConsultaFuncionario getProfessor(Long idProfessor);
	
}
