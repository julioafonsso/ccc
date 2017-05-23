package br.com.julios.ccc.infra.bd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.julios.ccc.infra.bd.model.WorkShopDO;
import br.com.julios.ccc.infra.dto.turma.workshop.ConsultaWorkShopDTO;

public interface WorkShopDAO extends CrudRepository<WorkShopDO, Long> {

	@Query("select new br.com.julios.ccc.infra.dto.turma.workshop.ConsultaWorkShopDTO( t.id, "
			+ "t.codigo, "
			+ "t.professor1.id, " 
			+ "t.professor1.nome, " 
			+ "t.percentualProfessor1, " 
			+ "t.professor2.id, " 
			+ "t.professor2.nome, " 
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
			+ "where (t.dataTermino is null or t.dataTermino > CURRENT_DATE)")
	public List<ConsultaWorkShopDTO> getTurmas();

}
