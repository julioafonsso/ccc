package br.com.julios.ccc.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.julios.ccc.domains.Aluno;
import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.Mensalidades;
import br.com.julios.ccc.domains.MesReferencia;

public interface MensalidadesDAO extends JpaRepository<Mensalidades, Long>{
	
	
	@Query("select m from Mensalidades m where m.fluxoCaixa is null and m.matricula.aluno = ?1 and m.dataExclusao is null")
	public List<Mensalidades> getMensalidadesParaPagar(Aluno aluno);

	@Query("select m from Mensalidades m where m.fluxoCaixa is null and m.matricula = ?1")
	public List<Mensalidades> getMensalidadesParaPagar(Matricula matricula);

	
	public Mensalidades findByMesReferenciaAndMatricula(MesReferencia mes, Matricula matricula);
}
