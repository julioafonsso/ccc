package br.com.julios.ccc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.bd.daos.ModalidadeTurmaDAO;
import br.com.julios.ccc.infra.dto.turma.ModalidadeDTO;
import br.com.julios.ccc.negocio.turma.modalidade.ModalidadeTurmaRepositorio;

@Controller
@ResponseBody
@RequestMapping("/modalidades")
public class ModalidadeTurmaController {
	
	@Autowired
	ModalidadeTurmaRepositorio modalidadeRepositorio;
	
	@Autowired
	ModalidadeTurmaDAO modalidadeDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ModalidadeDTO> getmodalidadeTurma()
	{
		return modalidadeDAO.getModalidades();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ModalidadeDTO getdesconto(@PathVariable("id") Long id){
		return this.modalidadeDAO.get(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarModalidade(@RequestBody ModalidadeDTO modalidade) throws Exception
	{
		this.modalidadeRepositorio.get(modalidade).cadastrar();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public void atualizarModalidade(@PathVariable("id") Long id, @RequestBody ModalidadeDTO modalidadeTurma) throws Exception
	{
		this.modalidadeRepositorio.get(id).atualizar(modalidadeTurma);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void apagarModalidade(@PathVariable("id") Long id) throws Exception
	{
		this.modalidadeRepositorio.get(id).deletar();
	}
	

}
