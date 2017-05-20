package br.com.julios.ccc.negocio.bairro;

import br.com.julios.ccc.infra.dto.bairro.CadastroBairroDTO;

public class Bairro {

	BairroRepositorio repositorio;
	
	private Long id;
	private String nome;
	private String zona;
	
	protected void setId(Long id) {
		this.id = id;
	}

	protected void setNome(String nome) {
		this.nome = nome;
	}

	protected void setZona(String zona) {
		this.zona = zona;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getZona() {
		return zona;
	}

	public Bairro(CadastroBairroDTO cadastro, BairroRepositorio bairroRepositorio) {
		this.setId(cadastro.getId());
		this.setNome(cadastro.getNome());
		this.setZona(cadastro.getZona());
		this.repositorio = bairroRepositorio;
	}
	
	public void cadastrar(){
		repositorio.cadastrar(this);
	}

}
