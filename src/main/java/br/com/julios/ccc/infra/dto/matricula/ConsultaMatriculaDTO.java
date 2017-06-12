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
	public Date dataFim;
	public Date dataMatricula;
	private String nomeProfessor1;
	public String getNomeProfessor1() {
		return nomeProfessor1;
	}

	public void setNomeProfessor1(String nomeProfessor1) {
		this.nomeProfessor1 = nomeProfessor1;
	}

	public Double getValorMensalidade() {
		return valorMensalidade;
	}

	public void setValorMensalidade(Double valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}

	private String nomeProfessor2;
	private Integer qtdVagas;
	private Double valorMensalidade;
	private Integer qtdAlunos;
	private Integer qtdAlunas;
	private Date dataInicio;
    
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
		    Long valorDesconto,
		    Date dataMatricula,
		    Date dataInicio,
		    Date dataFim,
		    Integer qtdAlunos,
		    Integer qtdAlunas,
		    String nomeProfessor1,
		    String nomeProfessor2,
		    Integer qtdVagas,
		    Double valorMensalidade){

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
		this.setDataMatricula(dataMatricula);
		this.setDataInicio(dataInicio);
		this.setDataFim(dataFim);
		this.setQtdAlunas(qtdAlunas);
		this.setQtdAlunos(qtdAlunos);
		this.setNomeProfessor1(nomeProfessor1);
		this.setNomeProfessor2(nomeProfessor2);
		this.setQtdVagas(qtdVagas);
		this.setValorMensalidade(valorMensalidade);
	}

	public String getNomeProfessor2() {
		return nomeProfessor2;
	}

	public void setNomeProfessor2(String nomeProfessor2) {
		this.nomeProfessor2 = nomeProfessor2;
	}

	public Integer getQtdVagas() {
		return qtdVagas;
	}

	public void setQtdVagas(Integer qtdVagas) {
		this.qtdVagas = qtdVagas;
	}

	public Integer getQtdAlunos() {
		return qtdAlunos;
	}

	public void setQtdAlunos(Integer qtdAlunos) {
		this.qtdAlunos = qtdAlunos;
	}

	public Integer getQtdAlunas() {
		return qtdAlunas;
	}

	public void setQtdAlunas(Integer qtdAlunas) {
		this.qtdAlunas = qtdAlunas;
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
