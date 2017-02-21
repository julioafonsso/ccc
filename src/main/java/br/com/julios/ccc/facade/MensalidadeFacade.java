package br.com.julios.ccc.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.domains.FluxoCaixa;
import br.com.julios.ccc.domains.Mensalidades;
import br.com.julios.ccc.negocio.FluxoCaixaApi;
import br.com.julios.ccc.negocio.MensalidadeApi;

@Service
public class MensalidadeFacade {
	
	@Autowired
	FluxoCaixaApi fluxoApi;
	
	@Autowired
	MensalidadeApi mensalidadeApi;
	
	public void efetuarPagamento(Mensalidades mensalidade) {
		FluxoCaixa fluxo = fluxoApi.cadastrarFluxoCaixaPagamentoMensalidade(mensalidade);
		mensalidadeApi.cadastrarMensalidadePaga(mensalidade, fluxo);
	}

}
