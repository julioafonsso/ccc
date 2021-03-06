package br.com.julios.ccc.infra.dto.aluno;

import java.util.Date;

public class ConsultaHistoricoPagamentoDTO {

	private String codigoTurma;
	private String nomeModalidade;
	private String mesReferencia;
	private Date dataVencimento;
	private Date dataPagamento;
	private Double valorPago;
	private String tipoPagamento;
	private Long idPagamento;
	private String observacao;
	

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Long getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Long idPagamento) {
		this.idPagamento = idPagamento;
	}

	public ConsultaHistoricoPagamentoDTO(
			String codigoTurma, 
			String nomeModalidade, 
			Long mesReferencia,
			Long anoReferencia, 
			Date dataVencimento, 
			Date dataPagamento, 
			Double valorPago, 
			String tipoPagamento, 
			Long idPagamento) {
		
		this.setCodigoTurma(codigoTurma);
		this.setDataPagamento(dataPagamento);
		this.setDataVencimento(dataVencimento);
		
		if (mesReferencia != null)
			this.setMesReferencia(mesReferencia + "/" + anoReferencia);
		else
			this.setMesReferencia("");
		
		this.setNomeModalidade(nomeModalidade);
		this.setTipoPagamento(tipoPagamento);
		this.setValorPago(valorPago);
		this.setIdPagamento(idPagamento);
	}

	public ConsultaHistoricoPagamentoDTO(
			String codigoTurma, 
			String nomeModalidade,  
			Date dataVencimento, 
			Date dataPagamento, 
			Double valorPago, 
			String tipoPagamento, 
			Long idPagamento) {
		
		this.setCodigoTurma(codigoTurma);
		this.setDataPagamento(dataPagamento);
		this.setDataVencimento(dataVencimento);
		this.setNomeModalidade(nomeModalidade);
		this.setTipoPagamento(tipoPagamento);
		this.setValorPago(valorPago);
		this.setIdPagamento(idPagamento);
	}


	public ConsultaHistoricoPagamentoDTO(
			String codigoTurma, 
			Date dataPagamento, 
			Double valorPago, 
			String tipoPagamento, 
			Long idPagamento,
			String observacao) {
		
		this.setCodigoTurma(codigoTurma);
		this.setDataPagamento(dataPagamento);
		this.setDataVencimento(dataVencimento);
		this.setNomeModalidade(nomeModalidade);
		this.setTipoPagamento(tipoPagamento);
		this.setValorPago(valorPago);
		this.setIdPagamento(idPagamento);
		this.setObservacao(observacao);
	}

	
	public String getCodigoTurma() {
		return codigoTurma;
	}

	public void setCodigoTurma(String codigoTurma) {
		this.codigoTurma = codigoTurma;
	}

	public String getNomeModalidade() {
		return nomeModalidade;
	}

	public void setNomeModalidade(String nomeModalidade) {
		this.nomeModalidade = nomeModalidade;
	}

	public String getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(String mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

}
