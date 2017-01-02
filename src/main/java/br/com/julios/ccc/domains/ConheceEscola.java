package br.com.julios.ccc.domains;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "conhece_escola")
public class ConheceEscola {
	
	
	@Id
	private int id;
	
	@Column
	private String nome;

	@OneToMany(mappedBy = "conheceEscola")
	@JsonIgnoreProperties("conheceEscola")
	private List<Aluno> aluno;
	
	
	//Getters and Setters
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Aluno> getAluno() {
		return aluno;
	}

	public void setAluno(List<Aluno> aluno) {
		this.aluno = aluno;
	}

}
