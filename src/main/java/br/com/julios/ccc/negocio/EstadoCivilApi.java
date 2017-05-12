package br.com.julios.ccc.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.EstadoCivilDAO;
import br.com.julios.ccc.infra.bd.model.EstadoCivilDO;

@Service
public class EstadoCivilApi {
	
	@Autowired
	EstadoCivilDAO estadoCivilDAO;

	public Iterable<EstadoCivilDO> getestadoCivil() {
				return estadoCivilDAO.findAll();
	}
	
	

}
