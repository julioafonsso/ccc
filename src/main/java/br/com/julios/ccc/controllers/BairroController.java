package br.com.julios.ccc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.bd.daos.BairroDAO;
import br.com.julios.ccc.infra.dto.bairro.CadastroBairroDTO;
import br.com.julios.ccc.infra.dto.bairro.ConsultaBairroDTO;
import br.com.julios.ccc.negocio.bairro.BairroRepositorio;

@Controller
@ResponseBody
@RequestMapping("/bairros")
public class BairroController {

	@Autowired
	BairroRepositorio bairroRepositorio;
	
	@Autowired
	BairroDAO bairroDAO;
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarBairro(@RequestBody CadastroBairroDTO bairro) throws Exception {
		bairroRepositorio.getBairro(bairro).cadastrar();
	}
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ConsultaBairroDTO> getBairros() throws Exception {
		return bairroDAO.getBairros();
	}
}
