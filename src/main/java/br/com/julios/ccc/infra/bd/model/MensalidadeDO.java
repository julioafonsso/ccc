package br.com.julios.ccc.infra.bd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mensalidade")
public class MensalidadeDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_mes_referencia")
	private MesReferenciaDO mesReferencia;

	
	@OneToOne
	@JoinColumn(name="id_fluxo_caixa")
	private FluxoCaixaDO fluxoCaixa;

	@ManyToOne
	@JoinColumn(name="id_matricula")
	private MatriculaDO matricula;
	
	@Column
	private Double valorMensalidade;
	
	@Column
	private Date dataVencimento;
	
	@Column
	private Date dataExclusao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MesReferenciaDO getMesReferencia() {
		return mesReferencia;
	}

	public FluxoCaixaDO getFluxoCaixa() {
		return fluxoCaixa;
	}

	public MatriculaDO getMatricula() {
		return matricula;
	}


	public Double getValorMensalidade() {
		return valorMensalidade;
	}

	public void setValorMensalidade(Double valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	
	

	
}
