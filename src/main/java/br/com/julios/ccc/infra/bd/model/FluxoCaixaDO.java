package br.com.julios.ccc.infra.bd.model;

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
@Table(name = "fluxo_caixa")
public class FluxoCaixaDO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private Double valor;
	
	@Column
	private Integer quantidade;
	
	@Column
	private String descricao;
	
	@Column
	private String observacao;
	
	
	@Column(name = "data_fluxo")
	private Date data;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_fluxo")
	private TipoFluxoCaixaDO tipoFluxo;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private UsuarioDO userLancamento;

	
	
	//Getters and Setters

	public void setData(String data) throws Exception {
		this.data = Util.parseDate(data);
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public TipoFluxoCaixaDO getTipoFluxo() {
		return tipoFluxo;
	}


	public UsuarioDO getUserLancamento() {
		return userLancamento;
	}

	public Date getData() {
		return data;
	}

	

}
