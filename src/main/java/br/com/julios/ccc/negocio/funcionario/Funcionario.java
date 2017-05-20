package br.com.julios.ccc.negocio.funcionario;

import java.util.Date;

public class Funcionario {

	private FuncionarioRepositorio repositorio;
	
	public Funcionario(FuncionarioRepositorio funcionarioRepositorio) {
		this.repositorio = funcionarioRepositorio;
	}

	public void cadastrar() throws Exception{
		this.validaCpfExistente();
		this.validaEmailExistente();
		this.validaRGExistente();
		this.repositorio.cadastrar(this);
	}
	
	private void validaCpfExistente() throws Exception{
		if(repositorio.qtdFuncionarioComCPF(this.getCpf()).longValue() > 0)
			throw new Exception("CPF já cadastrado");
	}
	
	private void validaRGExistente() throws Exception{
		if(repositorio.qtdFuncionarioComRG(this.getRg()).longValue() > 0)
			throw new Exception("RG já cadastrado");
	}
	
	private void validaEmailExistente() throws Exception{
		if(repositorio.qtdFuncionarioComEmail(this.getEmail()).longValue() > 0)
			throw new Exception("Email já cadastrado");
	}
	
	private Long id;
	private String cpf;
	private String telefone;
	private String email;
	private String rg;
	private Date dataNascimento;
	private Date dataAdmissao;
	private String foto;
	private String observacao;
	private Long tipo;
	private String nome;
	
	protected String getNome() {
		return nome;
	}
	protected void setNome(String nome) {
		this.nome = nome;
	}
	
	protected Long getId() {
		return id;
	}
	protected void setId(Long id) {
		this.id = id;
	}
	protected String getCpf() {
		return cpf;
	}
	protected void setCpf(String cpf) {
		this.cpf = cpf;
	}
	protected String getTelefone() {
		return telefone;
	}
	protected void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	protected String getEmail() {
		return email;
	}
	protected void setEmail(String email) {
		this.email = email;
	}
	protected String getRg() {
		return rg;
	}
	protected void setRg(String rg) {
		this.rg = rg;
	}
	protected Date getDataNascimento() {
		return dataNascimento;
	}
	protected void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	protected Date getDataAdmissao() {
		return dataAdmissao;
	}
	protected void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	protected String getFoto() {
		return foto;
	}
	protected void setFoto(String foto) {
		this.foto = foto;
	}
	protected String getObservacao() {
		return observacao;
	}
	protected void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	protected void setTipo(Long tipo) {
		this.tipo = tipo;
	}
	
	protected Long getTipo()
	{
		return tipo;
	}
	
	
	
}
