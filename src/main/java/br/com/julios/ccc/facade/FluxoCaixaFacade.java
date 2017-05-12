package br.com.julios.ccc.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.julios.ccc.infra.bd.model.FluxoCaixaDO;
import br.com.julios.ccc.infra.bd.model.TipoFluxoCaixaDO;
import br.com.julios.ccc.negocio.FluxoCaixaApi;
import br.com.julios.ccc.negocio.TipoFluxoCaixaApi;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class FluxoCaixaFacade {

	@Autowired
	FluxoCaixaApi fluxoApi;
	
	@Autowired
	TipoFluxoCaixaApi tipoFluxoCaixaApi;
	
	public Iterable<FluxoCaixaDO> getFluxosCaixa() {
		return fluxoApi.getFluxosCaixa();
	}

	public void cadastrarFluxoCaixa(FluxoCaixaDO fluxoCaixa) {
		fluxoApi.cadastrarFluxoCaixa(fluxoCaixa);
	}

	public void atualizarFluxoCaixa(FluxoCaixaDO fluxoCaixa) {
		fluxoApi.atualizarFluxoCaixa(fluxoCaixa);
	}

	public void apagarFluxoCaixa(FluxoCaixaDO fluxoCaixa) {
		fluxoApi.apagarFluxoCaixa(fluxoCaixa);
	}

	public Iterable<TipoFluxoCaixaDO> getTipoFluxoCaixa() {
		return tipoFluxoCaixaApi.getTipoFluxoCaixa();
	}

	public Iterable<TipoFluxoCaixaDO> getTipoFluxoCaixaEntrada() {
		return tipoFluxoCaixaApi.getTipoFluxoCaixaEntrada();
	}

	public Iterable<TipoFluxoCaixaDO> getTipoFluxoCaixaSaida() {
		return tipoFluxoCaixaApi.getTipoFluxoCaixaSaida();
	}

	public void cadastrarTipoFluxoCaixa(TipoFluxoCaixaDO tipoFluxoCaixa) {
		tipoFluxoCaixaApi.cadastrarTipoFluxoCaixa(tipoFluxoCaixa);
	}

	public void atualizarTipoFluxoCaixa(TipoFluxoCaixaDO tipoFluxoCaixa) {
		tipoFluxoCaixaApi.atualizarTipoFluxoCaixa(tipoFluxoCaixa);
		
	}

	public void apagarTipoFluxoCaixa(Long id) throws Exception {
		TipoFluxoCaixaDO tipoFluxoCaixa = tipoFluxoCaixaApi.getTipoFluxoCaixa(id);
//		tipoFluxoCaixa.validaExisteFluxoCaixa(tipoFluxoCaixa);
		tipoFluxoCaixaApi.apagarTipoFluxoCaixa(tipoFluxoCaixa);
		
	}

	public TipoFluxoCaixaDO getTipoFluxoCaixa(Long id) {
		return tipoFluxoCaixaApi.getTipoFluxoCaixa(id);
	}

}
