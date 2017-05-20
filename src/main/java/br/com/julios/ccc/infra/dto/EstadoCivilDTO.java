package br.com.julios.ccc.infra.dto;

public class EstadoCivilDTO {

	public EstadoCivilDTO(Long id, String nome) {
		this.setId(id);
		this.setNome(nome);
	}

	private Long id;
	private String nome;

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

}
