package br.com.julios.ccc.domains;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "modalidade_turma")
public class ModalidadeTurma {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
	private String nome;
	
	@OneToMany(mappedBy = "modalidade")
	@JsonIgnoreProperties("modalidade")
	private List<Turma> turma;

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public List<Turma> getTurma() {
		return turma;
	}

	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}
}
