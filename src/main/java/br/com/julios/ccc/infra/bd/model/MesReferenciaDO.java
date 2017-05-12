package br.com.julios.ccc.infra.bd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mes_referencia")
public class MesReferenciaDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private long mes;
	
	@Column
	private long ano;


	public long getId(){
		return id;
	}
	
	public long getMes() {
		return mes;
	}

	public void setMes(long mes) {
		this.mes = mes;
	}

	public long getAno() {
		return ano;
	}

	public void setAno(long ano) {
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

	
}
