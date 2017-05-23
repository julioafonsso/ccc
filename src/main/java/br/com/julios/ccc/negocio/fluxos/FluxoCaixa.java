package br.com.julios.ccc.negocio.fluxos;

import java.util.Date;

import br.com.julios.ccc.infra.dto.CadastroFluxoCaixaDTO;

public class FluxoCaixa {

	protected FluxoCaixa(CadastroFluxoCaixaDTO cadastro, FluxoCaixaRepositorio fluxoPagamentoRepositorio) {
		this.setRepositorio(fluxoPagamentoRepositorio);
		this.setIdFluxo(cadastro.getId());
		this.setDataFluxo(cadastro.getData());
		this.setDescricao(cadastro.getDescricao());
		this.setObservacao(cadastro.getObservacao());
		this.setIdTipoFluxo(cadastro.getIdTipo());
		this.setValorFluxo(cadastro.getValor());
		this.setQtd(cadastro.getQtd());

	}

	private FluxoCaixaRepositorio repositorio;

	private Long idFluxo;
	private Long idTipoFluxo;
	private Date dataFluxo;
	private Double valorFluxo;
	private String observacao;
	private String descricao;
	private Long qtd;

	private FluxoCaixaRepositorio getRepositorio() {
		return repositorio;
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

	public String getObservacao() {
		return observacao;
	}

	public String getDescricao() {
		return descricao;
	}

	public Long getQtd() {
		return qtd;
	}

	private void setRepositorio(FluxoCaixaRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	protected void setIdFluxo(Long idFluxo) {
		this.idFluxo = idFluxo;
	}

	private void setIdTipoFluxo(Long idTipoFluxo) {
		this.idTipoFluxo = idTipoFluxo;
	}

	private void setDataFluxo(Date dataFluxo) {
		this.dataFluxo = dataFluxo;
	}

	private void setValorFluxo(Double valorFluxo) {
		this.valorFluxo = valorFluxo;
	}

	private void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	private void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	private void setQtd(Long qtd) {
		this.qtd = qtd;
	}

	public void cadastrar() {

		if (this.getDataFluxo() == null)
			this.setDataFluxo(new Date());

		this.getRepositorio().cadastrar(this);
	}

	
}
