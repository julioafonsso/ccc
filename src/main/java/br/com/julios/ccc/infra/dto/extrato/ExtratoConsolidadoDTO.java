package br.com.julios.ccc.infra.dto.extrato;

public class ExtratoConsolidadoDTO {

	private Long idTipoLancamento;
	private String nomeTipoLancamento;
	private Long qtdLancamentos;
	private Double valor;

	public ExtratoConsolidadoDTO(Long idTipoLancamento, String nomeTipoLancamento, Long qtdLancamentos, Double valor) {
		this.setIdTipoLancamento(idTipoLancamento);
		this.setNomeTipoLancamento(nomeTipoLancamento);
		this.setQtdLancamentos(qtdLancamentos);
		this.setValor(valor);

	}

	public Long getIdTipoLancamento() {
		return idTipoLancamento;
	}

	public void setIdTipoLancamento(Long idTipoLancamento) {
		this.idTipoLancamento = idTipoLancamento;
	}

	public String getNomeTipoLancamento() {
		return nomeTipoLancamento;
	}

	public void setNomeTipoLancamento(String nomeTipoLancamento) {
		this.nomeTipoLancamento = nomeTipoLancamento;
	}

	public Long getQtdLancamentos() {
		return qtdLancamentos;
	}

	public void setQtdLancamentos(Long qtdLancamentos) {
		this.qtdLancamentos = qtdLancamentos;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
