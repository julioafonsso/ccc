package br.com.julios.ccc.daos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.julios.ccc.domains.Aluno;
import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.Mensalidades;
import br.com.julios.ccc.domains.MesReferencia;

@Repository
public interface MensalidadesDAO extends JpaRepository<Mensalidades, Long>{
	
	
	@Query("select m from Mensalidades m where m.fluxoCaixa is null and m.matricula.aluno = ?1 and m.dataExclusao is null")
	public List<Mensalidades> getMensalidadesParaPagar(Aluno aluno);

	@Query("select m from Mensalidades m where m.fluxoCaixa is null and m.matricula = ?1 and m.dataExclusao is null")
	public List<Mensalidades> getMensalidadesParaPagar(Matricula matricula);
	
	@Query("select m from Mensalidades m where m.matricula = ?1 and m.dataExclusao is null order by  m.mesReferencia desc")
	public List<Mensalidades> getMensalidades(Matricula matricula);
	
	
	


	@Query("select m from Mensalidades m where m.fluxoCaixa is not null and m.matricula.aluno = ?1 and m.dataExclusao is null and (m.matricula.turma.dataTermino is null or m.matricula.turma.dataTermino > CURRENT_DATE) and m.fluxoCaixa.data between ?2 and ?3")
	public List<Mensalidades> getMensalidadesPaga(Aluno aluno, Date diaInicio, Date diaFim);
	
	
	public Mensalidades findByMesReferenciaAndMatricula(MesReferencia mes, Matricula matricula);
}
