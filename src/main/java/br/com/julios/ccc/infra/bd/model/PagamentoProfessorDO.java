package br.com.julios.ccc.infra.bd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pagamento_professor")
public class PagamentoProfessorDO extends SalarioDO{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name="id_mensalidade")
	private MensalidadeDO mensalidade;

	@Column
	private Double percentual;
	
	@Column
	private Double percentualDesconto;
	
	@ManyToOne
	@JoinColumn(name="id_desconto")
	private DescontosDO desconto;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MensalidadeDO getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(MensalidadeDO mensalidade) {
		this.mensalidade = mensalidade;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	public Double getPercentualDesconto() {
		return percentualDesconto;
	}

	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}


	public DescontosDO getDesconto() {
		return desconto;
	}
	
	
	
	
}
