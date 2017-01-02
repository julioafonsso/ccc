package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.TipoFluxoCaixa;
import br.com.julios.ccc.negocio.TipoFluxoCaixaApi;

@Controller
@ResponseBody
@RequestMapping("/tipo-fluxo-caixa")
public class TipoFluxoCaixaController {
	
	@Autowired
	TipoFluxoCaixaApi tipoFluxoCaixaApi;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<TipoFluxoCaixa> getTipoFluxoCaixa(){
		return tipoFluxoCaixaApi.gettipoFluxoCaixa();
	}
	
	
	@RequestMapping(value="/entrada", method = RequestMethod.GET)
	public Iterable<TipoFluxoCaixa> getTipoFluxoCaixaEntrada(){
		return tipoFluxoCaixaApi.gettipoFluxoCaixaEntrada();
	}
	
	@RequestMapping(value="/saida", method = RequestMethod.GET)
	public Iterable<TipoFluxoCaixa> getTipoFluxoCaixaSaida(){
		return tipoFluxoCaixaApi.gettipoFluxoCaixaSaida();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarTipoFluxoCaixa(@RequestBody TipoFluxoCaixa tipoFluxoCaixa){
		tipoFluxoCaixaApi.cadastrarTipoFluxoCaixa(tipoFluxoCaixa);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarTipoFluxoCaixa(TipoFluxoCaixa tipoFluxoCaixa){
		tipoFluxoCaixaApi.atualizarTipoFluxoCaixa(tipoFluxoCaixa);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void apagarTipoFluxoCaixa(TipoFluxoCaixa tipoFluxoCaixa)
	{
		tipoFluxoCaixaApi.apagarTipoFluxoCaixa(tipoFluxoCaixa);
	}
	

}
