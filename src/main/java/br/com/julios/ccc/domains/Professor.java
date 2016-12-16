package br.com.julios.ccc.domains;

import javax.persistence.*;

@Entity
@Table(name = "PROFESSOR") 
public class Professor {

	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(length = 11, nullable = false)
	private int cpf;
	
	@Column(nullable = false)
	private String nome;
	
	@Column
	private int rg;
	
	@Column
	private String email;
	
	@Column
	private String endereco;
	
	@Column
	private int telefone;
	
	@Column
	private String observacao;
}
