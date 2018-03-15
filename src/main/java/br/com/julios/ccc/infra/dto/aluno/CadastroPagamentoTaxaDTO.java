package br.com.julios.ccc.infra.dto.aluno;

import java.text.ParseException;
import java.util.Date;

import br.com.julios.ccc.util.Util;

public class CadastroPagamentoTaxaDTO {

	private Long id;
	private Double valor;
	private String observacao;
	private Date dataPagamento;
	
	
	

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(String dataPagamento ) throws ParseException {
		this.dataPagamento = Util.parseDate(dataPagamento);
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
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
	
}
