package br.com.julios.ccc.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.domains.FluxoCaixa;
import br.com.julios.ccc.domains.ModalidadeTurma;
import br.com.julios.ccc.domains.TipoFluxoCaixa;
import br.com.julios.ccc.negocio.FluxoCaixaApi;
import br.com.julios.ccc.negocio.TipoFluxoCaixaApi;

@Service
public class FluxoCaixaFacade {

	@Autowired
	FluxoCaixaApi fluxoApi;
	
	@Autowired
	TipoFluxoCaixaApi tipoFluxoCaixaApi;
	
	public Iterable<FluxoCaixa> getFluxosCaixa() {
		return fluxoApi.getFluxosCaixa();
	}

	public void cadastrarFluxoCaixa(FluxoCaixa fluxoCaixa) {
		fluxoApi.cadastrarFluxoCaixa(fluxoCaixa);
	}

	public void atualizarFluxoCaixa(FluxoCaixa fluxoCaixa) {
		fluxoApi.atualizarFluxoCaixa(fluxoCaixa);
	}

	public void apagarFluxoCaixa(FluxoCaixa fluxoCaixa) {
		fluxoApi.apagarFluxoCaixa(fluxoCaixa);
	}

	public Iterable<TipoFluxoCaixa> getTipoFluxoCaixa() {
		return tipoFluxoCaixaApi.getTipoFluxoCaixa();
	}

	public Iterable<TipoFluxoCaixa> getTipoFluxoCaixaEntrada() {
		return tipoFluxoCaixaApi.getTipoFluxoCaixaEntrada();
	}

	public Iterable<TipoFluxoCaixa> getTipoFluxoCaixaSaida() {
		return tipoFluxoCaixaApi.getTipoFluxoCaixaSaida();
	}

	public void cadastrarTipoFluxoCaixa(TipoFluxoCaixa tipoFluxoCaixa) {
		tipoFluxoCaixaApi.cadastrarTipoFluxoCaixa(tipoFluxoCaixa);
	}

	public void atualizarTipoFluxoCaixa(TipoFluxoCaixa tipoFluxoCaixa) {
		tipoFluxoCaixaApi.atualizarTipoFluxoCaixa(tipoFluxoCaixa);
		
	}

	public void apagarTipoFluxoCaixa(TipoFluxoCaixa tipoFluxoCaixa) {
		tipoFluxoCaixaApi.apagarTipoFluxoCaixa(tipoFluxoCaixa);
		
	}

	public TipoFluxoCaixa getTipoFluxoCaixa(Long id) {
		return tipoFluxoCaixaApi.getTipoFluxoCaixa(id);
	}

}
