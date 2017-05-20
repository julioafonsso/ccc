package br.com.julios.ccc.negocio.fluxos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.FluxoCaixaDAO;
import br.com.julios.ccc.infra.bd.model.FluxoCaixaDO;
import br.com.julios.ccc.infra.bd.model.TipoFluxoCaixaDO;

@Service
public class FluxoCaixaRepositorio {

	@Autowired
	FluxoCaixaDAO fluxoDAO;
	
	public FluxoCaixa getFluxoPagamentoMatricula(Double valor){
		return getFluxo(TipoFluxoCaixaDO.MATRICULA, valor);
	}

	public FluxoCaixa getFluxoPagamentoMensalidade(Double valor) {
		return getFluxo(TipoFluxoCaixaDO.MENSALIDADE, valor);
	}

	private FluxoCaixa getFluxo(Long tipoFluxo, Double valor){
		FluxoCaixa fluxo = new FluxoCaixa(this);
		fluxo.setIdFluxo(tipoFluxo);
		fluxo.setValorFluxo(valor);
		return fluxo;
	}
	
	protected void cadastrar(FluxoCaixa fluxoPagamento) {
		FluxoCaixaDO fluxoDO = new FluxoCaixaDO();
		fluxoDO.setData(fluxoPagamento.getDataFluxo());
		fluxoDO.setQuantidade(fluxoPagamento.getQtd());
		fluxoDO.setDescricao(fluxoPagamento.getDescricao());
		fluxoDO.setObservacao(fluxoPagamento.getObservacao());
		
		fluxoDAO.save(fluxoDO);
		
		fluxoPagamento.setIdFluxo(fluxoDO.getId());
		
	}

	
	
}
