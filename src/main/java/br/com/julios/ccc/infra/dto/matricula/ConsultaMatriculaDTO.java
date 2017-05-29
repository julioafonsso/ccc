package br.com.julios.ccc.infra.dto.matricula;

import java.util.Date;

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
	public Long idDesconto;
    public String nomeDesconto;
    public Long valorDesconto;
	public Date dataInicio;
	public Date dataFim;
	public Date dataMatricula;
    
    public ConsultaMatriculaDTO(Long id ,
			Long idTurma ,
			String codigo ,
			Long idModalidade ,
			String nomeModalidade,
			Date dataInicio,
			Date dataFim,
			Date dataMatricula
    		) {
    	this.setId(id) ;
		this.setIdTurma(idTurma) ;
		this.setCodigo(codigo) ;
		this.setIdModalidade(idModalidade) ;
		this.setNomeModalidade(nomeModalidade) ;
		this.setDataFim(dataFim);
		this.setDataInicio(dataInicio);
		this.setDataMatricula(dataMatricula);
	}
    
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
			Long diaVencimento,
			Long idDesconto,
		    String nomeDesconto,
		    Long valorDesconto){

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
		this.setIdDesconto(idDesconto);
		this.setNomeDesconto(nomeDesconto);
		this.setValorDesconto(valorDesconto);
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

	public Long getIdDesconto() {
		return idDesconto;
	}

	public void setIdDesconto(Long idDesconto) {
		this.idDesconto = idDesconto;
	}

	public String getNomeDesconto() {
		return nomeDesconto;
	}

	public void setNomeDesconto(String nomeDesconto) {
		this.nomeDesconto = nomeDesconto;
	}

	public Long getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(Long valorDesconto) {
		this.valorDesconto = valorDesconto;
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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	
	
	
}
