package br.com.julios.ccc.domains;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "modalidade_turma")
public class ModalidadeTurma {

	
	@Id
	private int id;
	
	@Column
	private String modalidade;
	
	@OneToMany(mappedBy = "modalidade")
	private List<Turma> turma;

	public int getId() {
		return id;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public List<Turma> getTurma() {
		return turma;
	}

	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}
}
