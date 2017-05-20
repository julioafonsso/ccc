package br.com.julios.ccc.negocio.desconto;

import br.com.julios.ccc.infra.dto.DescontoDTO;

public class Desconto {
	
	private DescontoRepositorio repositorio;
	
	private Long id;
	private String nome;
	private Long valor;
	public Desconto(DescontoDTO cadastro, DescontoRepositorio descontoRepositorio) {
		this.repositorio = descontoRepositorio;
		this.setId(cadastro.getId());
		this.setNome(cadastro.getNome());
		this.setValor(cadastro.getValor());
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public Long getValor() {
		if(this.valor == null)
			return new Long(0);
		return valor;
	}
	protected void setId(Long id) {
		this.id = id;
	}
	protected void setNome(String nome) {
		this.nome = nome;
	}
	protected void setValor(Long valor) {
		this.valor = valor;
	}
	
	public void cadastrar(){
		this.repositorio.cadastrar(this);
	}
	
	

}
