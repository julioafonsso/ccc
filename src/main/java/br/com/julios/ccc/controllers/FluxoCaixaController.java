package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.FluxoCaixa;
import br.com.julios.ccc.negocio.FluxoCaixaApi;

@Controller
@ResponseBody
@RequestMapping("/fluxo-caixa")
public class FluxoCaixaController {
	
	@Autowired
	FluxoCaixaApi fluxoCaixaApi;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<FluxoCaixa> getFluxosCaixa(){
		return fluxoCaixaApi.getFluxosCaixa();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarFluxoCaixa(@RequestBody FluxoCaixa fluxoCaixa){
		fluxoCaixaApi.cadastrarFluxoCaixa(fluxoCaixa);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarFluxoCaixa(@RequestBody FluxoCaixa fluxoCaixa){
		fluxoCaixaApi.atualizarFluxoCaixa(fluxoCaixa);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void apagarFluxoCaixa(@RequestBody FluxoCaixa fluxoCaixa){
		fluxoCaixaApi.apagarFluxoCaixa(fluxoCaixa);
	}

}
