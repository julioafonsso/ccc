package br.com.julios.ccc.infra.bd.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "sala")
public class SalaDO {
	
	@Id
	private Long id;
	
	@Column
	private String nome;
	
	@OneToMany (mappedBy = "sala")
	@Where(clause = "data_termino is null or data_termino > CURRENT_DATE")
	private List<TurmaColetivaDO> turmas;

	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<TurmaColetivaDO> getTurmas(){
		return this.turmas;
	}
	
}
