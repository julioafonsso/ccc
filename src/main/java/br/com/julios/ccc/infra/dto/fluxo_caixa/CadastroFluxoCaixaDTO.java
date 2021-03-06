package br.com.julios.ccc.infra.dto.fluxo_caixa;

import java.text.ParseException;
import java.util.Date;

import br.com.julios.ccc.util.Util;

public class CadastroFluxoCaixaDTO {

	private Long id;
	private Long idTipo;
	private Double valor;
	private String observacao;
	private String descricao;
	private Date data;
	private Long qtd;
	private String tipo;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Long getQtd() {
		return qtd;
	}
	public void setQtd(Long qtd) {
		this.qtd = qtd;
	}
	public Long getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = Util.convertToDouble(valor);
	}
	public void setValor(Double valor)
	{
		this.valor = valor;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		if(observacao != null)
			this.observacao = observacao.toUpperCase();
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao.toUpperCase();
	}
	public Date getData() {
		return data;
	}
	public void setData(String data) throws ParseException {
		this.data = Util.parseDate(data);
	}
	public void setData(Date data)
	{
		this.data = data;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public long getId() {
		return this.id;
	}
	
	
	
}
