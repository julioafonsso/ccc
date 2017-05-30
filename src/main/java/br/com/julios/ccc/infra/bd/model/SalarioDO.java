package br.com.julios.ccc.infra.bd.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="salarios")
@PrimaryKeyJoinColumn(name="id")
public class SalarioDO extends PagamentoFuncionariosDO{

	public void setFuncionario(FuncionarioDO funcionario) {
		super.setFuncionario(funcionario);
		super.setValor(funcionario.getSalario());
	}

	public void cadastrar() {
		this.getRepositorio().cadastrar(this);
		
	}

	
}
