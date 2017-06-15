package br.com.julios.ccc.controllers;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.bd.daos.MatriculaDAO;
import br.com.julios.ccc.infra.bd.daos.TurmaColetivaDAO;
import br.com.julios.ccc.infra.bd.model.TurmaColetivaDO;
import br.com.julios.ccc.infra.dto.matricula.ConsultaAlunosMatriculadosDTO;
import br.com.julios.ccc.infra.dto.matricula.ConsultaListaPresencaDTO;
import br.com.julios.ccc.infra.dto.turma.coletiva.CadastroTurmaColetivaDTO;
import br.com.julios.ccc.infra.dto.turma.coletiva.ConsultaTurmaColetivaDTO;
import br.com.julios.ccc.repositorios.TurmaColetivaRepositorio;

@Controller
@ResponseBody
@RequestMapping("/turmas")
public class TurmaController {

	@Autowired
	TurmaColetivaRepositorio turmaRepositorio;
	
	@Autowired
	TurmaColetivaDAO turmaDAO;
	
	@Autowired
	MatriculaDAO mDAO;
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarTurma(@RequestBody CadastroTurmaColetivaDTO turma) throws Exception{
		turmaRepositorio.getTurma(turma).cadastrar();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public void alterarTurma(@RequestBody CadastroTurmaColetivaDTO turma, @PathVariable("id") Long id) throws Exception{
		turmaRepositorio.getTurma(id).alterar(turma);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ConsultaTurmaColetivaDTO> getTurmas(){
		return turmaDAO.getTurmas();
	}
	
	@RequestMapping(value = "{id}", method= RequestMethod.GET)
	public ConsultaTurmaColetivaDTO getTurma(@PathVariable("id") Long id)
	{
		return turmaDAO.getTurma(id);
	}
	
	@RequestMapping(value = "{id}/alunos", method = RequestMethod.GET)
	public List<ConsultaAlunosMatriculadosDTO> getAluno(@PathVariable("id") Long idTurma) {
		return mDAO.getAlunosMatriculados(idTurma);
	}
	
	@RequestMapping(value = "{id}/dias", method = RequestMethod.GET)
	public List<Date> getListaPresenca(@PathVariable("id") Long idTurma) throws ParseException {
		TurmaColetivaDO turma = this.turmaRepositorio.getTurma(idTurma);
		
		return turma.getDiasAulaMes(this.turmaRepositorio.getMesAtual());
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
