package br.com.julios.ccc.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.MesReferenciaDAO;
import br.com.julios.ccc.infra.bd.model.MesReferenciaDO;

@Service
public class MesApi {

	@Autowired
	MesReferenciaDAO mesDAO;
	
	public MesReferenciaDO getMesAtual(){
//		SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
//		SimpleDateFormat sdfAno = new SimpleDateFormat("yyyy");
//		
//		Date hoje = new Date();
//
//		int mesAtual = new Integer(sdfMes.format(hoje));
//		int anoAtual = new Integer(sdfAno.format(hoje));
//
//		MesReferenciaDO mesRefAtual = mesDAO.findByMesAndAno(mesAtual, anoAtual);
//		
//		return mesRefAtual;
		return null;
	}
	
	public MesReferenciaDO getProximoMes(){
		return mesDAO.findOne(getMesAtual().getId() + 1);
	}
	
	public MesReferenciaDO getProximoMes(MesReferenciaDO mes){
		return mesDAO.findOne(mes.getId() + 1);
	}
	
	public Date getPrimeiroDiasMesAtual() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		MesReferenciaDO mesAtual = getMesAtual();

		String primeiroDia = "01" + "/" + mesAtual.getMes() + "/" + mesAtual.getAno();
		
		return sdf.parse(primeiroDia);

	}

	public Date getPrimeiroDia(MesReferenciaDO mesAtual) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		String primeiroDia = "01" + "/" + mesAtual.getMes() + "/" + mesAtual.getAno();
		
		return sdf.parse(primeiroDia);

	}
	
}
