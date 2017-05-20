package br.com.julios.ccc.negocio.fluxos;

import java.util.Date;

public class FluxoCaixa {

	private Long idFluxo;
	private Long idTipoFluxo;
	private Date dataFluxo;
	private Double valorFluxo;
	private String observacao;
	private String descricao;
	private Integer qtd;
	
	public Integer getQtd() {
		return qtd;
	}

	protected void setQtd(Integer qtd) {
		this.qtd = qtd;
	}

	protected void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	protected void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public String getDescricao() {
		return descricao;
	}

	private FluxoCaixaRepositorio repositorio;
	
	
	public FluxoCaixa(FluxoCaixaRepositorio fluxoPagamentoRepositorio) {
		this.repositorio = fluxoPagamentoRepositorio;
	}
	
	protected void setIdFluxo(Long idFluxo) {
		this.idFluxo = idFluxo;
	}
	public Long getIdFluxo() {
		return idFluxo;
	}
	public Long getIdTipoFluxo() {
		return idTipoFluxo;
	}
	public Date getDataFluxo() {
		return dataFluxo;
	}
	public Double getValorFluxo() {
		return valorFluxo;
	}
	protected void setIdTipoFluxo(Long idTipoFluxo) {
		this.idTipoFluxo = idTipoFluxo;
	}
	protected void setDataFluxo(Date dataFluxo) {
		this.dataFluxo = dataFluxo;
	}
	protected void setValorFluxo(Double valorFluxo) {
		this.valorFluxo = valorFluxo;
	}

	public void cadastrar() {
		this.repositorio.cadastrar(this);
	}
	
}
