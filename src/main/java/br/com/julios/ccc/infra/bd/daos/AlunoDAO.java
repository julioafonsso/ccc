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
			" a.bairro, " +
			" a.cidade, " +
			" a.dataNascimento, " +
			" ec.id, " +
			" ec.nome, " +
			" a.profissao, " +
			" ce.id, " +
			" ce.nome, " +
			" a.sexo, " +
			" a.telefone, " +
			" a.observacao, " +
			" a.foto " +
			 ") from AlunoDO a " +
			 " LEFT OUTER JOIN  a.estadoCivil AS ec " +
			 " LEFT OUTER JOIN  a.conheceEscola AS ce "
			 + " where a.dataExclusao is null ")
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
			" a.bairro, " +
			" a.cidade, " +
			" a.dataNascimento, " +
			" ec.id, " +
			" ec.nome, " +
			" a.profissao, " +
			" ce.id, " +
			" ce.nome, " +
			" a.sexo, " +
			" a.telefone, " +
			" a.observacao, " +
			" a.foto " +
			") from AlunoDO a " +
			" LEFT OUTER JOIN  a.estadoCivil AS ec " +
			 " LEFT OUTER JOIN  a.conheceEscola AS ce "
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
			" 'Mensalidade' ," +
			" m.pagamentoMensalidade.id " +
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
			" 'WorkShop', " +
			" m.pagamentoMensalidade.id " +
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
			" 'Matricula', " +
			" m.pagamentroMatricula.id " +
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
			" 'Aula Particular', " +
			" m.pagamentoMensalidade.id " + 
			") from MensalidadeDO m, "
			+ " AulaParticularDO tc "
			+ " where m.dataExclusao is null "
			+ " and m.pagamentoMensalidade is not null "
			+ " and m.matricula.turma.id = tc.id"
			+ " and m.matricula.aluno.id = ?1 "
			+ " and m.pagamentoMensalidade.data between ?2 and ?3 "
			)
	public List<ConsultaHistoricoPagamentoDTO> getAulasParticularesPagas(Long idAluno, Date diaInicio, Date diaFim);
	
	@Query("select new br.com.julios.ccc.infra.dto.aluno.ConsultaHistoricoPagamentoDTO(" +
			"  t.codigo , " + 
			"  tp.pagamento.data,  " +
			"  tp.pagamento.valor,  " + 
			"  tp.pagamento.tipoFluxo.nome,  " +
			" tp.pagamento.id, " + 
			" tp.pagamento.observacao " +
			") from   "
			+ " TaxasPagasDO tp "
			+ " LEFT OUTER JOIN  tp.turma AS t " 
			+ " where tp.aluno.dataExclusao is null "
			+ " and tp.pagamento.dataExclusao is  null "
			+ " and tp.aluno.id = ?1 "
			+ " and tp.pagamento.data between ?2 and ?3 "
			)
	public List<ConsultaHistoricoPagamentoDTO> getTaxasPagas(Long idAluno, Date diaInicio, Date diaFim);
	
	
}
