package br.com.julios.ccc.infra.bd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.bd.model.ModalidadeTurmaDO;
import br.com.julios.ccc.infra.bd.model.TurmaColetivaDO;
import br.com.julios.ccc.infra.dto.turma.coletiva.ConsultaTurmaColetivaDTO;

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
			+ " and (t.dataTermino is null or t.dataTermino > CURRENT_DATE)")
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

}
