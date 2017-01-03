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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "TURMA_PROFESSOR")
public class TurmaProfessor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn (name = "turma_id")
	@JsonIgnoreProperties("professores")
	private Turma turma;
	
	
	@ManyToOne
	@JoinColumn (name = "professor_id")
	@JsonIgnoreProperties("turmas")
	private Professor professor;
	
	@Column
	private double percentual;
	
	@Column(name = "data_exclusao")
	@Temporal(TemporalType.DATE)
	private Date dataExclusao;
	
	//Getters and Setters

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public double getPercentual() {
		return percentual;
	}

	public void setPercentual(double percentual) {
		this.percentual = percentual;
	}

	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	
}
