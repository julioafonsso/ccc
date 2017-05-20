package br.com.julios.ccc.negocio.turma;

public abstract class Turma {

	private Long id;

	private Long idProfessor1;
	private Double percentualProfessor1;
	private Long idModalidade;
	protected void setId(Long id) {
		this.id = id;
	}
	protected void setIdProfessor1(Long idProfessor1) {
		this.idProfessor1 = idProfessor1;
	}
	protected void setPercentualProfessor1(Double percentualProfessor1) {
		this.percentualProfessor1 = percentualProfessor1;
	}
	protected void setIdModalidade(Long idModalidade) {
		this.idModalidade = idModalidade;
	}
	public Long getId() {
		return id;
	}
	public Long getIdProfessor1() {
		return idProfessor1;
	}
	public Double getPercentualProfessor1() {
		return percentualProfessor1;
	}
	public Long getIdModalidade() {
		return idModalidade;
	}
	
	public abstract String getCodigo();
	
	
}
