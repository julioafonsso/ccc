package br.com.julios.ccc.negocio.mes;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.MesReferenciaDAO;
import br.com.julios.ccc.infra.bd.model.MesReferenciaDO;

@Service
public class MesRerefenciaRepositorio {

	@Autowired
	private MesReferenciaDAO mDAO;
	
	public  MesReferenciaDO getMes(Long id)
	{
			
		MesReferenciaDO mesDO = mDAO.findOne(id);
		return mesDO;
	}

	public   MesReferenciaDO getMes(Long mes, Long ano) {
		MesReferenciaDO mesDO = mDAO.findByMesAndAno(mes,ano);
		return mesDO;
	}

	public MesReferenciaDO getMesAtual() {
		SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
		SimpleDateFormat sdfAno = new SimpleDateFormat("YYYY");
		Long mes = new Long(sdfMes.format(new Date()));
		Long ano = new Long(sdfAno.format(new Date()));
		
		return getMes(mes, ano);
	}
	
	

	
	
}
