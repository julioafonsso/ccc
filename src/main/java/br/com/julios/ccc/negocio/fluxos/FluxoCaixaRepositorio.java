package br.com.julios.ccc.negocio.fluxos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.FluxoCaixaDAO;
import br.com.julios.ccc.infra.bd.daos.TipoFluxoCaixaDAO;
import br.com.julios.ccc.infra.bd.model.FluxoCaixaDO;
import br.com.julios.ccc.infra.bd.model.TipoFluxoCaixaDO;
import br.com.julios.ccc.infra.dto.CadastroFluxoCaixaDTO;

@Service
public class FluxoCaixaRepositorio {

	@Autowired
	FluxoCaixaDAO fluxoDAO;
	
	@Autowired
	TipoFluxoCaixaDAO tipoFluxoDAO;
	
	public FluxoCaixa getFluxoPagamentoMatricula(CadastroFluxoCaixaDTO cadastro){
		 cadastro.setIdTipo(TipoFluxoCaixaDO.MATRICULA);
		 return getFluxo(cadastro);
	}

	public FluxoCaixa getFluxoPagamentoMensalidade(CadastroFluxoCaixaDTO cadastro) {
		 cadastro.setIdTipo(TipoFluxoCaixaDO.MENSALIDADE);
		 return getFluxo(cadastro);
	}

	public FluxoCaixa getFluxo(CadastroFluxoCaixaDTO cadastro){
		return  new FluxoCaixa(cadastro, this);
	}
	
	protected void cadastrar(FluxoCaixa fluxoPagamento) {
		FluxoCaixaDO fluxoDO = new FluxoCaixaDO();
		fluxoDO.setValor(fluxoPagamento.getValorFluxo());
		fluxoDO.setData(fluxoPagamento.getDataFluxo());
		fluxoDO.setQuantidade(fluxoPagamento.getQtd());
		fluxoDO.setDescricao(fluxoPagamento.getDescricao());
		fluxoDO.setObservacao(fluxoPagamento.getObservacao());
		fluxoDO.setTipoFluxo(tipoFluxoDAO.findOne(fluxoPagamento.getIdTipoFluxo()));
		fluxoDAO.save(fluxoDO);
		
		fluxoPagamento.setIdFluxo(fluxoDO.getId());
		
	}

	
	
}
