package br.com.julios.ccc.negocio.funcionario;

import java.util.Date;

import br.com.julios.ccc.infra.bd.model.TipoFuncionarioDO;
import br.com.julios.ccc.infra.dto.funcionario.CadastroFuncionarioDTO;
import br.com.julios.ccc.negocio.mensalidade.Mensalidade;
import br.com.julios.ccc.negocio.mes.MesReferencia;

public class Funcionario {

	private FuncionarioRepositorio repositorio;

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

	private FuncionarioRepositorio getRepositorio() {
		return repositorio;
	}

	private void setRepositorio(FuncionarioRepositorio repositorio) {
		this.repositorio = repositorio;
	}
	
	public Funcionario(FuncionarioRepositorio funcionarioRepositorio, CadastroFuncionarioDTO funcionarioDTO) {
		this.setRepositorio(funcionarioRepositorio);
		this.setNome(funcionarioDTO.getNome());
		this.setCpf(funcionarioDTO.getCpf());
		this.setDataAdmissao(funcionarioDTO.getDataAdmissao());
		this.setDataNascimento(funcionarioDTO.getDataNascimento());
		this.setEmail(funcionarioDTO.getEmail());
		this.setFoto(funcionarioDTO.getFoto());
		this.setId(funcionarioDTO.getId());
		this.setObservacao(funcionarioDTO.getObservacao());
		this.setRg(funcionarioDTO.getRg());
		this.setTelefone(funcionarioDTO.getTelefone());
		this.setTipo(TipoFuncionarioDO.PROFESSOR);
	}

	private void setId(Long id) {
		this.id = id;
	}

	private void setCpf(String cpf) {
		this.cpf = cpf;
	}

	private void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	private void setRg(String rg) {
		this.rg = rg;
	}

	private void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	private void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	private void setFoto(String foto) {
		this.foto = foto;
	}

	private void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	private void setTipo(Long tipo) {
		this.tipo = tipo;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public String getCpf() {
		return cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getRg() {
		return rg;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public String getFoto() {
		return foto;
	}

	public String getObservacao() {
		return observacao;
	}

	public Long getTipo() {
		return tipo;
	}

	public String getNome() {
		return nome;
	}

	public void cadastrar() throws Exception {
		this.validaCpfExistente();
		this.validaEmailExistente();
		this.validaRGExistente();
		this.repositorio.cadastrar(this);
	}

	private void validaCpfExistente() throws Exception {
		if (repositorio.qtdFuncionarioComCPF(this.getCpf()).longValue() > 0)
			throw new Exception("CPF já cadastrado");
	}

	private void validaRGExistente() throws Exception {
		if (repositorio.qtdFuncionarioComRG(this.getRg()).longValue() > 0)
			throw new Exception("RG já cadastrado");
	}

	private void validaEmailExistente() throws Exception {
		if (repositorio.qtdFuncionarioComEmail(this.getEmail()).longValue() > 0)
			throw new Exception("Email já cadastrado");
	}

	public void criarComissaoProfessor(Mensalidade mensalidade, Double valorPago) throws Exception {
		if (!this.getTipo().equals(TipoFuncionarioDO.PROFESSOR))
			throw new Exception("Funcioario não é um professor");

		Double valor = new Double(0.0);

		MesReferencia mes = this.getRepositorio().getMesAtual();

		valor = mensalidade.getMatricula().getTurma().getPercentualProfessor(this) * valorPago;
		
		this.getRepositorio().criarSalario(mensalidade, mes, valor, this);

	}

	

}
