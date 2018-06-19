package br.com.julios.ccc.infra.dto.matricula;

import java.util.Date;

public class ConsultaAlunosMatriculadosTurmaExcluidaDTO {

	private String nome;
	private String cpf;
	private String email;
	private String nomeDesconto;
	private Long valorDesconto;
	private Date dataMatricula;
	private Date dataNascimento;
	private Date dataSaida;
	private Double valorMatricula;
	private Double valorTotalMensalidade;
	
	public ConsultaAlunosMatriculadosTurmaExcluidaDTO(
			String nome,
			String cpf,
			String email,
			String nomeDesconto,
			Long valorDesconto,
			Date dataMatricula,
			Date dataSaida,
			Date dataNascimento,
			Double valorMatricula,
			Double valorTotalMensalidade) {
		this.setCpf(cpf);
		this.setEmail(email);
		this.setNome(nome);
		this.setNomeDesconto(nomeDesconto);
		this.setValorDesconto(valorDesconto);
		this.setDataMatricula(dataMatricula);
		this.setDataSaida(dataSaida);
		this.setDataNascimento(dataNascimento);
		this.setValorMatricula(valorMatricula);
		this.setValorTotalMensalidade(valorTotalMensalidade);
	}



	public Date getDataSaida() {
		return dataSaida;
	}



	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}



	public Double getValorMatricula() {
		return valorMatricula;
	}



	public void setValorMatricula(Double valorMatricula) {
		this.valorMatricula = valorMatricula;
	}



	public Double getValorTotalMensalidade() {
		return valorTotalMensalidade;
	}



	public void setValorTotalMensalidade(Double valorTotalMensalidade) {
		this.valorTotalMensalidade = valorTotalMensalidade;
	}



	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
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
