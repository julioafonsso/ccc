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
import br.com.julios.ccc.negocio.mes.MesRerefenciaRepositorio;

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
		if(mes == 1)
			return "Janeiro";
		if(mes == 2)
			return "Fevereiro";
		if(mes == 3)
			return "Março";
		if(mes == 4)
			return "Abril";
		if(mes == 5)
			return "Maio";
		if(mes == 6)
			return "Junho";
		if(mes == 7)
			return "Julho";
		if(mes == 8)
			return "Agosto";
		if(mes == 9)
			return "Setembro";
		if(mes == 10)
			return "Outubro";
		if(mes == 11)
			return "Novembro";
		if(mes == 12)
			return "Dezembro";
		return "";
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
