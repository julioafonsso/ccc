package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.bd.model.FluxoCaixaDO;
import br.com.julios.ccc.infra.dto.fluxo_caixa.CadastroFluxoCaixaDTO;
import br.com.julios.ccc.repositorios.FluxoCaixaRepositorio;

@Controller
@ResponseBody
@RequestMapping("/fluxo-caixa")
public class FluxoCaixaController {
	
	@Autowired
	FluxoCaixaRepositorio fluxoRepositorio;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<FluxoCaixaDO> getFluxosCaixa(){
		return null;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarFluxoCaixa(@RequestBody CadastroFluxoCaixaDTO fluxoCaixa){
		fluxoRepositorio.getFluxo(fluxoCaixa).cadastrar();
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarFluxoCaixa(@RequestBody FluxoCaixaDO fluxoCaixa){
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void apagarFluxoCaixa(@RequestBody FluxoCaixaDO fluxoCaixa){
	}
	
	
}
