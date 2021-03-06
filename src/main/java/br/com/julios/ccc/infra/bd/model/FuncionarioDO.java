package br.com.julios.ccc.infra.bd.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.julios.ccc.componentes.CPF;
import br.com.julios.ccc.componentes.Telefone;
import br.com.julios.ccc.infra.Contexto;
import br.com.julios.ccc.infra.dto.funcionario.CadastroFuncionarioDTO;
import br.com.julios.ccc.infra.dto.funcionario.ConsultaFuncionarioDTO;
import br.com.julios.ccc.repositorios.FuncionarioRepositorio;

@Entity
@Table(name = "funcionario")
public class FuncionarioDO {

	@Transient
	private FuncionarioRepositorio repositorio;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

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
	private Long numero;

	@Column
	private String complemento;

	@Column
	private String telefone;

	@Column(name = "data_admissao")
	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;

	@Column
	private String observacao;

	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Column
	private String foto;
	
	@ManyToOne
	@JoinColumn(name="id_tipo_funcionario")
	private TipoFuncionarioDO tipoFuncionario;
	
	@Column
	private Double salario;
	
	@Column
	private Double valeTransporte;

	public String getCpf() throws Exception {
		if(cpf != null && cpf.length() > 0){
			return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
		}
		return null;

	}

	public void setCpf(String cpf) throws Exception {
		this.cpf = CPF.getSemFormatacao(cpf);
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
			this.telefone = Telefone.getSemFormato(telefone);
	}

	public Long getId() {
		return id;
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

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public TipoFuncionarioDO getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(TipoFuncionarioDO tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Double getValeTransporte() {
		return valeTransporte;
	}

	public void setValeTransporte(Double valeTransporte) {
		this.valeTransporte = valeTransporte;
	}

	public FuncionarioRepositorio getRepositorio() {
		if(this.repositorio == null)
			this.repositorio = Contexto.bean(FuncionarioRepositorio.class);
		return repositorio;
	}

	public ConsultaFuncionarioDTO cadastrar() throws Exception {
		this.getRepositorio().cadastrar(this);
		return obterConsultaFuncionarioDTO();
		
	}

	private ConsultaFuncionarioDTO obterConsultaFuncionarioDTO() throws Exception {
		return new ConsultaFuncionarioDTO(this.id, this.getNome(), this.getCpf(), this.getTelefone(), this.getEmail(), this.getRg(), this.getFoto(), this.getObservacao(), this.getDataNascimento(), this.getDataAdmissao(), this.getTipoFuncionario().getId(), this.getTipoFuncionario().getNome(), this.getSalario(), this.getValeTransporte());
	}

	public List<ComissaoProfessorDO> getComissoesPendentes(MesReferenciaDO mes) {
		return this.getRepositorio().getComissoesPendentes(this,mes );
	}

	public ConsultaFuncionarioDTO alterar(CadastroFuncionarioDTO cadastro) throws Exception {
		this.setCpf(cadastro.getCpf());
		this.setDataAdmissao(cadastro.getDataAdmissao());
		this.setDataNascimento(cadastro.getDataNascimento());
		this.setEmail(cadastro.getEmail());
		this.setFoto(cadastro.getFoto());
		this.setNome(cadastro.getNome());
		this.setObservacao(cadastro.getObservacao());
		this.setRg(cadastro.getRg());
		this.setSalario(cadastro.getSalario());
		this.setTelefone(cadastro.getTelefone());
		this.setValeTransporte(cadastro.getValeTransporte());
		return this.cadastrar();
	}

	public List<TurmaColetivaDO> getTurmas() throws Exception {
		if(this.tipoFuncionario == null || !this.tipoFuncionario.ehProfessor())
			throw new Exception("Funcionario não é professor !");
		
		return this.getRepositorio().getTurmas(this);
	}

	
}
