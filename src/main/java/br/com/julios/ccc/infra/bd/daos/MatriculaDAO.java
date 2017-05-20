package br.com.julios.ccc.infra.bd.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.infra.bd.model.MatriculaDO;
import br.com.julios.ccc.infra.dto.matricula.ConsultaMatriculaDTO;

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
			" m.diaVencimento ) "+
			" from MatriculaDO m, "
			+ "    TurmaColetivaDO t "
			+ " where m.aluno.id = ?1 "
			+ " and m.dataExclusao is null "
			+ " and m.turma.id = t.id "
			
			+ " ")
	public List<ConsultaMatriculaDTO> getMatriculas(Long idAluno);
	
}
