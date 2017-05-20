package br.com.julios.ccc.negocio.turma.individual;

import java.util.Date;

import br.com.julios.ccc.negocio.turma.Turma;

public class AulaIndividual extends Turma{
	
	private Integer qtdAulasContratadas;
	private Integer qtdAulasRestantes;
	private Date dataContratacao;
	private Date dataUltimaAula;
	private Double valorPago;
	
	protected Integer getQtdAulasContratadas() {
		return qtdAulasContratadas;
	}
	protected void setQtdAulasContratadas(Integer qtdAulasContratadas) {
		this.qtdAulasContratadas = qtdAulasContratadas;
	}
	protected Integer getQtdAulasRestantes() {
		return qtdAulasRestantes;
	}
	protected void setQtdAulasRestantes(Integer qtdAulasRestantes) {
		this.qtdAulasRestantes = qtdAulasRestantes;
	}
	protected Date getDataContratacao() {
		return dataContratacao;
	}
	protected void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
	protected Date getDataUltimaAula() {
		return dataUltimaAula;
	}
	protected void setDataUltimaAula(Date dataUltimaAula) {
		this.dataUltimaAula = dataUltimaAula;
	}
	protected Double getValorPago() {
		return valorPago;
	}
	protected void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}
	@Override
	public String getCodigo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	

}
