package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.FluxoCaixa;
import br.com.julios.ccc.negocio.FluxoCaixaApi;

@Controller
@ResponseBody
@RequestMapping("/fluxosCaixa")
public class FluxoCaixaController {
	
	@Autowired
	FluxoCaixaApi fluxoCaixa;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<FluxoCaixa> getFluxosCaixa(){
		return fluxoCaixa.getFluxosCaixa();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarFluxoCaixa(){
		fluxoCaixa.cadastrarFluxoCaixa();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarFluxoCaixa(){
		fluxoCaixa.atualizarFluxoCaixa();
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void apagarFluxoCaixa(){
		fluxoCaixa.apagarFluxoCaixa();
	}

}
