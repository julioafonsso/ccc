package br.com.julios.ccc.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "conhece_escola")
public class ConheceEscola {
	
	
	@Id
	private int id;
	
	@Column
	private String nome;

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


}
