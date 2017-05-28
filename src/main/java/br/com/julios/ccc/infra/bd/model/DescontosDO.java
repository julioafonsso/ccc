package br.com.julios.ccc.infra.bd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.julios.ccc.infra.Contexto;
import br.com.julios.ccc.negocio.desconto.DescontoRepositorio;

@Entity
@Table(name = "tipo_desconto")
public class DescontosDO {
	
	@Transient
	DescontoRepositorio repositorio;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private Long valor;
	
	@Column
	private Date dataExclusao;

	//Getters and Setters
	
	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}


	public DescontoRepositorio getRepositorio() {
		if(this.repositorio == null)
			this.repositorio = Contexto.bean(DescontoRepositorio.class);
		return repositorio;
	}

	public void cadastrar() {
		this.getRepositorio().cadastrar(this);
		
	}
	
	

}
