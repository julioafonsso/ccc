package br.com.julios.ccc.infra.bd.model;

import java.util.Date;

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

import org.hibernate.validator.constraints.Email;

import br.com.julios.ccc.componentes.CPF;
import br.com.julios.ccc.infra.Contexto;
import br.com.julios.ccc.infra.dto.aluno.CadastroAlunoDTO;
import br.com.julios.ccc.infra.dto.aluno.ConsultaAlunoDTO;
import br.com.julios.ccc.repositorios.AlunoRepositorio;

@Entity
@Table(name = "aluno")
public class AlunoDO {

	@Transient
	AlunoRepositorio repositorio;

	private AlunoRepositorio getRepositorio() {
		if (this.repositorio == null)
			this.repositorio = Contexto.bean(AlunoRepositorio.class);
		return repositorio;
	}

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
	@Email
	private String email;

	@Column
	private String endereco;

	@Column
	private Long numero;

	@Column
	private String complemento;

	@Column
	private String bairro;

	@Column
	private String cidade;

	
	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@ManyToOne
	@JoinColumn(name = "id_estado_civil")
	private EstadoCivilDO estadoCivil;

	@Column
	private String profissao;

	@ManyToOne
	@JoinColumn(name = "id_conhece_escola")
	private ConheceEscolaDO conheceEscola;

	@Column(length = 1)
	private String sexo;

	@Column
	private String telefone;

	@Column
	private String observacao;

	@Column
	private String foto;
	
	@Column(name = "data_exclusao")
	private Date dataExclusao;
	
	@Column
	private boolean receberEmail;
	
	private boolean ativo;

	// Getters and Setters

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public boolean isReceberEmail() {
		return receberEmail;
	}

	public void setReceberEmail(boolean receberEmail) {
		this.receberEmail = receberEmail;
	}

	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	public String getCpf() throws Exception {
		return this.cpf;

	}

	public void setCpf(String cpf) throws Exception {
		this.cpf = CPF.getSemFormatacao(cpf);
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		if (telefone != null && telefone.length() > 0) {
			this.telefone = telefone.replaceAll("[^0-9]", "");
		} else {
			this.telefone = telefone;
		}
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

	public void setRg(String rg) throws Exception {
		AlunoDO aluno = this.getRepositorio().getAlunoPorRG(rg);
		
		if(aluno != null && !aluno.getId().equals(this.getId()))
			throw new Exception("RG já cadastrado");
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

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	public EstadoCivilDO getEstadoCivil() {
		if(estadoCivil == null)
			return new EstadoCivilDO();
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivilDO estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public ConheceEscolaDO getConheceEscola() {
		if(conheceEscola == null)
			return new ConheceEscolaDO();
		return conheceEscola;
	}

	public void setConheceEscola(ConheceEscolaDO conheceEscola) {
		this.conheceEscola = conheceEscola;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
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

	public ConsultaAlunoDTO cadastrar() throws Exception {
		this.getRepositorio().cadastrar(this);
		return getConsulta();
	}

	public ConsultaAlunoDTO getConsulta() throws Exception {
		return new ConsultaAlunoDTO(this.getId(), this.getCpf(), this.getNome(), this.getRg(), this.getEmail(),
				this.getEndereco(), this.getNumero(), this.getComplemento(), this.getBairro(),
				this.getCidade(), this.getDataNascimento(), this.getEstadoCivil().getId(),
				this.getEstadoCivil().getNome(), this.getProfissao(), this.getConheceEscola().getId(),
				this.getConheceEscola().getNome(), this.getSexo(), this.getTelefone(), this.getObservacao(),
				this.getFoto(), this.isReceberEmail(), this.isAtivo());
	}

	public ConsultaAlunoDTO atualizar(CadastroAlunoDTO aluno) throws Exception {
		this.setBairro(aluno.getNomeBairro());
		this.setComplemento(aluno.getComplemento());
		this.setConheceEscola(this.getRepositorio().getConheceEscola(aluno.getIdConheceEscola()));
		this.setCpf(aluno.getCpf());
		this.setDataNascimento(aluno.getDataNascimento());
		this.setEmail(aluno.getEmail());
		this.setEndereco(aluno.getEndereco());
		this.setEstadoCivil(this.getRepositorio().getEstadoCivil(aluno.getIdEstadoCivil()));
		this.setFoto(aluno.getFoto());
		this.setNome(aluno.getNome());
		this.setNumero(aluno.getNumero());
		this.setObservacao(aluno.getObservacao());
		this.setProfissao(aluno.getProfissao());
		this.setRg(aluno.getRg());
		this.setSexo(aluno.getSexo());
		this.setTelefone(aluno.getTelefone());
		this.setReceberEmail(aluno.isReceberEmail());
		return this.cadastrar();
	}

	public void delete() throws Exception {
		this.setAtivo(false);
		this.getRepositorio().cadastrar(this);
	}

	public void reativar() throws Exception {
		this.setAtivo(true);
		this.getRepositorio().cadastrar(this);
	}
}
