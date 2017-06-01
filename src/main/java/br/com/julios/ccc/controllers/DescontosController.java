	package br.com.julios.ccc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.bd.daos.DescontoDAO;
import br.com.julios.ccc.infra.dto.DescontoDTO;
import br.com.julios.ccc.repositorios.DescontoRepositorio;

@Controller
@ResponseBody
@RequestMapping("/descontos")
public class DescontosController {
	
	@Autowired
	DescontoDAO descontoDAO;
	
	@Autowired
	DescontoRepositorio descontoRepositorio;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<DescontoDTO> getdescontos(){
		return descontoDAO.getDescontos();
	}	
	
	
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public DescontoDTO getdesconto(@PathVariable("id") Long id){
		return descontoDAO.getDescontos(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarDesconto(@RequestBody DescontoDTO desconto) throws Exception{
		descontoRepositorio.getDesconto(desconto).cadastrar();
	}
	
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public void altearrDesconto(@PathVariable("id") Long id, @RequestBody DescontoDTO desconto) throws Exception{
		this.descontoRepositorio.getDesconto(id).alterar(desconto);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable("id") Long id) throws Exception{
		this.descontoRepositorio.getDesconto(id).deletar();
	}
}
