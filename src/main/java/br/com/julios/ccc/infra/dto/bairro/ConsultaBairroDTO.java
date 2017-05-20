package br.com.julios.ccc.infra.dto.bairro;

public class ConsultaBairroDTO {

	public ConsultaBairroDTO(Long id, String nome, String zona) {
		this.setId(id);
		this.setNome(nome);
		this.setZona(zona);
	}

	private Long id;
	private String nome;
	private String zona;
	
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
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	
}
