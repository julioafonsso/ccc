package br.com.julios.ccc.domains;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="v_mensalidades")	
public class Mensalidades {

	public static final String ATRASADO = "Atrasado";
	public static final String PENDENTE = "Pendente";
	public static final String PAGO = "Pago";
	
	@Id
	private Long id;
	
	@Column
	private Long aluno;
	
	@Column
	private Long matricula;
	
	@Column
	private Long turma;
	
	@Column(name="dia_vencimento")
	private Long diaVencimento;
	
	
	@Column(name="id_mes_referencia")
	private Long idMesReferencia;
	
	@Column
	private Long mes;
	
	@Column
	private Long ano;
	
	@Column
	private String situacao;
	
	@Column(name = "modalidade_turma")
	private String modalidadeTurma;
	
	@Column(name = "nivel_turma")
	private String nivelTurma;
	
	@Column(name = "valor_calculado")
	private Double valorCalculado;

	
	@Transient
	private Double valorParaPagar;

	@Column(name = "valor_mensalidade")
	private Double valorMensalidade;

	public Long getId() {
		return id;
	}

	public Long getAluno() {
		return aluno;
	}

	public void setAluno(Long aluno) {
		this.aluno = aluno;
	}

	public Long getTurma() {
		return turma;
	}

	public void setTurma(Long turma) {
		this.turma = turma;
	}

	public Long getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(Long diaVencimento) {
		this.diaVencimento = diaVencimento;
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

	public String getSituacao() {
		return situacao;
	}

	public Double getValorCalculado() {
		return valorCalculado;
	}

	public void setValorCalculado(Double valorCalculado) {
		this.valorCalculado = valorCalculado;
	}

	public Double getValorParaPagar() {
		return valorParaPagar;
	}

	public void setValorParaPagar(Double valorParaPagar) {
		this.valorParaPagar = valorParaPagar;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Long getMatricula() {
		return matricula;
	}

	public void setMatricula(Long matricula) {
		this.matricula = matricula;
	}

	public String getModalidadeTurma() {
		return modalidadeTurma;
	}

	public void setModalidadeTurma(String modalidadeTurma) {
		this.modalidadeTurma = modalidadeTurma;
	}

	public String getNivelTurma() {
		return nivelTurma;
	}

	public void setNivelTurma(String nivelTurma) {
		this.nivelTurma = nivelTurma;
	}

	public Double getValorMensalidade() {
		return valorMensalidade;
	}

	public void setValorMensalidade(Double valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}

	public Long getIdMesReferencia() {
		return idMesReferencia;
	}

	public void setIdMesReferencia(Long idMesReferencia) {
		this.idMesReferencia = idMesReferencia;
	}
	

}
