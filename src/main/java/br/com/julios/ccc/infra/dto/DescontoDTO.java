package br.com.julios.ccc.infra.dto;

public class DescontoDTO {

	public DescontoDTO(){}
	public DescontoDTO(Long id, String nome, Long valor){
		this.setId(id);
		this.setNome(nome);
		this.setValor(valor);
	}
	
	private Long id;
	private String nome;
	private Long valor;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	
	
}
