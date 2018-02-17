package br.com.julios.ccc.infra.dto.extrato;

import java.util.Date;

public class ExtratoDetalhadoDTO {

	public Long id;
	public Date data;
	public Double valor;
	public Long quantidade;
	public String observacao;
	public String descricao;

	public ExtratoDetalhadoDTO(
								Long id,
								Date data, 
							   Double valor, 
							   Long quantidade, 
							   String observacao, 
							   String descricao) {
		this.setId(id);
		this.setData(data);
		this.setDescricao(descricao);
		this.setObservacao(observacao);
		this.setQuantidade(quantidade);
		this.setValor(valor);
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}
