package br.com.julios.ccc.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pagamento_professor")
public class PagamentoProfessores {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private TurmaProfessor turmaProfessor;
	
	@ManyToOne
	private MesReferencia mesReferencia;
	
	@OneToOne
	private FluxoCaixa fluxoCaixa;

	public TurmaProfessor getTurmaProfessor() {
		return turmaProfessor;
	}

	public void setTurmaProfessor(TurmaProfessor turmaProfessor) {
		this.turmaProfessor = turmaProfessor;
	}

	public MesReferencia getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(MesReferencia mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public FluxoCaixa getFluxoCaixa() {
		return fluxoCaixa;
	}

	public void setFluxoCaixa(FluxoCaixa fluxoCaixa) {
		this.fluxoCaixa = fluxoCaixa;
	}

	public Long getId() {
		return id;
	}
	
	
}
