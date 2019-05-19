package br.com.julios.ccc.infra.dto.turma.coletiva;

import java.util.Date;

public class ConsultaHistoricoPagamentoTurmaDTO {

	private String nomeAluno;
	private String mesReferencia;
	private Date dataVencimento;
	private Date dataPagamento;
	private Double valorPago;
	private Double valorMensalidade;
	
	

	
	public ConsultaHistoricoPagamentoTurmaDTO(
			String nomeAluno, 
			Long mesReferencia,
			Long anoReferencia, 
			Date dataVencimento, 
			Date dataPagamento, 
			Double valorPago, 
			Double valorMensalidade) {
		
		this.setDataPagamento(dataPagamento);
		this.setDataVencimento(dataVencimento);
		this.setNomeAluno(nomeAluno);
		this.setValorPago(valorPago);
		this.setValorMensalidade(valorMensalidade);
		
		
		if (mesReferencia != null)
			this.setMesReferencia(mesReferencia + "/" + anoReferencia);
		else
			this.setMesReferencia("");
		
		
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


	public String getNomeAluno() {
		return nomeAluno;
	}


	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}


	public Double getValorMensalidade() {
		return valorMensalidade;
	}


	public void setValorMensalidade(Double valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}
	
}
