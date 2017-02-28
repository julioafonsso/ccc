package br.com.julios.ccc.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "v_salario_professor")
public class Salario {
	
	@Id
	@Column (name= "id_mensalidade")
	private long id;
	
	@Column(name="id_professor")
	private long idProfessor;
	
	@Column (name= "valor_calculado")
	private Double valorCalculado;
	
	@Column(name="valor_pago_aluno")
	private Double valorPagoAluno;
	
	@Column(name="nome_aluno")
	private String nomeAluno;
	
	@Column(name="codigo_turma")
	private long codigo;
	
	@Column(name="valor_mensalidade")
	private Double valorMensalidade;
	
	@Column
	private Double percentual;
	
	@Column
	private Long mes;
	
	@Column
	private Long ano;

	//Getters and Setters
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(long idProfessor) {
		this.idProfessor = idProfessor;
	}

	public Double getValorCalculado() {
		return valorCalculado;
	}

	public void setValorCalculado(Double valorCalculado) {
		this.valorCalculado = valorCalculado;
	}

	public Double getValorPagoAluno() {
		return valorPagoAluno;
	}

	public void setValorPagoAluno(Double valorPagoAluno) {
		this.valorPagoAluno = valorPagoAluno;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Double getPercentual() {
		return percentual;
	}

	public void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	public Long getMes() {
		return mes;
	}

	public void setMes(Long mes) {
		this.mes = mes;
	}

	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	public Double getValorMensalidade() {
		return valorMensalidade;
	}

	public void setValorMensalidade(Double valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	} 
	
	
	
	
}
