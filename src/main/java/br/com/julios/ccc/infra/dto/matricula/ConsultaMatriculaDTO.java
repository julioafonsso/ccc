package br.com.julios.ccc.infra.dto.matricula;

public class ConsultaMatriculaDTO {

	private Long id ;
	private Long idTurma ;
	private String codigo ;
	private Long idModalidade ;
	private String nomeModalidade ;
	private Long idNivel ;
	private String nomeNivel ;
	private Long idSala ;
	private String nomeSala ;
	private Long diaVencimento ;
	
	public ConsultaMatriculaDTO(	
			Long id ,
			Long idTurma ,
			String codigo ,
			Long idModalidade ,
			String nomeModalidade ,
			Long idNivel ,
			String nomeNivel ,
			Long idSala ,
			String nomeSala ,
			Long diaVencimento ){

		this.setId(id) ;
		this.setIdTurma(idTurma) ;
		this.setCodigo(codigo) ;
		this.setIdModalidade(idModalidade) ;
		this.setNomeModalidade(nomeModalidade) ;
		this.setIdNivel(idNivel) ;
		this.setNomeNivel(nomeNivel) ;
		this.setIdSala(idSala) ;
		this.setNomeSala(nomeSala) ;
		this.setDiaVencimento(diaVencimento) ;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(Long idTurma) {
		this.idTurma = idTurma;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public Long getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(Long idNivel) {
		this.idNivel = idNivel;
	}

	public String getNomeNivel() {
		return nomeNivel;
	}

	public void setNomeNivel(String nomeNivel) {
		this.nomeNivel = nomeNivel;
	}

	public Long getIdSala() {
		return idSala;
	}

	public void setIdSala(Long idSala) {
		this.idSala = idSala;
	}

	public String getNomeSala() {
		return nomeSala;
	}

	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}

	public Long getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(Long diaVencimento) {
		this.diaVencimento = diaVencimento;
	}
	
	
	
}
