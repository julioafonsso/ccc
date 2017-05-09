package br.com.julios.ccc.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_turma")
public class TipoTurma {

	public static final long TURMA = 1;
	public static final long AULA_PARTICULAR = 2;
	public static final long WORKSHOP = 3;
	
	@Id
	private long id;
	
	@Column
	private String nome;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}
