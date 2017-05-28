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

	
	
	
}
