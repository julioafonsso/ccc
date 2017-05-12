package br.com.julios.ccc.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.NivelTurmaDAO;
import br.com.julios.ccc.infra.bd.model.NivelTurmaDO;

@Service
public class NivelTurmaApi {
	
	@Autowired
	NivelTurmaDAO nivelTurmaDAO;

	public Iterable<NivelTurmaDO> getnivelTurma() {
				return nivelTurmaDAO.findAll();
	}

}
