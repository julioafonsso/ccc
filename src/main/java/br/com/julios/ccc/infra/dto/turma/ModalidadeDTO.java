package br.com.julios.ccc.infra.dto.turma;

public class ModalidadeDTO {

	private Long id;
	private String nome;
	
	public ModalidadeDTO() {}
	
	public ModalidadeDTO(Long id, String nome){
		setId(id);
		setNome(nome);
	}
	
	
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
