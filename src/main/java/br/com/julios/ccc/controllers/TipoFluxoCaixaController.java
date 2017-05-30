package br.com.julios.ccc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.bd.daos.TipoFluxoCaixaDAO;
import br.com.julios.ccc.infra.dto.fluxo_caixa.CadastroTipoFluxoDTO;
import br.com.julios.ccc.infra.dto.fluxo_caixa.ConsultaTipoFluxoDTO;
import br.com.julios.ccc.repositorios.TipoFluxoRepositorio;

@Controller
@ResponseBody
@RequestMapping("/tipo-fluxo-caixa")
public class TipoFluxoCaixaController {
	
	
	@Autowired
	private TipoFluxoRepositorio tipoRepositorio;
	
	@Autowired
	private TipoFluxoCaixaDAO tipoDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ConsultaTipoFluxoDTO> getTipoFluxoCaixa(){
		return this.tipoDAO.get();
	}
	
	
	@RequestMapping(value="/entrada", method = RequestMethod.GET)
	public List<ConsultaTipoFluxoDTO> getTipoFluxoCaixaEntrada(){
		return this.tipoDAO.get(true);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ConsultaTipoFluxoDTO getTipoFluxoCaixa(@PathVariable("id") Long id){
		return this.tipoDAO.get(id);
	}
	
	
	@RequestMapping(value="/saida", method = RequestMethod.GET)
	public List<ConsultaTipoFluxoDTO> getTipoFluxoCaixaSaida(){
		return this.tipoDAO.get(true);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarTipoFluxoCaixa(@RequestBody CadastroTipoFluxoDTO cadastro) throws Exception{
		this.tipoRepositorio.get(cadastro).cadastrar();
	}
	
	@RequestMapping(value="/{id}" ,method = RequestMethod.PUT)
	public void atualizarTipoFluxoCaixa(@PathVariable("id") Long id, @RequestBody CadastroTipoFluxoDTO cadastro) throws Exception{
		this.tipoRepositorio.get(id).atualizar(cadastro);
	}
	
	@RequestMapping(value = "{id}",method = RequestMethod.DELETE)
	public void apagarTipoFluxoCaixa(@PathVariable("id") Long id) throws Exception
	{
		this.tipoRepositorio.get(id).deletar();
	}
	

}
