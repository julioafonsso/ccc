package br.com.julios.ccc.infra.dto.turma.cadastro;

import java.util.Date;

public class CadastroAulaIndividual extends CadastroTurma{
	
	private Integer qtdAulasContratadas;
	private Integer qtdAulasRestantes;
	private Date dataContratacao;
	private Date dataUltimaAula;
	private Double valorPago;
	public Integer getQtdAulasContratadas() {
		return qtdAulasContratadas;
	}
	public void setQtdAulasContratadas(Integer qtdAulasContratadas) {
		this.qtdAulasContratadas = qtdAulasContratadas;
	}
	public Integer getQtdAulasRestantes() {
		return qtdAulasRestantes;
	}
	public void setQtdAulasRestantes(Integer qtdAulasRestantes) {
		this.qtdAulasRestantes = qtdAulasRestantes;
	}
	public Date getDataContratacao() {
		return dataContratacao;
	}
	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
	public Date getDataUltimaAula() {
		return dataUltimaAula;
	}
	public void setDataUltimaAula(Date dataUltimaAula) {
		this.dataUltimaAula = dataUltimaAula;
	}
	public Double getValorPago() {
		return valorPago;
	}
	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}
	
	

}
