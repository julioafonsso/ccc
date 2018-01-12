package br.com.julios.ccc.infra.dto.turma.individual;

import br.com.julios.ccc.infra.dto.turma.CadastroTurmaDTO;
import br.com.julios.ccc.util.Util;

public class CadastroAulaIndividualDTO extends CadastroTurmaDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long qtdAulas;
	private Double valorPago;
	private String observacao;
	
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Double getValorPago() {
		return valorPago;
	}
	public void setValorPago(String valorPago) {
		this.valorPago = Util.convertToDouble(valorPago);
	}
	public Long getQtdAulas() {
		return qtdAulas;
	}
	public void setQtdAulas(Long qtdAulas) {
		this.qtdAulas = qtdAulas;
	}
	
	
	
		

}
