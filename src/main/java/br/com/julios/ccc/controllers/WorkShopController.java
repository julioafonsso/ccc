package br.com.julios.ccc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.bd.daos.WorkShopDAO;
import br.com.julios.ccc.infra.dto.turma.coletiva.ConsultaTurmaColetivaDTO;
import br.com.julios.ccc.infra.dto.turma.workshop.CadastroWorkShopDTO;
import br.com.julios.ccc.infra.dto.turma.workshop.ConsultaWorkShopDTO;
import br.com.julios.ccc.negocio.turma.workshop.WorkShopRepositorio;

@Controller
@ResponseBody
@RequestMapping("/workshop")
public class WorkShopController {

	@Autowired
	WorkShopRepositorio workShopRepositorio;
	
	@Autowired
	WorkShopDAO workDAO;
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarTurma(@RequestBody CadastroWorkShopDTO turma) throws Exception{
		workShopRepositorio.get(turma).cadastrar();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ConsultaWorkShopDTO> getTurmas(){
		return workDAO.getTurmas();
	}
	
	@RequestMapping(value = "{id}", method= RequestMethod.GET)
	public ConsultaTurmaColetivaDTO getTurma(@PathVariable("id") Long id)
	{
		return null;
	}
	
	
//	@Autowired
//	TurmaFacade turmaFacade;
//	
//	@Autowired 
//	MatriculaFacade matriculaFacade;
	
//	
//
//	@RequestMapping(value="{id}/alunos" ,method = RequestMethod.GET)
//	public Iterable<MatriculaDO> getAlunos(@PathVariable("id") Long idTurma){
//		return null;
//	}
//
//	

//	
//	
//	
//	@RequestMapping(value = "matricula", method = RequestMethod.POST)
//	public void matricularAluno(@RequestBody MatriculaDO matricula) throws Exception{
//	}
//	
//	@RequestMapping(method = RequestMethod.PUT)
//	public void atualizarTurma(@RequestBody TurmaDO turma) throws Exception{
//	}
//	
//	@RequestMapping(value="{id}" , method = RequestMethod.DELETE)
//	public void apagarTurma(@PathVariable("id") long id) throws Exception{
//	}
//	
//	@RequestMapping(value="matricula/{id}/desconto" , method = RequestMethod.DELETE)
//	public void apagarDesconto(@PathVariable("id") long id) throws Exception{
//	}
//
//	@RequestMapping(value="matricula/{id}/desconto/{idDesconto}" , method = RequestMethod.PUT)
//	public void alterarDesconto(@PathVariable("id") long id, @PathVariable("idDesconto") long idDesconto) throws Exception{
//	}
//	
//	@RequestMapping(value="matricula/{id}" , method = RequestMethod.DELETE)
//	public void excluirMatricula(@PathVariable("id") long id) throws ParseException{
//	}
}