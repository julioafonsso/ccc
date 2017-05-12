package br.com.julios.ccc.infra.bd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="workshop")
@PrimaryKeyJoinColumn(name="id")
public class WorkShopDO extends TurmaDO{
	
	@ManyToOne
	@JoinColumn(name="id_funcionario_2")
	private FuncionarioDO funcionario2;
	
	@Column
	private Double percentualFuncionario2;

	public FuncionarioDO getFuncionario2() {
		return funcionario2;
	}

	public void setFuncionario2(FuncionarioDO funcionario2) {
		this.funcionario2 = funcionario2;
	}

	public Double getPercentualFuncionario2() {
		return percentualFuncionario2;
	}

	public void setPercentualFuncionario2(Double percentualFuncionario2) {
		this.percentualFuncionario2 = percentualFuncionario2;
	}
	
	
}
