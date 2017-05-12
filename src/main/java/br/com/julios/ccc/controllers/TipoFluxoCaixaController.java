package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.facade.FluxoCaixaFacade;
import br.com.julios.ccc.infra.bd.model.TipoFluxoCaixaDO;

@Controller
@ResponseBody
@RequestMapping("/tipo-fluxo-caixa")
public class TipoFluxoCaixaController {
	
	@Autowired
	FluxoCaixaFacade FluxoCaixaFacade;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<TipoFluxoCaixaDO> getTipoFluxoCaixa(){
		return null;
	}
	
	
	@RequestMapping(value="/entrada", method = RequestMethod.GET)
	public Iterable<TipoFluxoCaixaDO> getTipoFluxoCaixaEntrada(){
		return null;
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public TipoFluxoCaixaDO getTipoFluxoCaixa(@PathVariable("id") Long id){
		return null;
	}
	
	
	@RequestMapping(value="/saida", method = RequestMethod.GET)
	public Iterable<TipoFluxoCaixaDO> getTipoFluxoCaixaSaida(){
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarTipoFluxoCaixa(@RequestBody TipoFluxoCaixaDO tipoFluxoCaixa){
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarTipoFluxoCaixa(TipoFluxoCaixaDO tipoFluxoCaixa){
	}
	
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	public void apagarTipoFluxoCaixa(@PathVariable("id") Long id) throws Exception
	{
		FluxoCaixaFacade.apagarTipoFluxoCaixa(id);
	}
	

}
