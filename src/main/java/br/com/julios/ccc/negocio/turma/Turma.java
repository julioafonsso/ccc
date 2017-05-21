package br.com.julios.ccc.negocio.turma;

import br.com.julios.ccc.negocio.funcionario.Funcionario;

public abstract class Turma {

	protected TurmaRepositorio turmaRepositorio;
	
	protected TurmaRepositorio getTurmaRepositorio() {
		return turmaRepositorio;
	}
	protected void setTurmaRepositorio(TurmaRepositorio turmaRepositorio) {
		this.turmaRepositorio = turmaRepositorio;
	}

	private Long id;

	private Long idProfessor1;
	private Funcionario professor1;
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
	
	public Funcionario getProfessor1() throws Exception
	{
		if(this.professor1 == null){
			this.professor1 = this.getTurmaRepositorio().getProfessor(this.getIdProfessor1());
		}
		
		return this.professor1;
	}
	
}
