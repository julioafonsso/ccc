package br.com.julios.ccc.controllers;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public CadastroFluxoCaixaDTO getFluxosCaixa(@PathVariable("id") Long idFluxo){
		FluxoCaixaDO fluxo = fluxoRepositorio.getFluxo(idFluxo);
		
		CadastroFluxoCaixaDTO retorno  = new CadastroFluxoCaixaDTO();
		retorno.setData(fluxo.getData());
		retorno.setDescricao(fluxo.getDescricao());
		retorno.setIdTipo(fluxo.getTipoFluxo().getId());
		retorno.setObservacao(fluxo.getObservacao());
		retorno.setQtd(fluxo.getQuantidade());
		retorno.setValor(fluxo.getValor());
		retorno.setId(fluxo.getId());
		if(fluxo.getTipoFluxo().isIndEntrada())
			retorno.setTipo("E");
		else
			retorno.setTipo("S");
		
		return retorno;
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarFluxoCaixa(@RequestBody CadastroFluxoCaixaDTO fluxoCaixa) throws ParseException{
		fluxoRepositorio.getFluxo(fluxoCaixa).cadastrar();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public void atualizarFluxoCaixa(@RequestBody CadastroFluxoCaixaDTO fluxoCaixa, @PathVariable("id") Long idFluxo) throws ParseException{
		fluxoRepositorio.getFluxo(idFluxo).alterar(fluxoCaixa);
	}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public void apagarFluxoCaixa(@RequestBody FluxoCaixaDO fluxoCaixa){
	}
	
	
}
