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
import br.com.julios.ccc.infra.dto.DescontoDTO;
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

	public void setNome(String nome) throws Exception {
		DescontosDO desconto = this.getRepositorio().getDesconto(nome);
		if(desconto != null)
		{
			if(!desconto.getId().equals(this.getId()))
			{
				throw new Exception("Desconto já cadastrado!");
			}
				
		}
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

	public void alterar(DescontoDTO desconto) throws Exception {
		this.setNome(desconto.getNome());
		this.setValor(desconto.getValor());
		this.cadastrar();
	}

	public void deletar() throws Exception {
		if(this.getRepositorio().getQtdMatriculas(this).longValue() <0 )
			throw new Exception("Existe Alunos matriculados com esse desconto!");
		
		this.setDataExclusao(new Date());
		this.cadastrar();
	}
	
	

}
