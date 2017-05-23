package br.com.julios.ccc.infra.dto.turma.individual;

import br.com.julios.ccc.infra.dto.turma.CadastroTurmaDTO;

public class CadastroAulaIndividualDTO extends CadastroTurmaDTO {

	private Long qtdAulas;
	private Double valorPago;
	
	public Double getValorPago() {
		return valorPago;
	}
	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}
	public Long getQtdAulas() {
		return qtdAulas;
	}
	public void setQtdAulas(Long qtdAulas) {
		this.qtdAulas = qtdAulas;
	}
	
	
	
		

}
