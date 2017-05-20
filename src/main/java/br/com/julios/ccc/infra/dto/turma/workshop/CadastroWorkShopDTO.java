package br.com.julios.ccc.infra.dto.turma.workshop;

import br.com.julios.ccc.infra.dto.turma.CadastroTurmaDTO;

public class CadastroWorkShopDTO extends CadastroTurmaDTO{

	private Long idProfessor2;
	private Double percentualProfessor2;
	public Long getIdProfessor2() {
		return idProfessor2;
	}
	public void setIdProfessor2(Long idProfessor2) {
		this.idProfessor2 = idProfessor2;
	}
	public Double getPercentualProfessor2() {
		return percentualProfessor2;
	}
	public void setPercentualProfessor2(Double percentualProfessor2) {
		this.percentualProfessor2 = percentualProfessor2;
	}
	
	
	
}
