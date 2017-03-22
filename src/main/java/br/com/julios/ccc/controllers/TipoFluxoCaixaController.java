package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.TipoFluxoCaixa;
import br.com.julios.ccc.facade.FluxoCaixaFacade;

@Controller
@ResponseBody
@RequestMapping("/tipo-fluxo-caixa")
public class TipoFluxoCaixaController {
	
	@Autowired
	FluxoCaixaFacade FluxoCaixaFacade;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<TipoFluxoCaixa> getTipoFluxoCaixa(){
		return FluxoCaixaFacade.getTipoFluxoCaixa();
	}
	
	
	@RequestMapping(value="/entrada", method = RequestMethod.GET)
	public Iterable<TipoFluxoCaixa> getTipoFluxoCaixaEntrada(){
		return FluxoCaixaFacade.getTipoFluxoCaixaEntrada();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public TipoFluxoCaixa getTipoFluxoCaixa(@PathVariable("id") Long id){
		return FluxoCaixaFacade.getTipoFluxoCaixa(id);
	}
	
	
	@RequestMapping(value="/saida", method = RequestMethod.GET)
	public Iterable<TipoFluxoCaixa> getTipoFluxoCaixaSaida(){
		return FluxoCaixaFacade.getTipoFluxoCaixaSaida();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarTipoFluxoCaixa(@RequestBody TipoFluxoCaixa tipoFluxoCaixa){
		FluxoCaixaFacade.cadastrarTipoFluxoCaixa(tipoFluxoCaixa);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarTipoFluxoCaixa(TipoFluxoCaixa tipoFluxoCaixa){
		FluxoCaixaFacade.atualizarTipoFluxoCaixa(tipoFluxoCaixa);
	}
	
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	public void apagarTipoFluxoCaixa(@PathVariable("id") Long id) throws Exception
	{
		FluxoCaixaFacade.apagarTipoFluxoCaixa(id);
	}
	

}
