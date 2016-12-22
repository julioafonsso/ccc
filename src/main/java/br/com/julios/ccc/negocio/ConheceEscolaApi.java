package br.com.julios.ccc.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.ConheceEscolaDAO;
import br.com.julios.ccc.domains.ConheceEscola;

@Service
public class ConheceEscolaApi {
	
	@Autowired
	ConheceEscolaDAO conheceEscolaDAO;

	public Iterable<ConheceEscola> getconheceEscola() {
				return conheceEscolaDAO.findAll();
	}

}
