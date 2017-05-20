package br.com.julios.ccc.negocio.aluno;

import java.util.Date;

import br.com.julios.ccc.infra.dto.aluno.CadastroAlunoDTO;

public class Aluno {

	private  AlunoRepositorio repositorio;
	
	private Long id;
	private String cpf;
	private String nome;
	private String rg;
	private String email;
	private String endereco;
	private Long numero;
	private String complemento;
	private Long idBairro;
	private String cidade;
	private Date dataNascimento;
	private Long idEstadoCivil;
	private String profissao;
	private Long idConheceEscola;
	private String sexo;
	private String telefone;
	private String observacao;
	private String foto;
	
	
	public Aluno(CadastroAlunoDTO cadastro, AlunoRepositorio alunoRepositorio) {
		this.repositorio = alunoRepositorio;
		this.setId(cadastro.getId());
		this.setCpf(cadastro.getCpf());
		this.setNome(cadastro.getNome());
		this.setRg(cadastro.getRg());
		this.setEmail(cadastro.getEmail());
		this.setEndereco(cadastro.getEndereco());
		this.setNumero(cadastro.getNumero());
		this.setComplemento(cadastro.getComplemento());
		this.setIdBairro(cadastro.getIdBairro());
		this.setCidade(cadastro.getCidade());
		this.setDataNascimento(cadastro.getDataNascimento());
		this.setIdEstadoCivil(cadastro.getIdEstadoCivil());
		this.setProfissao(cadastro.getProfissao());
		this.setIdConheceEscola(cadastro.getIdConheceEscola());
		this.setSexo(cadastro.getSexo());
		this.setTelefone(cadastro.getTelefone());
		this.setObservacao(cadastro.getObservacao());
		this.setFoto(cadastro.getFoto());
		
	}
	protected void setId(Long id) {
		this.id = id;
	}
	protected void setCpf(String cpf) {
		this.cpf = cpf;
	}
	protected void setNome(String nome) {
		this.nome = nome;
	}
	protected void setRg(String rg) {
		this.rg = rg;
	}
	protected void setEmail(String email) {
		this.email = email;
	}
	protected void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	protected void setNumero(Long numero) {
		this.numero = numero;
	}
	protected void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	protected void setIdBairro(Long idBairro) {
		this.idBairro = idBairro;
	}
	protected void setCidade(String cidade) {
		this.cidade = cidade;
	}
	protected void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	protected void setIdEstadoCivil(Long idEstadoCivil) {
		this.idEstadoCivil = idEstadoCivil;
	}
	protected void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	protected void setIdConheceEscola(Long idConheceEscola) {
		this.idConheceEscola = idConheceEscola;
	}
	protected void setSexo(String sexo) {
		this.sexo = sexo;
	}
	protected void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	protected void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	protected void setFoto(String foto) {
		this.foto = foto;
	}
	public Long getId() {
		return id;
	}
	public String getCpf() {
		return cpf;
	}
	public String getNome() {
		return nome;
	}
	public String getRg() {
		return rg;
	}
	public String getEmail() {
		return email;
	}
	public String getEndereco() {
		return endereco;
	}
	public Long getNumero() {
		return numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public Long getIdBairro() {
		return idBairro;
	}
	public String getCidade() {
		return cidade;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public Long getIdEstadoCivil() {
		return idEstadoCivil;
	}
	public String getProfissao() {
		return profissao;
	}
	public Long getIdConheceEscola() {
		return idConheceEscola;
	}
	public String getSexo() {
		return sexo;
	}
	public String getTelefone() {
		return telefone;
	}
	public String getObservacao() {
		return observacao;
	}
	public String getFoto() {
		return foto;
	}
	
	

	public void cadastrar() throws Exception{
		this.validaCpfExistente();
		this.validaEmailExistente();
		this.validaRGExistente();
		this.repositorio.cadastrar(this);
	}
	
	private void validaCpfExistente() throws Exception{
		if(repositorio.qtdAlunoComCPF(this.getCpf()).longValue() > 0)
			throw new Exception("CPF já cadastrado");
	}
	
	private void validaRGExistente() throws Exception{
		if(repositorio.qtdAlunoComRG(this.getRg()).longValue() > 0)
			throw new Exception("RG já cadastrado");
	}
	
	private void validaEmailExistente() throws Exception{
		if(repositorio.qtdAlunoComEmail(this.getEmail()).longValue() > 0)
			throw new Exception("Email já cadastrado");
	}
	
	
}
