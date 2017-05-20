package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.bd.daos.NivelTurmaDAO;
import br.com.julios.ccc.infra.dto.turma.NivelTurmaDTO;

@Controller
@ResponseBody
@RequestMapping("/niveis/turmas")
public class NivelTurmaController {
	
	@Autowired
	NivelTurmaDAO nivelDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<NivelTurmaDTO> getnivelTurma(){
		return nivelDAO.getNiveis();
	}

}
