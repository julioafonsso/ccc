package br.com.julios.ccc.infra.bd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.julios.ccc.infra.bd.model.WorkShopDO;
import br.com.julios.ccc.infra.dto.turma.workshop.ConsultaWorkShopDTO;

public interface WorkShopDAO extends CrudRepository<WorkShopDO, Long> {

	@Query("select new br.com.julios.ccc.infra.dto.turma.workshop.ConsultaWorkShopDTO( t.id, "
			+ "t.codigo, "
			+ "p1.id, " 
			+ "p1.nome, " 
			+ "t.percentualProfessor1, " 
			+ "p2.id, " 
			+ "p2.nome, " 
			+ "t.percentualProfessor2, "
			+ "t.modalidade.id, "
			+ "t.modalidade.nome, " 
			+ "t.vagas, " 
			+ "t.mensalidade, " 
			+ "t.horarioInicial , " 
			+ "t.horarioFinal, " 
			+ "t.dataInicio,"
			+ "t.dataTermino  "
			+ " ) from WorkShopDO t "
			+ " LEFT OUTER JOIN t.professor1 AS p1 "
			+ " LEFT OUTER JOIN t.professor2 AS p2 "
			+ "where (t.dataTermino is null or t.dataTermino > CURRENT_DATE)")
	public List<ConsultaWorkShopDTO> getTurmas();

	
	
	@Query("select new br.com.julios.ccc.infra.dto.turma.workshop.ConsultaWorkShopDTO( t.id, "
			+ "t.codigo, "
			+ "p1.id, " 
			+ "p1.nome, " 
			+ "t.percentualProfessor1, " 
			+ "p2.id, " 
			+ "p2.nome, " 
			+ "t.percentualProfessor2, "
			+ "t.modalidade.id, "
			+ "t.modalidade.nome, " 
			+ "t.vagas, " 
			+ "t.mensalidade, " 
			+ "t.horarioInicial , " 
			+ "t.horarioFinal, " 
			+ "t.dataInicio,"
			+ "t.dataTermino  "
			+ " ) from WorkShopDO t "
			+ " LEFT OUTER JOIN t.professor1 AS p1 "
			+ " LEFT OUTER JOIN t.professor2 AS p2 "
			+ "where t.id = ?1")	
	public ConsultaWorkShopDTO get(Long id);

}
