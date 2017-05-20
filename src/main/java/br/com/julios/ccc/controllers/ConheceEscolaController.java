package br.com.julios.ccc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.bd.daos.ConheceEscolaDAO;
import br.com.julios.ccc.infra.dto.ComoConheceuEscolaDTO;

@Controller
@ResponseBody
@RequestMapping("/conhece-escola")
public class ConheceEscolaController {
	@Autowired
	ConheceEscolaDAO conheceEscolaDAO;

	@RequestMapping(method = RequestMethod.GET)
	public List<ComoConheceuEscolaDTO> getconheceEscola() {
		return conheceEscolaDAO.getListaComoConheceu();
	}

}
