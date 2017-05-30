package br.com.julios.ccc.infra.bd.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.julios.ccc.infra.Contexto;
import br.com.julios.ccc.repositorios.MesRerefenciaRepositorio;

@Entity
@Table(name = "mes_referencia")
public class MesReferenciaDO {

	@Transient
	private MesRerefenciaRepositorio repositorio;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private Long mes;
	
	@Column
	private Long ano;


	public Long getId(){
		return id;
	}
	
	public Long getMes() {
		return mes;
	}

	public void setMes(Long mes) {
		this.mes = mes;
	}

	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}
	
	public String getNomeMes(){
		String retorno = "";
		if(mes == 1)
			retorno =  "Janeiro";
		if(mes == 2)
			retorno =  "Fevereiro";
		if(mes == 3)
			retorno =  "Março";
		if(mes == 4)
			retorno =  "Abril";
		if(mes == 5)
			retorno =  "Maio";
		if(mes == 6)
			retorno =  "Junho";
		if(mes == 7)
			retorno =  "Julho";
		if(mes == 8)
			retorno =  "Agosto";
		if(mes == 9)
			retorno =  "Setembro";
		if(mes == 10)
			retorno =  "Outubro";
		if(mes == 11)
			retorno =  "Novembro";
		if(mes == 12)
			retorno =  "Dezembro";
		
		retorno += " de " + this.getAno();
		return retorno;
	}
	
	public Date getPrimeiroDia() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		String primeiroDia = "01" + "/" + this.getMes() + "/" + this.getAno();

		return sdf.parse(primeiroDia);
	}

	public String getMesFormatado() {
		return this.getMes() + "/" + this.getAno();
	}

	public String getProximoMesFormatado() {
		
		MesReferenciaDO proximoMes = this.getRepositorio().getMes(this.getId() + 1);
		
		return proximoMes.getMes() + "/" + proximoMes.getAno();
	}

	public MesReferenciaDO getProximoMes() {
		return this.getRepositorio().getMes(this.getId() + 1);
	}

	private MesRerefenciaRepositorio getRepositorio() {
		if(this.repositorio == null)
			this.repositorio = Contexto.bean(MesRerefenciaRepositorio.class);
		return repositorio;
	}
}
