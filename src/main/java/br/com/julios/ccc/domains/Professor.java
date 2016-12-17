package br.com.julios.ccc.domains;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "PROFESSOR") 
public class Professor {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column(nullable = false)
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
	
	@ManyToOne
	private List<Turma> turmas;
}
