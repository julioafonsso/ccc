package br.com.julios.ccc.infra.bd.daos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.bd.model.ModalidadeTurmaDO;
import br.com.julios.ccc.infra.bd.model.TurmaColetivaDO;
import br.com.julios.ccc.infra.dto.turma.coletiva.ConsultaHistoricoPagamentoTurmaDTO;
import br.com.julios.ccc.infra.dto.turma.coletiva.ConsultaTurmaColetivaDTO;
import br.com.julios.ccc.infra.dto.turma.coletiva.ConsultaTurmaColetivaExcluidasDTO;

@Repository
public interface TurmaColetivaDAO extends JpaRepository<TurmaColetivaDO, Long> {

	@Query("select new br.com.julios.ccc.infra.dto.turma.coletiva.ConsultaTurmaColetivaDTO( t.id, "
			+ "t.codigo, "
			+ "p1.id, " 
			+ "p1.nome, " 
			+ "t.percentualProfessor1, " 
			+ "t.modalidade.id, "
			+ "t.modalidade.nome, " 
			+ "p2.id, " 
			+ "p2.nome, " 
			+ "t.percentualProfessor2, "
			+ "t.vagas, " 
			+ "t.mensalidade, " 
			+ "t.horarioInicial , " 
			+ "t.horarioFinal, " 
			+ "t.domingo, "
			+ "t.segunda, " 
			+ "t.terca, " 
			+ "t.quarta, " 
			+ "t.quinta, " 
			+ "t.sexta, " 
			+ "t.sabado, " 
			+ "t.nivel.id, "
			+ "t.nivel.nome, " 
			+ "t.sala.id, " 
			+ "t.sala.nome, "
			+ "t.qtdAlunos, " 
			+ "t.qtdAlunas,"
			+ "t.dataInicio,"
			+ "t.dataTermino  "
			+ " ) from TurmaColetivaDO t "
			+ " LEFT OUTER JOIN t.professor1 AS p1 "
			+ " LEFT OUTER JOIN t.professor2 AS p2 "
			+ "where (t.professor1.id = ?1 or t.professor2.id = ?1 ) "
			+ " and (t.dataTermino is null or t.dataTermino > CURRENT_DATE)"
			+ " order by t.id desc "
			+ "")
	public List<ConsultaTurmaColetivaDTO> getTurmasDoProfessor(Long idProfessor);
	
	
	@Query("select new br.com.julios.ccc.infra.dto.turma.coletiva.ConsultaTurmaColetivaDTO( t.id, "
			+ "t.codigo, "
			+ "p1.id, " 
			+ "p1.nome, " 
			+ "t.percentualProfessor1, " 
			+ "t.modalidade.id, "
			+ "t.modalidade.nome, " 
			+ "p2.id, " 
			+ "p2.nome, " 
			+ "t.percentualProfessor2, "
			+ "t.vagas, " 
			+ "t.mensalidade, " 
			+ "t.horarioInicial , " 
			+ "t.horarioFinal, " 
			+ "t.domingo, "
			+ "t.segunda, " 
			+ "t.terca, " 
			+ "t.quarta, " 
			+ "t.quinta, " 
			+ "t.sexta, " 
			+ "t.sabado, " 
			+ "t.nivel.id, "
			+ "t.nivel.nome, " 
			+ "t.sala.id, " 
			+ "t.sala.nome, "
			+ "t.qtdAlunos, " 
			+ "t.qtdAlunas,"
			+ "t.dataInicio,"
			+ "t.dataTermino  "
			+ " ) from TurmaColetivaDO t "
			+ " LEFT OUTER JOIN t.professor1 AS p1 "
			+ " LEFT OUTER JOIN t.professor2 AS p2 "
			+ " where t.id = ?1 ")
	public ConsultaTurmaColetivaDTO getTurma(Long idTurma);
	
	@Query("select new br.com.julios.ccc.infra.dto.turma.coletiva.ConsultaTurmaColetivaDTO( t.id, "
			+ "t.codigo, "
			+ "p1.id, " 
			+ "p1.nome, " 
			+ "t.percentualProfessor1, " 
			+ "t.modalidade.id, "
			+ "t.modalidade.nome, " 
			+ "p2.id, " 
			+ "p2.nome, " 
			+ "t.percentualProfessor2, "
			+ "t.vagas, " 
			+ "t.mensalidade, " 
			+ "t.horarioInicial , " 
			+ "t.horarioFinal, " 
			+ "t.domingo, "
			+ "t.segunda, " 
			+ "t.terca, " 
			+ "t.quarta, " 
			+ "t.quinta, " 
			+ "t.sexta, " 
			+ "t.sabado, " 
			+ "t.nivel.id, "
			+ "t.nivel.nome, " 
			+ "t.sala.id, " 
			+ "t.sala.nome, "
			+ "t.qtdAlunos, " 
			+ "t.qtdAlunas,"
			+ "t.dataInicio,"
			+ "t.dataTermino  "
			+ " ) from TurmaColetivaDO t  "
			+ " LEFT OUTER JOIN t.professor1 AS p1 "
			+ " LEFT OUTER JOIN t.professor2 AS p2 "
			+ "where (t.dataTermino is null or t.dataTermino > CURRENT_DATE)"
			+ " order by t.modalidade.nome")
	public List<ConsultaTurmaColetivaDTO> getTurmas();


	
	@Query("select count(*) from TurmaColetivaDO t where t.modalidade = ?1 and (t.dataTermino is null or t.dataTermino > CURRENT_DATE) ")
	public Long getQtdTurmaAtivas(ModalidadeTurmaDO modalidadeTurmaDO);


	@Query( " select t from TurmaColetivaDO t "
			+ "where (t.professor1 = ?1 or t.professor2 = ?1 ) "
			+ " and (t.dataTermino is null or t.dataTermino > CURRENT_DATE)")
	public List<TurmaColetivaDO> getTurmas(FuncionarioDO professor);

	
	
	@Query("select new br.com.julios.ccc.infra.dto.turma.coletiva.ConsultaTurmaColetivaExcluidasDTO( t.id, "
			+ "t.codigo, "
			+ "p1.id, " 
			+ "p1.nome, " 
			+ "t.percentualProfessor1, " 
			+ "t.modalidade.id, "
			+ "t.modalidade.nome, " 
			+ "p2.id, " 
			+ "p2.nome, " 
			+ "t.percentualProfessor2, "
			+ "t.vagas, " 
			+ "t.mensalidade, " 
			+ "t.nivel.id, "
			+ "t.nivel.nome, " 
			+ "t.qtdAlunosTotal, " 
			+ "t.qtdAlunasTotal,"
			+ "t.dataInicio,"
			+ "t.dataTermino ,"
			+ "  ( select sum(m.pagamentroMatricula.valor) from MatriculaDO m where m.pagamentroMatricula is not null and m.turma = t ) , "
			+ "  ( select sum (mm.pagamentoMensalidade.valor) from MensalidadeDO mm where mm.pagamentoMensalidade is not null and "
			+ "                                                                                              mm.matricula.turma = t)  "
			+ " ) from TurmaColetivaDO t  "
			+ " LEFT OUTER JOIN t.professor1 AS p1 "
			+ " LEFT OUTER JOIN t.professor2 AS p2 "
			+ "where (t.dataTermino is not null and t.dataTermino <= CURRENT_DATE)"
			+ " order by t.modalidade.nome")
	public List<ConsultaTurmaColetivaExcluidasDTO> getTurmasExcluidas();
	
	@Query("select new br.com.julios.ccc.infra.dto.turma.coletiva.ConsultaHistoricoPagamentoTurmaDTO( "
			+ " m.matricula.aluno.nome, "
			+ " m.mesReferencia.mes, "
			+ " m.mesReferencia.ano, "
			+ " m.dataVencimento, "
			+ " m.pagamentoMensalidade.data, "
			+ " m.pagamentoMensalidade.valor,"
			+ " m.valorMensalidade "
			+ " )"
			+ " from MensalidadeDO m"
			+ " where m.pagamentoMensalidade is not null "
			+ " and m.matricula.turma.id = ?1"
			+ " and m.pagamentoMensalidade.data between ?2 and ?3"
			+ " order by  m.pagamentoMensalidade.data desc ")
	public List<ConsultaHistoricoPagamentoTurmaDTO> getMensalidadesPagas(Long id, Date diaInicio, Date diaFim);

}
