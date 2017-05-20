package br.com.julios.ccc.infra.dto.turma;

public class ConsultaTurmaDTO {

	public ConsultaTurmaDTO( Long id,String codigo , Long idProfessor1, String nomeProfessor1, Double percentualProfessor1,
			Long idModalidade, String nomeModalidade) {
		setId(id);
		setIdProfessor1(idProfessor1);
		setNomeProfessor1(nomeProfessor1);
		setPercentualProfessor1(percentualProfessor1);
		setIdModalidade(idModalidade);
		setNomeModalidade(nomeModalidade);
		setCodigo(codigo);
	}

	private Long id;
	private Long idProfessor1;
	private String nomeProfessor1;
	private Double percentualProfessor1;
	private Long idModalidade;
	private String nomeModalidade;
	private String codigo;
	

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

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

	public String getNomeProfessor1() {
		return nomeProfessor1;
	}

	public void setNomeProfessor1(String nomeProfessor1) {
		this.nomeProfessor1 = nomeProfessor1;
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

	public String getNomeModalidade() {
		return nomeModalidade;
	}

	public void setNomeModalidade(String nomeModalidade) {
		this.nomeModalidade = nomeModalidade;
	}

}
