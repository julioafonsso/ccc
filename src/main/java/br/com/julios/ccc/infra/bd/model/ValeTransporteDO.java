package br.com.julios.ccc.infra.bd.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="vale_transporte")
@PrimaryKeyJoinColumn(name="id")
public class ValeTransporteDO extends PagamentoFuncionariosDO {

	
	public void setFuncionario(FuncionarioDO funcionario) {
		super.setFuncionario(funcionario);
		super.setValor(funcionario.getValeTransporte());
	}

	public void cadastrar() {
		this.getRepositorio().cadastrar(this);
		
	}
}
