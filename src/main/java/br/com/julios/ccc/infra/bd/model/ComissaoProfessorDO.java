package br.com.julios.ccc.infra.bd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "pagamento_professor")
@PrimaryKeyJoinColumn(name="id")
public class ComissaoProfessorDO extends PagamentoFuncionariosDO{

	@ManyToOne
	@JoinColumn(name="id_mensalidade")
	private MensalidadeDO mensalidade;

	@Column
	private Double percentual;
	
	@ManyToOne
	@JoinColumn(name="id_taxa")
	private TaxasPagasDO taxa;

	public TaxasPagasDO getTaxa() {
		return taxa;
	}

	public void setTaxa(TaxasPagasDO taxa) {
		this.taxa = taxa;
		this.setPercentual(this.getTaxa().getTurma().getPercentual(this.getFuncionario()));
	}

	public MensalidadeDO getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(MensalidadeDO mensalidade) {
		this.mensalidade = mensalidade;
		this.setPercentual(mensalidade.getPercentualFuncionario(this.getFuncionario()));
	}

	public Double getPercentual() {
		return percentual;
	}

	private void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	private void calcular() {
		if(this.getMensalidade() != null)
			this.setValor(this.getMensalidade().getValorPago() * this.getPercentual() / 100);
		else
			this.setValor(this.getTaxa().getPagamento().getValor() * this.getPercentual()/100);
		
	}

	public void cadastrar() {
		this.calcular();
		this.getRepositorio().cadastrar(this);
	}

	public String getNomeFuncionario() {
		return this.getFuncionario().getNome();
	}

	public String getNomeMes() {
		return this.getMesReferencia().getNomeMes();
	}

	public String getCodigoTurma() {
		return this.getMensalidade().getCodigoTurma();
	}

	public String getNomeAluno() {
		return this.getMensalidade().getNomeAluno();
	}

	public Double getValorPagoMensalidade() {

		return this.getMensalidade().getValorPago();
	}
}
