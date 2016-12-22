package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.domains.TipoFluxoCaixa;
import br.com.julios.ccc.negocio.TipoFluxoCaixaApi;

@Controller
@ResponseBody
@RequestMapping("/tiposfluxocaixa")
public class TipoFluxoCaixaController {
	
	@Autowired
	TipoFluxoCaixaApi tipoFluxoCaixa;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<TipoFluxoCaixa> gettipoFluxoCaixa(){
		return tipoFluxoCaixa.gettipoFluxoCaixa();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarTipoFluxoCaixa(){
		tipoFluxoCaixa.cadastrarTipoFluxoCaixa();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarTipoFluxoCaixa(){
		tipoFluxoCaixa.atualizarTipoFluxoCaixa();
	}

}
