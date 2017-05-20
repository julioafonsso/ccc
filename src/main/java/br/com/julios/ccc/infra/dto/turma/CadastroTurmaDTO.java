package br.com.julios.ccc.infra.dto.turma;

import java.text.SimpleDateFormat;

public class CadastroTurmaDTO {

	protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private Long id;
	private Long idProfessor1;
	private Double percentualProfessor1;
	private Long idModalidade;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getIdProfessor1() {
		return idProfessor1;
	}
	public void setIdProfessor1(Long idProfessor1) {
		this.idProfessor1 = idProfessor1;
	}
	public Double getPercentualProfessor1() {
		return percentualProfessor1;
	}
	public void setPercentualProfessor1(Double percentualProfessor1) {
		this.percentualProfessor1 = percentualProfessor1;
	}
	public Long getIdModalidade() {
		return idModalidade;
	}
	public void setIdModalidade(Long idModalidade) {
		this.idModalidade = idModalidade;
	}
	
	


}
