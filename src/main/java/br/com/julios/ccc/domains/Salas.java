package br.com.julios.ccc.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sala")
public class Salas {
	
	@Id
	private int id;
	
	@Column(name = "sala_aula")
	private String salaaula;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSalaaula() {
		return salaaula;
	}

	public void setSalaaula(String salaaula) {
		this.salaaula = salaaula;
	}

}
