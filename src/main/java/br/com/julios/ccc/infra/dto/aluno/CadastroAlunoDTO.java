package br.com.julios.ccc.infra.dto.aluno;

import java.text.ParseException;
import java.util.Date;

import br.com.julios.ccc.util.Util;

public class CadastroAlunoDTO {

	private Long id;
	private String cpf;
	private String nome;
	private String rg;
	private String email;
	private String endereco;
	private Long numero;
	private String complemento;
	private String nomeBairro;
//	private String cidade;
	private Date dataNascimento;
	private Long idEstadoCivil;
	private String profissao;
	private Long idConheceEscola;
	private String sexo;
	private String telefone;
	private String observacao;
	private String foto;

	public boolean isReceberEmail() {
		return receberEmail;
	}

	public void setReceberEmail(boolean receberEmail) {
		this.receberEmail = receberEmail;
	}

	private boolean receberEmail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
		if (nome != null)
			this.nome = nome.toUpperCase();
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
		if (endereco == null)
			return "";
		return endereco;
	}

	public void setEndereco(String endereco) {
		if (endereco != null)
			this.endereco = endereco.toUpperCase();
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		if (complemento == null)
			return "";
		return complemento;
	}

	public void setComplemento(String complemento) {
		if (complemento != null)
			this.complemento = complemento.toUpperCase();
	}

	public String getNomeBairro() {
		return nomeBairro;
	}

	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) throws ParseException {
		this.dataNascimento = Util.parseDate(dataNascimento);
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Long getIdEstadoCivil() {
		return idEstadoCivil;
	}

	public void setIdEstadoCivil(Long idEstadoCivil) {
		this.idEstadoCivil = idEstadoCivil;
	}

	public String getProfissao() {
		if (profissao == null)
			return "";
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao.toUpperCase();
	}

	public Long getIdConheceEscola() {
		return idConheceEscola;
	}

	public void setIdConheceEscola(Long idConheceEscola) {
		this.idConheceEscola = idConheceEscola;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getObservacao() {
		if (observacao == null)
			return "";
		return observacao;
	}

	public void setObservacao(String observacao) {
		if (observacao != null)
			this.observacao = observacao.toUpperCase();
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

}
