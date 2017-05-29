package br.com.julios.ccc.infra.bd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.julios.ccc.infra.Contexto;
import br.com.julios.ccc.negocio.bairro.BairroRepositorio;

@Entity
@Table(name = "bairro")
public class BairroDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String zona;

	@Column(nullable = false)
	private String nome;

	public Long getId() {
		return id;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Exception {
		BairroDO bairro = this.getRepositorio().getBairro(nome);
		if(bairro != null)
		{
			if(!bairro.getId().equals(this.getId()))
			{
				throw new Exception("Bairro já cadastrado !");
			}
		}
		this.nome = nome;
	}

	@Transient
	private BairroRepositorio repositorio;
	
	
	private BairroRepositorio getRepositorio() {
		if(this.repositorio == null)
			this.repositorio = Contexto.bean(BairroRepositorio.class);
		return repositorio;
	}

	public void cadastrar(){
		this.getRepositorio().cadastrar(this);
	}
	
	
}
