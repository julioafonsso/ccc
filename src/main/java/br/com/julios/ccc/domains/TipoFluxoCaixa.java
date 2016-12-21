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
	private String nome_fluxo;
	
	@Column
	private boolean ind_entrada;
	
	@ManyToMany(mappedBy = "tipoFluxo")
	private List<FluxoCaixa> fluxos;
	
	//Getters and Setters

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome_fluxo() {
		return nome_fluxo;
	}

	public void setNome_fluxo(String nome_fluxo) {
		this.nome_fluxo = nome_fluxo;
	}

	public boolean isInd_entrada() {
		return ind_entrada;
	}

	public void setInd_entrada(boolean ind_entrada) {
		this.ind_entrada = ind_entrada;
	}

	public List<FluxoCaixa> getFluxos() {
		return fluxos;
	}

	public void setFluxos(List<FluxoCaixa> fluxos) {
		this.fluxos = fluxos;
	}
	

}
