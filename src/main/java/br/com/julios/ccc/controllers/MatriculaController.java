package br.com.julios.ccc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.dto.matricula.CadastroMatriculaDTO;
import br.com.julios.ccc.negocio.matricula.MatriculaRepositorio;

@Controller
@ResponseBody
@Transactional(propagation = Propagation.REQUIRED)
@RequestMapping("/matriculas")
public class MatriculaController {
	
	@Autowired
	MatriculaRepositorio matriculaRepositorio;
	
	@RequestMapping(method = RequestMethod.POST)
	public void matricular(@RequestBody CadastroMatriculaDTO cadastro) throws Exception{
		matriculaRepositorio.getMatricula(cadastro).cadastrar();
	}

}
