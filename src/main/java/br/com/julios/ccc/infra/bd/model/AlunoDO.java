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
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.julios.ccc.componentes.CPF;
import br.com.julios.ccc.infra.Contexto;
import br.com.julios.ccc.negocio.aluno.AlunoRepositorio;

@Entity
@Table(name = "aluno")
public class AlunoDO {

	@Transient
	AlunoRepositorio repositorio;
	
	
	
	private AlunoRepositorio getRepositorio() {
		if(this.repositorio == null)
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

	@ManyToOne
	@JoinColumn(name="id_bairro")
	private BairroDO bairro;
	
	@Column
	private String cidade;

	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "data_nascimento")
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


	// Getters and Setters


	public String getCpf() throws Exception {
//		if(cpf != null && cpf.length() > 0){
//			return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
//		}
//		return null;
		return this.cpf;

	}

	public void setCpf(String cpf) throws Exception {
		this.cpf = CPF.getSemFormatacao(cpf);
	}

	public String getTelefone() {
//		if(telefone != null )
//		{
//			if(telefone.length() == 11)
//			{
//				return "(" + telefone.substring(0, 2) + ")" + telefone.substring(2, 7) + "-"  + telefone.substring(7);
//			}
//			else{
//				return "(" + telefone.substring(0, 2) + ")" + telefone.substring(2, 6) + "-"  + telefone.substring(6);
//			}
//		}
		return telefone;
	}

	public void setTelefone(String telefone) {
		if(telefone != null && telefone.length() > 0){
			this.telefone = telefone.replaceAll("[^0-9]", "");
		} else{
			this.telefone = telefone;
		}
	}

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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) throws Exception {
		if(this.getRepositorio().qtdAlunoComRG(rg).longValue() > 0)
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


	public BairroDO getBairro() {
		return bairro;
	}

	public void setBairro(BairroDO bairro) {
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

	
	public void cadastrar() throws Exception{
		this.getRepositorio().cadastrar(this);
	}
	
	
	
	
	
}
