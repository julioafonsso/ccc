package br.com.julios.ccc.negocio;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.MesReferenciaDAO;
import br.com.julios.ccc.domains.MesReferencia;

@Service
public class MesApi {

	@Autowired
	MesReferenciaDAO mesDAO;
	
	public MesReferencia getMesAtual(){
		SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
		SimpleDateFormat sdfAno = new SimpleDateFormat("yyyy");
		
		Date hoje = new Date();

		int mesAtual = new Integer(sdfMes.format(hoje));
		int anoAtual = new Integer(sdfAno.format(hoje));

		MesReferencia mesRefAtual = mesDAO.findByMesAndAno(mesAtual, anoAtual);
		
		return mesRefAtual;
	}
	
	public MesReferencia getProximoMes(){
		return mesDAO.findOne(getMesAtual().getId() + 1);
	}
	
	public MesReferencia getProximoMes(MesReferencia mes){
		return mesDAO.findOne(mes.getId() + 1);
	}
	
}
