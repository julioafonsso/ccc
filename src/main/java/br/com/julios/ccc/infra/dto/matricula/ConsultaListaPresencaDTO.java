package br.com.julios.ccc.infra.dto.matricula;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ConsultaListaPresencaDTO {

	private String codigo;
	private String nome;
	private String diaNascimento;
	private String mesNascimento;
	private Date ultimoPagamento;
	private List<Date> datasAulas;
	
	
	
	
	public String getCodigo() {
		return codigo;
	}




	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public Date getUltimoPagamento() {
		return ultimoPagamento;
	}




	public void setUltimoPagamento(Date ultimoPagamento) {
		this.ultimoPagamento = ultimoPagamento;
	}




	public List<Date> getDatasAulas() {
		return datasAulas;
	}




	public void setDatasAulas(List<Date> datasAulas) {
		this.datasAulas = datasAulas;
	}




	public String getDiaNascimento() {
		return diaNascimento;
	}




	public String getMesNascimento() {
		return mesNascimento;
	}




	public void setDataNascimento(Date dataNascimentoAluno) {
		SimpleDateFormat sdfDia = new SimpleDateFormat("dd");
		SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
		this.diaNascimento = sdfDia.format(dataNascimentoAluno);
		this.mesNascimento = sdfMes.format(dataNascimentoAluno);		
	}
	
	
	
}

