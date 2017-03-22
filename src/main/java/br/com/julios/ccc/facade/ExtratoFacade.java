package br.com.julios.ccc.facade;

import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.julios.ccc.domains.Extrato;
import br.com.julios.ccc.negocio.ExtratoApi;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ExtratoFacade {

	@Autowired
	ExtratoApi extratoApi;
	
	public Collection<Extrato> getExtrato(Date dInicio, Date dFim) {
		return extratoApi.getExtrato(dInicio, dFim);
	}

	public Object[] getExtratoConsolidado(Date dInicio, Date dFim, boolean indEntrada) {
		return extratoApi.getExtratoConsolidado(dInicio, dFim, indEntrada);
	}

	
}
