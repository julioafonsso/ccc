package br.com.julios.ccc.domains;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Email;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.julios.ccc.componentes.cpf.CPF;
import br.com.julios.ccc.util.Util;

@Entity
@Table(name = "ALUNO")
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	@CPF
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

	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "data_nascimento")
	private Date dataNascimento;

	@OneToOne
	@JoinColumn(name = "estado_civil_id")
	private EstadoCivil estadoCivil;

	@Column
	private String profissao;

	@ManyToOne
	@JoinColumn(name = "conhece_escola_id")
	@JsonIgnoreProperties("aluno")
	private ConheceEscola conheceEscola;

	@Column(length = 1)
	private String sexo;

	@Column
	private String telefone;

	@Column
	private String observacao;

	@Column
	private String foto;

	@OneToMany(mappedBy = "aluno")
	@JsonIgnore
	@Where(clause = "data_exclusao is null")
	private List<Matricula> matriculas;

	// Getters and Setters

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public String getCpf() throws Exception {
		if(cpf != null && cpf.length() > 0){
			return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9);
		}
		return null;

	}

	public void setCpf(String cpf) throws Exception {
		if(cpf != null && cpf.length() > 0){
			this.cpf = cpf.replaceAll("[^0-9]", "");
		} else{
			this.cpf = cpf;
		}
	}

	public String getCpfSemFormat(){
		return cpf;
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

	public void setDataNascimento(String dataNascimento) throws ParseException {
		this.dataNascimento = Util.parseDate(dataNascimento);
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public ConheceEscola getConheceEscola() {
		return conheceEscola;
	}

	public void setConheceEscola(ConheceEscola conheceEscola) {
		this.conheceEscola = (ConheceEscola) conheceEscola;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		if(telefone != null )
		{
			if(telefone.length() == 11)
			{
				return "(" + telefone.substring(0, 2) + ")" + telefone.substring(2, 7) + "-"  + telefone.substring(7);
			}
			else{
				return "(" + telefone.substring(0, 2) + ")" + telefone.substring(2, 6) + "-"  + telefone.substring(6);
			}
		}
		return telefone;
	}

	public void setTelefone(String telefone) {
		if(telefone != null && telefone.length() > 0){
			this.telefone = telefone.replaceAll("[^0-9]", "");
		} else{
			this.telefone = telefone;
		}
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

	public long getId() {
		return id;
	}

}
