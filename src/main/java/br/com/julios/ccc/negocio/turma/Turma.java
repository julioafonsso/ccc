package br.com.julios.ccc.negocio.turma;

public class Turma {

	private Long id;

	private Long idProfessor1;
	private Double percentualProfessor1;
	private Long idModalidade;
	protected Long getId() {
		return id;
	}
	protected void setId(Long id) {
		this.id = id;
	}
	protected Long getIdProfessor1() {
		return idProfessor1;
	}
	protected void setIdProfessor1(Long idProfessor1) {
		this.idProfessor1 = idProfessor1;
	}
	protected Double getPercentualProfessor1() {
		return percentualProfessor1;
	}
	protected void setPercentualProfessor1(Double percentualProfessor1) {
		this.percentualProfessor1 = percentualProfessor1;
	}
	protected Long getIdModalidade() {
		return idModalidade;
	}
	protected void setIdModalidade(Long idModalidade) {
		this.idModalidade = idModalidade;
	}
	
	

	
	
}
