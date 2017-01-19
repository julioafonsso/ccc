package br.com.julios.ccc.domains;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TIPO_FLUXO_CAIXA")
public class TipoFluxoCaixa {

	public static final long MENSALIDADE = 1;
	public static final long PAGAMENTO_PROFESSOR = 2;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String nome;
	
	@Column
	private boolean indEntrada;
	
	@OneToMany(mappedBy = "tipoFluxo")
	@JsonIgnore
	private List<FluxoCaixa> fluxos;
	
	//Getters and Setters

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
