package br.com.julios.ccc.infra.dto.turma.coletiva;

import java.util.Date;

public class ConsultaTurmaColetivaExcluidasDTO {

	private Long id;
	private String codigo;
	private Long idProfessor1;
	private String nomeProfessor1;
	private Double percentualProfessor1;
	private Long idModalidade;
	private String nomeModalidade;
	private Long idProfessor2;
	private String nomeProfessor2;
	private Double percentualProfessor2;
	private Integer qtdVagas;
	private Double valorMensalidade;
	private Long idNivel;
	private String nomeNivel;
	private Integer qtdAlunos;
	private Integer qtdAlunas;
	private Date dataInicio;
	private Date dataTermino;
	private Double valorTotalMatriculas;
	private Double valorTotalMensalidades;

	public ConsultaTurmaColetivaExcluidasDTO(Long id, 
			String codigo, 
			Long idProfessor1, 
			String nomeProfessor1,
			Double percentualProfessor1, 
			Long idModalidade, 
			String nomeModalidade, 
			Long idProfessor2,
			String nomeProfessor2, 
			Double percentualProfessor2, 
			Integer qtdVagas, 
			Double valorMensalidade, 
			Long idNivel,
			String nomeNivel, 
			Integer qtdAlunos, 
			Integer qtdAlunas, 
			Date dataInicio, 
			Date dataTermino,
			Double valorTotalMatriculas, 
			Double valorTotalMensalidades) {
		
		this.setId(id) ;
		this.setCodigo(codigo) ;
		this.setIdProfessor1(idProfessor1) ;
		this.setNomeProfessor1(nomeProfessor1) ;
		this.setPercentualProfessor1(percentualProfessor1) ;
		this.setIdModalidade(idModalidade) ;
		this.setNomeModalidade(nomeModalidade) ;
		this.setIdProfessor2(idProfessor2) ;
		this.setNomeProfessor2(nomeProfessor2) ;
		this.setPercentualProfessor2(percentualProfessor2) ;
		this.setQtdVagas(qtdVagas) ;
		this.setValorMensalidade(valorMensalidade) ;
		this.setIdNivel(idNivel) ;
		this.setNomeNivel(nomeNivel) ;
		this.setQtdAlunos(qtdAlunos) ;
		this.setQtdAlunas(qtdAlunas) ;
		this.setDataInicio(dataInicio) ;
		this.setDataTermino(dataTermino) ;
		this.setValorTotalMatriculas(valorTotalMatriculas) ;
		this.setValorTotalMensalidades(valorTotalMensalidades) ;	

	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setIdProfessor1(Long idProfessor1) {
		this.idProfessor1 = idProfessor1;
	}

	public void setNomeProfessor1(String nomeProfessor1) {
		this.nomeProfessor1 = nomeProfessor1;
	}

	public void setPercentualProfessor1(Double percentualProfessor1) {
		this.percentualProfessor1 = percentualProfessor1;
	}

	public void setIdModalidade(Long idModalidade) {
		this.idModalidade = idModalidade;
	}

	public void setNomeModalidade(String nomeModalidade) {
		this.nomeModalidade = nomeModalidade;
	}

	public void setIdProfessor2(Long idProfessor2) {
		this.idProfessor2 = idProfessor2;
	}

	public void setNomeProfessor2(String nomeProfessor2) {
		this.nomeProfessor2 = nomeProfessor2;
	}

	public void setPercentualProfessor2(Double percentualProfessor2) {
		this.percentualProfessor2 = percentualProfessor2;
	}

	public void setQtdVagas(Integer qtdVagas) {
		this.qtdVagas = qtdVagas;
	}

	public void setValorMensalidade(Double valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}

	public void setIdNivel(Long idNivel) {
		this.idNivel = idNivel;
	}

	public void setNomeNivel(String nomeNivel) {
		this.nomeNivel = nomeNivel;
	}

	public void setQtdAlunos(Integer qtdAlunos) {
		this.qtdAlunos = qtdAlunos;
	}

	public void setQtdAlunas(Integer qtdAlunas) {
		this.qtdAlunas = qtdAlunas;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public void setValorTotalMatriculas(Double valorTotalMatriculas) {
		this.valorTotalMatriculas = valorTotalMatriculas;
	}

	public void setValorTotalMensalidades(Double valorTotalMensalidades) {
		this.valorTotalMensalidades = valorTotalMensalidades;
	}

	public Long getId() {
		return id;
	}

	public String getCodigo() {
		return codigo;
	}

	public Long getIdProfessor1() {
		return idProfessor1;
	}

	public String getNomeProfessor1() {
		return nomeProfessor1;
	}

	public Double getPercentualProfessor1() {
		return percentualProfessor1;
	}

	public Long getIdModalidade() {
		return idModalidade;
	}

	public String getNomeModalidade() {
		return nomeModalidade;
	}

	public Long getIdProfessor2() {
		return idProfessor2;
	}

	public String getNomeProfessor2() {
		return nomeProfessor2;
	}

	public Double getPercentualProfessor2() {
		return percentualProfessor2;
	}

	public Integer getQtdVagas() {
		return qtdVagas;
	}

	public Double getValorMensalidade() {
		return valorMensalidade;
	}

	public Long getIdNivel() {
		return idNivel;
	}

	public String getNomeNivel() {
		return nomeNivel;
	}

	public Integer getQtdAlunos() {
		return qtdAlunos;
	}

	public Integer getQtdAlunas() {
		return qtdAlunas;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public Double getValorTotalMatriculas() {
		return valorTotalMatriculas;
	}

	public Double getValorTotalMensalidades() {
		return valorTotalMensalidades;
	}

	
	
}
