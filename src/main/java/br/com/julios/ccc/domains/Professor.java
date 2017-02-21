package br.com.julios.ccc.domains;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "PROFESSOR") 
public class Professor {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String cpf;
	
	@Column(nullable = false)
	private String nome;
	
	@Column
	private String rg;
	
	@Column
	private String email;
	
	@Column
	private String endereco;
	
	@Column
	private String telefone;
	
	@Column(name = "data_admissao")
	@Temporal(TemporalType.DATE)
	private Calendar dataAdmissao;
	
	@Column
	private String observacao;
	
	@OneToMany(mappedBy = "professor")
	@JsonIgnore
	private List<TurmaProfessor> turmas;

	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimento;
	
	//Getters and Setters

	public long getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	
	
	
}
