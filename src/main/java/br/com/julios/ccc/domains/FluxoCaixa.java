package br.com.julios.ccc.domains;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.julios.ccc.util.Util;

@Entity
@Table(name = "FLUXO_CAIXA")
public class FluxoCaixa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private double valor;
	
	@Column
	private double quantidade;
	
	@Column
	private String descricao;
	
	@Column
	private String observacao;
	
	
	@Column(name = "data_fluxo")
	private Date data;
	
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

	public Date getData	() {
		return data;
	}

	public void setData(String data) throws Exception {
		this.data = Util.parseDate(data);
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public TipoFluxoCaixa getTipoFluxo() {
		return tipoFluxo;
	}

	public void setTipoFluxo(TipoFluxoCaixa tipoFluxo) {
		this.tipoFluxo = tipoFluxo;
	}

	
	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
