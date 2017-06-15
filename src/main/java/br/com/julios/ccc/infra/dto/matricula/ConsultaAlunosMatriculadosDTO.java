package br.com.julios.ccc.infra.dto.matricula;

import java.util.Date;

public class ConsultaAlunosMatriculadosDTO {

	private String nome;
	private String cpf;
	private String email;
	private String nomeDesconto;
	private Long valorDesconto;
	private Date dataMatricula;
	private Date dataNascimento;
	
	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public ConsultaAlunosMatriculadosDTO(
			String nome,
			String cpf,
			String email,
			String nomeDesconto,
			Long valorDesconto,
			Date dataMatricula,
			Date dataNascimento) {
		this.setCpf(cpf);
		this.setEmail(email);
		this.setNome(nome);
		this.setNomeDesconto(nomeDesconto);
		this.setValorDesconto(valorDesconto);
		this.setDataMatricula(dataMatricula);
		this.setDataNascimento(dataNascimento);
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomeDesconto() {
		return nomeDesconto;
	}
	public void setNomeDesconto(String nomeDesconto) {
		this.nomeDesconto = nomeDesconto;
	}
	public Long getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto(Long valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	
	
	
	
}
