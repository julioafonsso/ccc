package br.com.julios.ccc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.bd.daos.EstadoCivilDAO;
import br.com.julios.ccc.infra.dto.EstadoCivilDTO;

@Controller
@ResponseBody
@RequestMapping("/estado-civil")
public class EstadoCivilController {
	
	@Autowired
	EstadoCivilDAO estadoDAO;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<EstadoCivilDTO> getestadoCivil(){
		return estadoDAO.getEstadoCivil();
		
	}

}
