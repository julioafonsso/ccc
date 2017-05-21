package br.com.julios.ccc.negocio.mes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

public class MesReferencia {

	private Long id;
	private Long mes;
	private Long ano;

	private Long idNext;
	private Long mesNext;
	private Long anoNext;
	
	
	@Autowired
	MesRerefenciaRepositorio rep;

	public MesReferencia(MesRerefenciaRepositorio mesRerefenciaRepositorio) {
		this.rep = mesRerefenciaRepositorio;
	}

	public Long getId() {
		return id;
	}

	public Long getMes() {
		return mes;
	}

	public Long getAno() {
		return ano;
	}

	protected void setId(Long id) {
		this.id = id;
	}

	protected void setMes(Long mes) {
		this.mes = mes;
	}

	protected void setAno(Long ano) {
		this.ano = ano;
	}
	
	private void setMesNext(Long mesNext) {
		this.mesNext = mesNext;
	}

	private void setAnoNext(Long anoNext) {
		this.anoNext = anoNext;
	}

	public Long getIdNext() {
		return idNext;
	}

	public Long getMesNext() {
		this.setNextMes();
		return mesNext;
	}

	public Long getAnoNext() {
		this.setNextMes();
		return anoNext;
	}

	private void setNextMes()
	{
		if(this.idNext == null || this.idNext == this.id)
		{
			this.idNext = this.id + 1;
			MesReferencia mesRef = rep.getMes(idNext);

			this.setAnoNext(mesRef.getAno());
			this.setMesNext(mesRef.getMes());
		}
		
	}

	public Date getPrimeiroDia() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		String primeiroDia = "01" + "/" + this.getMes() + "/" + this.getAno();

		return sdf.parse(primeiroDia);
	}

	public void nextMes() {

		this.setNextMes();
		this.setId(this.getIdNext());
		this.setMes(this.getMesNext());
		this.setAno(this.getAnoNext());

	}
	
	public String getNomeMes(){
		if(this.getMes().longValue() == 1)
			return "Janeiro";
		if(this.getMes().longValue() == 2)
			return "Fevereiro";
		if(this.getMes().longValue() == 3)
			return "Março";
		if(this.getMes().longValue() == 4)
			return "Abril";
		if(this.getMes().longValue() == 5)
			return "Maio";
		if(this.getMes().longValue() == 6)
			return "Junho";
		if(this.getMes().longValue() == 7)
			return "Julho";
		if(this.getMes().longValue() == 8)
			return "Agosto";
		if(this.getMes().longValue() == 9)
			return "Setembro";
		if(this.getMes().longValue() == 10)
			return "Outubro";
		if(this.getMes().longValue() == 11)
			return "Novembro";
		if(this.getMes().longValue() == 12)
			return "Dezembro";
		return "";
	}

}
