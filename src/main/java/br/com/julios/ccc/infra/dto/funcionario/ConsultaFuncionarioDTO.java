package br.com.julios.ccc.infra.dto.funcionario;

import java.util.Date;

public class ConsultaFuncionarioDTO {

	public ConsultaFuncionarioDTO() {
	}

	public ConsultaFuncionarioDTO(Long id,String nome, String cpf, String telefone, String email, String rg, String foto,
			String observacao, Date dataNascimento, Date dataAdmissao, Long idTipoFuncionario,
			String nomeTipoFuncionario) {
		setId(id);
		setNome(nome);
		setCpf(cpf);
		setTelefone(telefone);
		setEmail(email);
		setRg(rg);
		setFoto(foto);
		setObservacao(observacao);
		setDataNascimento(dataNascimento);
		setDataAdmissao(dataAdmissao);
		setIdTipoFuncionario(idTipoFuncionario);
		setNomeTipoFuncionario(nomeTipoFuncionario);

	}

	private Long id;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String rg;
	private String foto;
	private String observacao;
	private Date dataNascimento;
	private Date dataAdmissao;
	private Long idTipoFuncionario;
	private String nomeTipoFuncionario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getdataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Long getIdTipoFuncionario() {
		return idTipoFuncionario;
	}

	public void setIdTipoFuncionario(Long idTipoFuncionario) {
		this.idTipoFuncionario = idTipoFuncionario;
	}

	public String getNomeTipoFuncionario() {
		return nomeTipoFuncionario;
	}

	public void setNomeTipoFuncionario(String nomeTipoFuncionario) {
		this.nomeTipoFuncionario = nomeTipoFuncionario;
	}

}
