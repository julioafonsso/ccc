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
	MesReferenciaDAO mDAO;
	
	public MesReferencia getMes(Long id)
	{
		if(id == null)
			return getMes((MesReferenciaDO)null);
		MesReferenciaDO mesDO = mDAO.findOne(id);
		return getMes(mesDO);
	}

	public MesReferencia getMes(Long mes, Long ano) {
		MesReferenciaDO mesDO = mDAO.findByMesAndAno(mes,ano);
		return getMes(mesDO);
	}
	
	public MesReferencia getMesAtual(){
		SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
		SimpleDateFormat sdfAno = new SimpleDateFormat("YYYY");
		Long mes = new Long(sdfMes.format(new Date()));
		Long ano = new Long(sdfAno.format(new Date()));
		
		return getMes(mes, ano);
	}
	
	private MesReferencia getMes(MesReferenciaDO mesDO) {
		MesReferencia mesReferencia = new MesReferencia(this);
		if(mesDO != null)
		{
			mesReferencia.setAno(mesDO.getAno());
			mesReferencia.setMes(mesDO.getMes());
			mesReferencia.setId(mesDO.getId());
		}
			
		return mesReferencia;
	}

	
	
}
