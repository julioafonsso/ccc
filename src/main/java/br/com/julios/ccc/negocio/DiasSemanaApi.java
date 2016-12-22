package br.com.julios.ccc.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.DiasSemanaDAO;
import br.com.julios.ccc.domains.DiasSemana;

@Service
public class DiasSemanaApi {
	
	@Autowired
	DiasSemanaDAO diasSemanaDAO;

	public Iterable<DiasSemana> getdiasSemana() {
				return diasSemanaDAO.findAll();
	}

}
