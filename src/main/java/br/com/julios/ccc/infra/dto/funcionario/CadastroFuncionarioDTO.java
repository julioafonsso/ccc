package br.com.julios.ccc.infra.dto.funcionario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.julios.ccc.util.Util;

public class CadastroFuncionarioDTO {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	private String cpf;
	private String telefone;
	private String email;
	private String rg;
	private Date dataNascimento;
	private Date dataAdmissao;
	private String foto;
	private String observacao;
	private String nome;
	
	private Double salario;
	private Double valeTransporte;
	private Long idTipo;
	
	
	
	public String getNome() {
		return nome;
	}
	public Long getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(Long idTipo) {
		this.idTipo = idTipo;
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
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) throws ParseException {
		
		this.setDataNascimento( sdf.parse(dataNascimento));
	}
	public void setDataNascimento(Date dataNascimento){
		this.dataNascimento = dataNascimento;
	}
	
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(String dataAdmissao) throws ParseException {
		this.setDataAdmissao(sdf.parse(dataAdmissao));
	}
	
	public void setDataAdmissao(Date dataAdmissao){
		this.dataAdmissao = dataAdmissao;
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
	public Double getSalario() {
		return salario;
	}
	
	public Double getValeTransporte() {
		return valeTransporte;
	}
	
	public void setValeTransporte(String valeTransporte) {
		this.setValeTransporte(Util.convertToDouble(valeTransporte));
	}
	
	public void setSalario(String salario) {
		
				
		this.setSalario(Util.convertToDouble(salario));
		
	}
	
	public void setValeTransporte(Double valeTransporte) {
		this.valeTransporte = valeTransporte;
	}
	
	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
	
		
}
