package br.com.julios.ccc.infra.dto.funcionario.pagamentos;

import java.util.Date;

public class ConsultaComissaoDTO extends ConsultaPagamentoFuncionarioDTO {

	
	public ConsultaComissaoDTO(Long id, Long idFuncionario, String nomeFuncionario, Long mes, Long ano, Double valor,
			Long idAluno, String nomeAluno, Double percentual, Double valorPago, String codigo, String nomeModalidade,
			Double valorMensalidade,
			Date dataMensalidade) {
		this.setId(id);
		this.setIdFuncionario(idFuncionario);
		this.setNomeAluno(nomeAluno);
		this.setMesReferencia(mes + "/" + ano);
		this.setValor(valor);
		this.setIdAluno(idAluno);
		this.setPercentual(percentual);
		this.setValorPago(valorPago);
		this.setCodigo(codigo);
		this.setNomeModalidade(nomeModalidade);
		this.setValorMensalidade(valorMensalidade);
		this.setDataPagamentoMensalidade(dataMensalidade);

	}

	public ConsultaComissaoDTO(Long id, Long idFuncionario, String nomeFuncionario,  Double valor,
			Long idAluno, String nomeAluno, Double percentual, Double valorPago, String codigo, String nomeModalidade,
			
			Date dataMensalidade) {
		this.setId(id);
		this.setIdFuncionario(idFuncionario);
		this.setNomeAluno(nomeAluno);
		this.setValor(valor);
		this.setIdAluno(idAluno);
		this.setPercentual(percentual);
		this.setValorPago(valorPago);
		this.setCodigo("AUV - " +  codigo);
		this.setNomeModalidade(nomeModalidade);
		this.setValorMensalidade(valorMensalidade);
		this.setDataPagamentoMensalidade(dataMensalidade);

	}
	
	
	private Long idAluno;
	private String nomeAluno;
	private Double percentual;
	private Double valorPago;
	private String nomeModalidade;
	private String codigo;
	private Double valorMensalidade;
	private Date dataPagamentoMensalidade;

	public Date getDataPagamentoMensalidade() {
		return dataPagamentoMensalidade;
	}

	public void setDataPagamentoMensalidade(Date dataPagamentoMensalidade) {
		this.dataPagamentoMensalidade = dataPagamentoMensalidade;
	}

	public Double getValorMensalidade() {
		return valorMensalidade;
	}

	public void setValorMensalidade(Double valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}

	public String getNomeModalidade() {
		return nomeModalidade;
	}

	public void setNomeModalidade(String nomeModalidade) {
		this.nomeModalidade = nomeModalidade;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	public Double getValorPago() {
		return valorPago;
	}

	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}

}
