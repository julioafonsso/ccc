package br.com.julios.ccc.domains;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sala")
public class Salas {
	
	@Id
	private int id;
	
	@Column(name = "sala_aula")
	private String salaAula;
	
	@OneToMany (mappedBy = "salaAula")
	private List<Turma> turma;

	public int getId() {
		return id;
	}

	public String getSalaAula() {
		return salaAula;
	}


	public void setSalaAula(String salaAula) {
		this.salaAula = salaAula;
	}

	
	public List<Turma> getTurma() {
		return turma;
	}

	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}

}
