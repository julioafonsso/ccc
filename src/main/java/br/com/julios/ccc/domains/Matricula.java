package br.com.julios.ccc.domains;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "matricula")

public class Matricula {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private long id;

	@ManyToOne
	@JoinColumn(name = "turma_id")
	@JsonIgnoreProperties("matriculas")
	private Turma turma;

	@ManyToOne
	@JoinColumn(name = "aluno_id")
	@JsonIgnoreProperties("turmas")
	private Aluno aluno;

	@Column(name = "dia_vencimento")
	private int diaVencimento;

	@Column(name = "data_matricula")
	private Date dataMatricula;
	
	@Column(name = "data_exclusao")
	private Date dataExclusao;
	
	
	
	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	
	
	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public int getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(int diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	public long getId() {
		return id;
	}

}
