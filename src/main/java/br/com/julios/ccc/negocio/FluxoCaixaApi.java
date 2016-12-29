package br.com.julios.ccc.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.FluxoCaixaDAO;
import br.com.julios.ccc.domains.FluxoCaixa;

@Service
public class FluxoCaixaApi {
	
	@Autowired
	FluxoCaixaDAO fluxoCaixaDAO;

	public Iterable<FluxoCaixa> getFluxosCaixa() {
		return fluxoCaixaDAO.findAll();
	}

	public void cadastrarFluxoCaixa(FluxoCaixa fluxoCaixa) {
		fluxoCaixaDAO.save(fluxoCaixa);
				
	}

	public void atualizarFluxoCaixa(FluxoCaixa fluxoCaixa) {
		fluxoCaixaDAO.save(fluxoCaixa);				
	}

	public void apagarFluxoCaixa(FluxoCaixa fluxoCaixa) {
		fluxoCaixaDAO.delete(fluxoCaixa);
				
	}


}
