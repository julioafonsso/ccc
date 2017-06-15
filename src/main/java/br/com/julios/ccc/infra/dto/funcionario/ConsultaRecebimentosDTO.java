package br.com.julios.ccc.infra.dto.funcionario;

import java.util.Date;

public class ConsultaRecebimentosDTO {


	private Date dataPagamento;
	private Double valorPago;
	private String tipoPagamento;
	private String mesReferencia;
	private Long idPagamento;
	
	public Long getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Long idPagamento) {
		this.idPagamento = idPagamento;
	}

	public ConsultaRecebimentosDTO(Long mesReferencia,
			Long anoReferencia, Date dataPagamento, Double valorPago, String tipoPagamento, Long idPagamento) {
		
		this.setDataPagamento(dataPagamento);
		
		if (mesReferencia != null)
			this.setMesReferencia(mesReferencia + "/" + anoReferencia);
		else
			this.setMesReferencia("");
		
		this.setTipoPagamento(tipoPagamento);
		this.setValorPago(valorPago);
		this.setIdPagamento(idPagamento);
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
	public String getMesReferencia() {
		return mesReferencia;
	}
	public void setMesReferencia(String mesReferencia) {
		this.mesReferencia = mesReferencia;
	}
	
}
