package br.com.julios.ccc.infra.dto.turma;

public class NivelTurmaDTO {

	private Long id;
	private String nome;
	
	public NivelTurmaDTO() {}
	
	public NivelTurmaDTO(Long id, String nome){
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
