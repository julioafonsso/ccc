package br.com.julios.ccc.domains;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "TIPO_FLUXO_CAIXA")
public class TipoFluxoCaixa {

	public static final long MENSALIDADE = 1;
	public static final long PAGAMENTO_PROFESSOR = 2;
	public static final long MATRICULA = 3;
	public static final long AULA_PARTICULAR = 4;
	public static final long WORKSHOP = 5;
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String nome;
	
	@Column
	private boolean indEntrada;
	
	@Column
	private Date dataExclusao;
	
	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

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

	public void validaExisteFluxoCaixa(TipoFluxoCaixa tipoFluxoCaixa) throws Exception {
		if(!tipoFluxoCaixa.getFluxos().isEmpty())
			throw new Exception("Tipo Fluxo não pode ser apagado! \n Existe Fluxo Caixa desse Tipo Fluxo!");
		
	}
	

}

