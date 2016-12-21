package br.com.julios.ccc.domains;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "PROFESSOR") 
public class Professor {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer id;
	
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
	
	@OneToMany(mappedBy = "professor")
	private List<TurmaProfessor> turmas;
	
	//Getters and Setters

	public Integer getId() {
		return id;
	}


	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getRg() {
		return rg;
	}

	public void setRg(int rg) {
		this.rg = rg;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public List<TurmaProfessor> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<TurmaProfessor> turmas) {
		this.turmas = turmas;
	}

	
	
	
}
