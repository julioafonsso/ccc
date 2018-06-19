package br.com.julios.ccc.infra.bd.daos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.AlunoDO;
import br.com.julios.ccc.infra.bd.model.DescontosDO;
import br.com.julios.ccc.infra.bd.model.MatriculaDO;
import br.com.julios.ccc.infra.bd.model.TurmaColetivaDO;
import br.com.julios.ccc.infra.bd.model.TurmaDO;
import br.com.julios.ccc.infra.dto.matricula.ConsultaAlunosMatriculadosDTO;
import br.com.julios.ccc.infra.dto.matricula.ConsultaAlunosMatriculadosTurmaExcluidaDTO;
import br.com.julios.ccc.infra.dto.matricula.ConsultaMatriculaDTO;
import br.com.julios.ccc.infra.dto.turma.individual.ConsultaAulaIndividualDTO;

@Repository
public interface MatriculaDAO extends JpaRepository<MatriculaDO, Long>{

	
	@Query("select new br.com.julios.ccc.infra.dto.matricula.ConsultaMatriculaDTO (" +
			" m.id ,"+
			" t.id ,"+
			" t.codigo ,"+
			" t.modalidade.id ,"+
			" t.modalidade.nome ,"+
			" t.nivel.id ,"+
			" t.nivel.nome ,"+
			" t.sala.id ,"+
			" t.sala.nome ,"+
			" m.diaVencimento,  "+
			" d.id,  "+
			" d.nome,  "+
			" d.valor, "+
			" m.dataMatricula," +
			" t.dataInicio," +
			" t.dataTermino," +
			" t.qtdAlunos," +
			" t.qtdAlunas," +
			" p1.nome," +
			" p2.nome," +
			" t.vagas," +
			" t.mensalidade" +
			" ) "+
			" from MatriculaDO m, "
			+ "    TurmaColetivaDO t"
			+ " LEFT OUTER JOIN m.desconto AS d "
			+ " LEFT OUTER JOIN t.professor1 AS p1 "
			+ " LEFT OUTER JOIN t.professor2 AS p2 "
			+ " where m.aluno.id = ?1 "
			+ " and m.dataExclusao is null "
			+ " and m.turma.id = t.id "
			+ " order by m.id desc"
			
			+ " ")
	public List<ConsultaMatriculaDTO> getMatriculas(Long idAluno);

	
	@Query("select new br.com.julios.ccc.infra.dto.turma.individual.ConsultaAulaIndividualDTO (" +
			" a.id ,"+
			" a.codigo ,"
			+ "a.professor1.id, "
			+ "a.professor1.nome, "
			+ " a.percentualProfessor1, " +
			" a.modalidade.id ,"+
			" a.modalidade.nome ,"
			+ "a.qtdAulasContratadas, "
			+ "m.dataMatricula , "
			+ " men.pagamentoMensalidade.valor "+
			" ) "+
			" from MatriculaDO m, "
			+ "    AulaParticularDO a,"
			+ "    MensalidadeDO men "
			+ " where m.aluno.id = ?1 "
			+ " and men.matricula.id = m.id"
			+ " and m.dataExclusao is null "
			+ " and m.turma.id = a.id "
			+ " and m.dataMatricula between ?2 and ?3 "
			+ " ")
	public List<ConsultaAulaIndividualDTO> getAulasParticulares(Long idAluno, Date diaInicio, Date diaFim);
	
	
	
	@Query("select new br.com.julios.ccc.infra.dto.matricula.ConsultaMatriculaDTO (" +
			" m.id ,"+
			" t.id ,"+
			" t.codigo ,"+
			" t.modalidade.id ,"+
			" t.modalidade.nome ,"+
			" t.dataInicio, "+
			" t.dataTermino, "+
			" m.dataMatricula ) "+
			" from MatriculaDO m ,"
			+ " WorkShopDO t "
			+ " where m.aluno.id = ?1 "
			+ " and t.id = m.turma.id "
			+ " and m.dataExclusao is null "
			+ " and m.dataMatricula between ?2 and ?3"
			
			+ " ")
	public List<ConsultaMatriculaDTO> getWorkShop(Long idAluno,  Date diaInicio, Date diaFim);

	@Query("select count(*) from MatriculaDO m where m.dataExclusao is null and m.desconto = ?1")
	public Long getQtdMatriculas(DescontosDO descontosDO);


	@Query("select m from MatriculaDO m where m.aluno = ?1 and m.turma = ?2 and m.dataExclusao is null ")
	public MatriculaDO getMatriculas(AlunoDO aluno, TurmaDO turma);
	
	
	
	
	
	@Query("select new br.com.julios.ccc.infra.dto.matricula.ConsultaAlunosMatriculadosDTO (" +
			" m.id ,"+
			" m.aluno.nome ,"+
			" m.aluno.cpf ,"+
			" m.aluno.email ,"+
			" d.nome,  "+
			" d.valor, " +
			" m.dataMatricula , "+
			" m.aluno.dataNascimento, " +
			" (select min(mm.dataVencimento) from MensalidadeDO mm  LEFT OUTER JOIN mm.pagamentoMensalidade p  where mm.matricula = m and p is null),"
			+ "(select count(*) from ControleEmailCobrancaDO c where c.matricula = m ),"
			+ "(select max(c.dataEnvio) from ControleEmailCobrancaDO c where c.matricula = m ) " +
			") "+
			" from "
			+ " MatriculaDO m "
			+ " LEFT OUTER JOIN m.desconto AS d "
			+ " where m.turma.id = ?1 "
			+ " and m.aluno.dataExclusao is null "
			+ " and m.dataExclusao is null order by m.aluno.nome "
			+ " ")
	public List<ConsultaAlunosMatriculadosDTO> getAlunosMatriculados(Long idTurma);

	@Query("select new br.com.julios.ccc.infra.dto.matricula.ConsultaAlunosMatriculadosTurmaExcluidaDTO (" +
			" m.aluno.nome ,"+
			" m.aluno.cpf ,"+
			" m.aluno.email ,"+
			" d.nome,  "+
			" d.valor, " +
			" m.dataMatricula , "+
			" m.dataExclusao , "+
			" m.aluno.dataNascimento, " +
			" pg.valor, " +
			" (select sum(mm.pagamentoMensalidade.valor) from MensalidadeDO mm where mm.matricula = m and mm.pagamentoMensalidade is not null  )" +
			") "+
			" from "
			+ " MatriculaDO m "
			+ " LEFT OUTER JOIN m.desconto AS d "
			+ " LEFT OUTER JOIN m.pagamentroMatricula AS pg "
			+ " where m.turma.id = ?1 "
			+ " order by m.aluno.nome "
			+ " ")
	public List<ConsultaAlunosMatriculadosTurmaExcluidaDTO> getAlunosMatriculadosTurmaExcluida(Long idTurma);
	

	@Query("select m from MatriculaDO m where m.dataExclusao is null and m.turma = ?1")
	public List<MatriculaDO> getMatriculas(TurmaDO turma);


	@Query("select m.aluno "+
			" from MatriculaDO m "
			+ " where m.turma = ?1 "
			+ " and m.dataExclusao is null "
			+ " order by m.aluno.nome ")
	public List<AlunoDO> getAlunosMatriculados(TurmaColetivaDO turmaColetivaDO);
}
