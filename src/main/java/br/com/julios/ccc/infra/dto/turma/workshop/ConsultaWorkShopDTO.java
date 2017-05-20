package br.com.julios.ccc.infra.dto.turma.workshop;

import br.com.julios.ccc.infra.dto.turma.ConsultaTurmaDTO;

public class ConsultaWorkShopDTO extends ConsultaTurmaDTO{

	public ConsultaWorkShopDTO(Long id,String codigo, Long idProfessor1, String nomeProfessor1, Double percentualProfessor1,
			Long idModalidade, String nomeModalidade) {
		super(id,codigo, idProfessor1, nomeProfessor1, percentualProfessor1, idModalidade, nomeModalidade);
	}
	private Long idProfessor2;
	private String nomeProfessor2;
	private Double percentualProfessor2;
	
	public Long getIdProfessor2() {
		return idProfessor2;
	}
	public void setIdProfessor2(Long idProfessor2) {
		this.idProfessor2 = idProfessor2;
	}
	public String getNomeProfessor2() {
		return nomeProfessor2;
	}
	public void setNomeProfessor2(String nomeProfessor2) {
		this.nomeProfessor2 = nomeProfessor2;
	}
	public Double getPercentualProfessor2() {
		return percentualProfessor2;
	}
	public void setPercentualProfessor2(Double percentualProfessor2) {
		this.percentualProfessor2 = percentualProfessor2;
	}
	
	
	
}
