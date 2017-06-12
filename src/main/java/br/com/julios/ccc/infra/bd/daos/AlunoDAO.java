package br.com.julios.ccc.infra.bd.daos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.AlunoDO;
import br.com.julios.ccc.infra.dto.aluno.ConsultaAlunoDTO;
import br.com.julios.ccc.infra.dto.aluno.ConsultaHistoricoPagamentoDTO;

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

	
	@Query("select new br.com.julios.ccc.infra.dto.aluno.ConsultaHistoricoPagamentoDTO(" +
			" tc.codigo, " + 
			" tc.modalidade.nome, " + 
			" m.mesReferencia.mes, " +
			" m.mesReferencia.ano, " +
			" m.dataVencimento, " +
			" m.pagamentoMensalidade.data, " + 
			" m.pagamentoMensalidade.valor, " + 
			" 'Mensalidade' " +
			") from MensalidadeDO m, "
			+ " TurmaColetivaDO tc "
			+ " where m.dataExclusao is null "
			+ " and m.pagamentoMensalidade is not null "
			+ " and m.matricula.turma.id = tc.id"
			+ " and m.matricula.aluno.id = ?1 "
			+ " and m.pagamentoMensalidade.data between ?2 and ?3 "
			)
	public List<ConsultaHistoricoPagamentoDTO> getMensalidadesPagasAluno(Long idAluno, Date diaInicio, Date diaFim);
	
	
	

	@Query("select new br.com.julios.ccc.infra.dto.aluno.ConsultaHistoricoPagamentoDTO(" +
			" tc.codigo, " + 
			" tc.modalidade.nome, " + 
			" m.dataVencimento, " +
			" m.pagamentoMensalidade.data, " + 
			" m.pagamentoMensalidade.valor, " + 
			" 'WorkShop' " +
			") from MensalidadeDO m, "
			+ " WorkShopDO tc "
			+ " where m.dataExclusao is null "
			+ " and m.pagamentoMensalidade is not null "
			+ " and m.matricula.turma.id = tc.id"
			+ " and m.matricula.aluno.id = ?1 "
			+ " and m.pagamentoMensalidade.data between ?2 and ?3 "
			)
	public List<ConsultaHistoricoPagamentoDTO> getWorkShopsPago(Long idAluno, Date diaInicio, Date diaFim);

	
	@Query("select new br.com.julios.ccc.infra.dto.aluno.ConsultaHistoricoPagamentoDTO(" +
			" tc.codigo, " + 
			" tc.modalidade.nome, " + 
			" m.pagamentroMatricula.data, " +
			" m.pagamentroMatricula.data, " + 
			" m.pagamentroMatricula.valor, " + 
			" 'Matricula' " +
			") from MatriculaDO m, "
			+ " TurmaColetivaDO tc "
			+ " where m.dataExclusao is null "
			+ " and m.pagamentroMatricula is not null "
			+ " and m.turma.id = tc.id"
			+ " and m.aluno.id = ?1 "
			+ " and m.pagamentroMatricula.data between ?2 and ?3 "
			)
	public List<ConsultaHistoricoPagamentoDTO> getMatriculasPagas(Long idAluno, Date diaInicio, Date diaFim);

	@Query("select new br.com.julios.ccc.infra.dto.aluno.ConsultaHistoricoPagamentoDTO(" +
			" tc.codigo, " + 
			" tc.modalidade.nome, " + 
			" m.dataVencimento, " +
			" m.pagamentoMensalidade.data, " + 
			" m.pagamentoMensalidade.valor, " + 
			" 'Aula Particular' " +
			") from MensalidadeDO m, "
			+ " AulaParticularDO tc "
			+ " where m.dataExclusao is null "
			+ " and m.pagamentoMensalidade is not null "
			+ " and m.matricula.turma.id = tc.id"
			+ " and m.matricula.aluno.id = ?1 "
			+ " and m.pagamentoMensalidade.data between ?2 and ?3 "
			)
	public List<ConsultaHistoricoPagamentoDTO> getAulasParticularesPagas(Long idAluno, Date diaInicio, Date diaFim);
	
}
