package br.com.julios.ccc.domains;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_FLUXO_CAIXA")
public class TipoFluxoCaixa {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String nomeFluxo;
	
	@Column
	private boolean indEntrada;
	
	@ManyToMany(mappedBy = "tipoFluxo")
	private List<FluxoCaixa> fluxos;
	
	//Getters and Setters

	public long getId() {
		return id;
	}

	public String getNomeFluxo() {
		return nomeFluxo;
	}

	public void setNomeFluxo(String nomeFluxo) {
		this.nomeFluxo = nomeFluxo;
	}

	public boolean isIndEntrada() {
		return indEntrada;
	}

	public void setIndEntrada(boolean indEntrada) {
		this.indEntrada = indEntrada;
	}

	public List<FluxoCaixa> getFluxos() {
		return fluxos;
	}

	public void setFluxos(List<FluxoCaixa> fluxos) {
		this.fluxos = fluxos;
	}
	

}
