package br.com.julios.ccc.domains;

import javax.persistence.*;

@Entity
@Table(name = "PROFESSOR") 
public class Professor {

	
	@Id
	private int cpf;
	
	@Column
	private String nome;
	
	@Column
	private int rg;
	
	@Column
	private String email;
	
	@Column
	private String endereco;
	
	@Column
	private int telefone;
}
