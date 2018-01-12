package br.com.julios.ccc.infra.dto.matricula;

import java.util.Date;

import br.com.julios.ccc.infra.Contexto;
import br.com.julios.ccc.infra.bd.daos.MensalidadeDAO;
import br.com.julios.ccc.infra.bd.model.MensalidadeDO;
import br.com.julios.ccc.repositorios.MatriculaRepositorio;

public class ConsultaAlunosMatriculadosDTO {

	private String nome;
	private String cpf;
	private String email;
	private String nomeDesconto;
	private Long valorDesconto;
	private Date dataMatricula;
	private Date dataNascimento;
	private boolean estaAtrasado;
	private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private Date dataUltimoPagamento;
	private Double valorUltimoPagamento;
	
	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public ConsultaAlunosMatriculadosDTO(
			Long id,
			String nome,
			String cpf,
			String email,
			String nomeDesconto,
			Long valorDesconto,
			Date dataMatricula,
			Date dataNascimento,
			Date mensalidadeAntga) {
		this.setCpf(cpf);
		this.setEmail(email);
		this.setNome(nome);
		this.setNomeDesconto(nomeDesconto);
		this.setValorDesconto(valorDesconto);
		this.setDataMatricula(dataMatricula);
		this.setDataNascimento(dataNascimento);
		this.setEstaAtrasado( mensalidadeAntga != null && new Date().after(mensalidadeAntga));
		this.loadUltimaMensalidade(id);
		this.setId(id);
		
	}
	
	private void loadUltimaMensalidade(Long id) {
		MensalidadeDAO men = Contexto.bean(MensalidadeDAO.class);
		MensalidadeDO mensalidade = men.getUtilmamensalidadePaga(id);
		if(mensalidade != null)
		{
			this.setDataUltimoPagamento(mensalidade.getDataPagamento());
			this.setValorUltimoPagamento(mensalidade.getValorPago());
		}
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

	public boolean isEstaAtrasado() {
		return estaAtrasado;
	}

	public void setEstaAtrasado(boolean estaAtrasado) {
		this.estaAtrasado = estaAtrasado;
	}

	public Date getDataUltimoPagamento() {
		return dataUltimoPagamento;
	}

	public void setDataUltimoPagamento(Date dataUltimoPagamento) {
		this.dataUltimoPagamento = dataUltimoPagamento;
	}

	public Double getValorUltimoPagamento() {
		return valorUltimoPagamento;
	}

	public void setValorUltimoPagamento(Double valorUltimoPagamento) {
		this.valorUltimoPagamento = valorUltimoPagamento;
	}
	
	
	
	
}
