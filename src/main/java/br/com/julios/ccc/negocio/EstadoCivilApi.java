package br.com.julios.ccc.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.EstadoCivilDAO;
import br.com.julios.ccc.domains.EstadoCivil;

@Service
public class EstadoCivilApi {
	
	@Autowired
	EstadoCivilDAO estadoCivilDAO;

	public Iterable<EstadoCivil> getestadoCivil() {
				return estadoCivilDAO.findAll();
	}
	
	

}
