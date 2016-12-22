package br.com.julios.ccc.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.SalasDAO;
import br.com.julios.ccc.domains.Salas;

@Service
public class SalasApi {
	
	@Autowired
	SalasDAO salaDAO;

	public Iterable<Salas> getsala() {
				return salaDAO.findAll();
	}
	
	

}
