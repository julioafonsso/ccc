package br.com.julios.ccc.infra.bd.daos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.MensalidadeDO;
import br.com.julios.ccc.infra.dto.menslidade.ConsultaMensalidadeDTO;

@Repository
public interface MensalidadeDAO extends JpaRepository<MensalidadeDO, Long>{


	
	@Query("select new br.com.julios.ccc.infra.dto.menslidade.ConsultaMensalidadeDTO(" +
			" m.id, "
			+ " m.matricula.turma.codigo, " + 
			" m.matricula.turma.modalidade.nome, " + 
			" m.dataVencimento, " +
			" m.mesReferencia.mes, " +
			" m.mesReferencia.ano, " + 
			" m.valorMensalidade, " + 
			" d.valor " +
			") from MensalidadeDO m "
			+ " LEFT OUTER JOIN  m.matricula.desconto AS d "
			+ " where m.dataExclusao is null "
			+ " and m.pagamentoMensalidade is null "
			+ " and m.matricula.aluno.id = ?1 ")
	public List<ConsultaMensalidadeDTO> getMensalidadesAluno(Long idAluno);

	@Query("select new br.com.julios.ccc.infra.dto.menslidade.ConsultaMensalidadeDTO(" +
			" m.id, "
			+ " m.matricula.turma.codigo, " + 
			" m.matricula.turma.modalidade.nome, " + 
			" m.dataVencimento, " +
			" m.mesReferencia.mes, " +
			" m.mesReferencia.ano, " + 
			" m.pagamentoMensalidade.valor, " + 
			" m.pagamentoMensalidade.data " +
			") from MensalidadeDO m "
			+ " where m.dataExclusao is null "
			+ " and m.pagamentoMensalidade is not null "
			+ " and m.matricula.aluno.id = ?1 "
			+ " and m.pagamentoMensalidade.data between ?2 and ?3")
	public List<ConsultaMensalidadeDTO> getMensalidadesPagasAluno(Long idAluno, Date diaInicio, Date diaFim);
	
	@Query("select count (*) from MensalidadeDO m where m.matricula.aluno.id = ?1"
			+ " and m.dataExclusao is null")
	public Long getQtdMensalidades(Long idMatricula);

	@Query("select count (*) from MensalidadeDO m where m.mesReferencia.id = ?2 and m.matricula.id = ?1"
			+ " and m.dataExclusao is null")
	public Long getQtdMensalidadeMes(Long idMatricula, Long idMes);
	
}
