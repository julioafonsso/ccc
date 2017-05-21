package br.com.julios.ccc.infra.dto.menslidade;

import java.util.Date;

public class ConsultaMensalidadeDTO {
	
	private Long id;
	private String nomeModalidade;
	private Date dataVencimento;
	private Date dataPagamento;
	private String mesReferencia;
	private Double valorMensalidade;
	private Double valorCalculado;
	private Long desconto;
	private String codigoTurma;
	
	
	public ConsultaMensalidadeDTO(Long id,String codigoTurma, String nomeModalidade, Date dataVencimento,
			Long mes, Long ano, Double valorMensalidade, Long desconto) {

		this.setId(id);
		this.setCodigoTurma(codigoTurma);
		this.setNomeModalidade(nomeModalidade);
		this.setDesconto(desconto);
		this.setDataVencimento(dataVencimento);
		this.setMesReferencia(mes, ano);
		this.setValorMensalidade(valorMensalidade);
		this.calculaValor();

	}

	
	public ConsultaMensalidadeDTO(Long id,String codigoTurma, String nomeModalidade, Date dataVencimento,
			Long mes, Long ano, Double valorMensalidade, Date dataPagamento) {

		this.setId(id);
		this.setCodigoTurma(codigoTurma);
		this.setNomeModalidade(nomeModalidade);
		this.setDesconto(desconto);
		this.setDataVencimento(dataVencimento);
		this.setMesReferencia(mes, ano);
		this.setValorMensalidade(valorMensalidade);
		this.setDataPagamento(dataPagamento);

	}

	
	public String getCodigoTurma() {
		return codigoTurma;
	}

	public void setCodigoTurma(String codigoTurma) {
		this.codigoTurma = codigoTurma;
	}

	public Long getDesconto() {
		if (desconto == null)
			return new Long(0);
		return desconto;
	}

	public void setDesconto(Long desconto) {
		this.desconto = desconto;
	}

	
	private void setMesReferencia(Long mes, Long ano) {
		this.setMesReferencia(mes + "/" + ano);
		
	}

	private void calculaValor() {
		if (new Date().after(this.getDataVencimento())) {
			this.setValorCalculado(this.getValorMensalidade() * 1.1);
		} else {
			this.setValorCalculado(this.getValorMensalidade() - (this.getValorMensalidade() * this.getDesconto() / 100));
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeModalidade() {
		return nomeModalidade;
	}

	public void setNomeModalidade(String nomeModalidade) {
		this.nomeModalidade = nomeModalidade;
	}


	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(String mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public Double getValorMensalidade() {
		return valorMensalidade;
	}

	public void setValorMensalidade(Double valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}

	public Double getValorCalculado() {
		return valorCalculado;
	}

	public void setValorCalculado(Double valorCalculado) {
		this.valorCalculado = valorCalculado;
	}


	public Date getDataPagamento() {
		return dataPagamento;
	}


	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	
	
}
