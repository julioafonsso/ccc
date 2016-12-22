package br.com.julios.ccc.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.NivelTurmaDAO;
import br.com.julios.ccc.domains.NivelTurma;

@Service
public class NivelTurmaApi {
	
	@Autowired
	NivelTurmaDAO nivelTurmaDAO;

	public Iterable<NivelTurma> getnivelTurma() {
				return nivelTurmaDAO.findAll();
	}

}
