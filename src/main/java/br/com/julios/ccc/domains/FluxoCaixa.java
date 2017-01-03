package br.com.julios.ccc.domains;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "FLUXO_CAIXA")
public class FluxoCaixa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private double valor;
	
	@Column
	private String descricao;
	
	@Column(name = "data_fluxo")
	@Temporal(TemporalType.DATE)
	private Date dataFluxo;
	
	@ManyToOne
	@JoinColumn(name = "tipo_fluxo_id")
	private TipoFluxoCaixa tipoFluxo;
	
	@ManyToOne
	private Usuario userLancamento;
	
	
	//Getters and Setters

	public long getId() {
		return id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataFluxo() {
		return dataFluxo;
	}

	public void setDataFluxo(Date dataFluxo) {
		this.dataFluxo = dataFluxo;
	}

	public TipoFluxoCaixa getTipoFluxo() {
		return tipoFluxo;
	}

	public void setTipoFluxo(TipoFluxoCaixa tipoFluxo) {
		this.tipoFluxo = tipoFluxo;
	}
	
	
	

}
