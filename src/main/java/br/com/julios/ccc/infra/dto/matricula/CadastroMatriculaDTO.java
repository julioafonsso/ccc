package br.com.julios.ccc.infra.dto.matricula;

import java.util.Date;

public class CadastroMatriculaDTO {

	private Long id ;
	private Long idTurma ;
	private Long idAluno;
	private Long diaVencimento ;
	private Long idDesconto;
	private Double valor;
	private Date dataMatricula;
	
	public Date getDataMatricula() {
		return dataMatricula;
	}
	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
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
	public Long getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(Long idAluno) {
		this.idAluno = idAluno;
	}
	public Long getDiaVencimento() {
		return diaVencimento;
	}
	public void setDiaVencimento(Long diaVencimento) {
		this.diaVencimento = diaVencimento;
	}
	public Long getIdDesconto() {
		return idDesconto;
	}
	public void setIdDesconto(Long idDesconto) {
		this.idDesconto = idDesconto;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = new Double(valor.replaceAll(",", ""));
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
