package br.com.julios.ccc.infra.dto.matricula;

import java.util.Date;

import br.com.julios.ccc.util.Util;

public class CadastroMatriculaDTO {

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
		this.valor = Util.convertToDouble(valor);
	}
	
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
