package br.com.julios.ccc.infra.dto.aluno;

import java.util.Date;

public class ConsultaAlunoDTO {

	private Long id;
	private String cpf;
	private String nome;
	private String rg;
	private String email;
	private String endereco;
	private Long numero;
	private String complemento;
	private Long idBairro;
	private String nomeBairro;
	private String cidade;
	private Date dataNascimento;
	private Long idEstadoCivil;
	private String nomeEstadoCivil;
	private String profissao;
	private Long idConheceEscola;
	private String nomeConheceEscola;
	
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

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Long getIdBairro() {
		return idBairro;
	}

	public void setIdBairro(Long idBairro) {
		this.idBairro = idBairro;
	}

	public String getNomeBairro() {
		return nomeBairro;
	}

	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Date getDataNascimento() {
		return dataNascimento;
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

	public String getNomeEstadoCivil() {
		return nomeEstadoCivil;
	}

	public void setNomeEstadoCivil(String nomeEstadoCivil) {
		this.nomeEstadoCivil = nomeEstadoCivil;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public Long getIdConheceEscola() {
		return idConheceEscola;
	}

	public void setIdConheceEscola(Long idConheceEscola) {
		this.idConheceEscola = idConheceEscola;
	}

	public String getNomeConheceEscola() {
		return nomeConheceEscola;
	}

	public void setNomeConheceEscola(String nomeConheceEscola) {
		this.nomeConheceEscola = nomeConheceEscola;
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
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	private String sexo;
	private String telefone;
	private String observacao;
	private String foto;

	public ConsultaAlunoDTO(	Long id,
			String cpf,
			String nome,
			String rg,
			String email,
			String endereco,
			Long numero,
			String complemento,
			Long idBairro,
			String nomeBairro,
			String cidade,
			Date dataNascimento,
			Long idEstadoCivil,
			String nomeEstadoCivil,
			String profissao,
			Long idConheceEscola,
			String nomeConheceEscola,
			String sexo,
			String telefone,
			String observacao,
			String foto
			) {
		
		this.setId(id);
		this.setCpf(cpf);
		this.setNome(nome);
		this.setRg(rg);
		this.setEmail(email);
		this.setEndereco(endereco);
		this.setNumero(numero);
		this.setComplemento(complemento);
		this.setIdBairro(idBairro);
		this.setNomeBairro(nomeBairro);
		this.setCidade(cidade);
		this.setDataNascimento(dataNascimento);
		this.setIdEstadoCivil(idEstadoCivil);
		this.setNomeEstadoCivil(nomeEstadoCivil);
		this.setProfissao(profissao);
		this.setIdConheceEscola(idConheceEscola);
		this.setNomeConheceEscola(nomeConheceEscola);
		this.setSexo(sexo);
		this.setTelefone(telefone);
		this.setObservacao(observacao);
		this.setFoto(foto);
		
		
	}
		
	
}