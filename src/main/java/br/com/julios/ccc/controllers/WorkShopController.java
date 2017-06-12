package br.com.julios.ccc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.bd.daos.MatriculaDAO;
import br.com.julios.ccc.infra.bd.daos.WorkShopDAO;
import br.com.julios.ccc.infra.dto.matricula.ConsultaAlunosMatriculadosDTO;
import br.com.julios.ccc.infra.dto.turma.workshop.CadastroWorkShopDTO;
import br.com.julios.ccc.infra.dto.turma.workshop.ConsultaWorkShopDTO;
import br.com.julios.ccc.repositorios.WorkShopRepositorio;

@Controller
@ResponseBody
@RequestMapping("/workshop")
public class WorkShopController {

	@Autowired
	WorkShopRepositorio workShopRepositorio;
	
	@Autowired
	WorkShopDAO workDAO;
	
	@Autowired
	MatriculaDAO mDAO;
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarTurma(@RequestBody CadastroWorkShopDTO turma) throws Exception{
		workShopRepositorio.get(turma).cadastrar();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ConsultaWorkShopDTO> getTurmas(){
		return workDAO.getTurmas();
	}
	
	@RequestMapping(value = "{id}", method= RequestMethod.GET)
	public ConsultaWorkShopDTO getTurma(@PathVariable("id") Long id)
	{
		return this.workDAO.get(id);
	}
	
	@RequestMapping(value = "{id}", method= RequestMethod.PUT)
	public void alterar(@RequestBody CadastroWorkShopDTO turma, @PathVariable("id") Long id) throws Exception{
		workShopRepositorio.get(id).alterar(turma);
	}
	

	@RequestMapping(value = "{id}/alunos", method = RequestMethod.GET)
	public List<ConsultaAlunosMatriculadosDTO> getAluno(@PathVariable("id") Long idTurma) {
		return mDAO.getAlunosMatriculados(idTurma);
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
