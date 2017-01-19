package br.com.julios.ccc.domains;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="mensalidades_pagas")
public class MensalidadesPagas {

	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	
	@ManyToOne
	private MesReferencia mesReferencia;
	
	@OneToOne
	private FluxoCaixa fluxoCaixa;
	
	@ManyToOne
	private Matricula matricula;

	
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

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Long getId() {
		return id;
	}
	
	
	
}
