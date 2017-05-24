package br.com.julios.ccc.infra.bd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pagamento_funcionarios")
@Inheritance(strategy = InheritanceType.JOINED)
public class PagamentoFuncionariosDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_funcionario")
	private FuncionarioDO funcionario;

	@Column(name = "valor")
	private Double valor;

	@ManyToOne
	@JoinColumn(name = "id_mes_referencia")
	private MesReferenciaDO mesReferencia;

	@ManyToOne
	@JoinColumn(name = "id_fluxo_caixa")
	private FluxoCaixaDO fluxoCaixa;

	@Column
	private Date dataExclusao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public FuncionarioDO getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioDO funcionario) {
		this.funcionario = funcionario;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public MesReferenciaDO getMesReferencia() {
		return mesReferencia;
	}

	
	public void setMesReferencia(MesReferenciaDO mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public void setFluxoCaixa(FluxoCaixaDO fluxoCaixa) {
		this.fluxoCaixa = fluxoCaixa;
	}

	public FluxoCaixaDO getFluxoCaixa() {
		return fluxoCaixa;
	}

	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

}
