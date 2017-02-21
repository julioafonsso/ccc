package br.com.julios.ccc.negocio;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.FluxoCaixaDAO;
import br.com.julios.ccc.daos.TipoFluxoCaixaDAO;
import br.com.julios.ccc.domains.FluxoCaixa;
import br.com.julios.ccc.domains.Mensalidades;
import br.com.julios.ccc.domains.TipoFluxoCaixa;

@Service
public class FluxoCaixaApi {

	@Autowired
	FluxoCaixaDAO fluxoCaixaDAO;
	
	@Autowired 
	TipoFluxoCaixaDAO tipoFluxoCaixaDAO;

	public Iterable<FluxoCaixa> getFluxosCaixa() {
		return fluxoCaixaDAO.findAll();
	}

	public FluxoCaixa cadastrarFluxoCaixa(FluxoCaixa fluxoCaixa) {
		if (!fluxoCaixa.getTipoFluxo().isIndEntrada())
			fluxoCaixa.setValor(fluxoCaixa.getValor() * -1);
		
		fluxoCaixaDAO.save(fluxoCaixa);
		return fluxoCaixa;
	}

	public FluxoCaixa cadastrarFluxoCaixaPagamentoMensalidade(Mensalidades mensalidade){
		
		TipoFluxoCaixa tipoFluxoMensalidade = tipoFluxoCaixaDAO.findOne(TipoFluxoCaixa.MENSALIDADE);
		
		FluxoCaixa fluxo = new FluxoCaixa();
		fluxo.setDataFluxo(new Date());
		fluxo.setDescricao("Recebimento Mensalidade ");
		fluxo.setTipoFluxo(tipoFluxoMensalidade);
		fluxo.setValor(mensalidade.getValorParaPagar());

		return cadastrarFluxoCaixa(fluxo);
	}

	public void atualizarFluxoCaixa(FluxoCaixa fluxoCaixa) {
		fluxoCaixaDAO.save(fluxoCaixa);
	}

	public void apagarFluxoCaixa(FluxoCaixa fluxoCaixa) {
		fluxoCaixaDAO.delete(fluxoCaixa);
	}

}
