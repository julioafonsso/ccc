package br.com.julios.ccc.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.ConheceEscolaDAO;
import br.com.julios.ccc.infra.bd.model.ConheceEscolaDO;

@Service
public class ConheceEscolaApi {
	

	public Iterable<ConheceEscolaDO> getconheceEscola() {
//				return conheceEscolaDAO.findAll();
		return null;
	}

}
