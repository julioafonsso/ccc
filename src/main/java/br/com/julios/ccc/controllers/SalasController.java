package br.com.julios.ccc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.bd.daos.SalaDAO;
import br.com.julios.ccc.infra.dto.turma.SalaDTO;

@Controller
@ResponseBody
@RequestMapping("/salas")
public class SalasController {
	
	@Autowired
	SalaDAO salaDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<SalaDTO> getsala(){
		return salaDAO.getSalas();
	}

}
