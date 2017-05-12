package br.com.julios.ccc.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.bd.daos.FuncionarioDAO;
import br.com.julios.ccc.infra.bd.daos.TurmaColetivaDAO;
import br.com.julios.ccc.infra.bd.model.FluxoCaixaDO;
import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.bd.model.PagamentoProfessorDO;
import br.com.julios.ccc.infra.dto.funcionario.cadastro.CadastroFuncionario;
import br.com.julios.ccc.infra.dto.funcionario.consulta.ConsultaFuncionario;
import br.com.julios.ccc.infra.dto.turma.consulta.ConsultaTurma;

@Controller
@ResponseBody
@RequestMapping("/professores")
public class ProfessorController {

	@Autowired
	FuncionarioDAO funcDAO;
	
	@Autowired
	TurmaColetivaDAO turmaColetivaDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ConsultaFuncionario> getProfessores(){
		return funcDAO.getProfessores();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarProfessor(@RequestBody CadastroFuncionario professor) throws Exception{
		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarProfessor(@RequestBody FuncionarioDO professor) throws Exception{
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void apagarProfessor(@PathVariable("id") Long idProfessor){
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ConsultaFuncionario getProfessor(@PathVariable("id") Long idProfessor){
		return funcDAO.getProfessor(idProfessor);
	}
	
	@RequestMapping(value = "detalhe-pagamento/{id}", method = RequestMethod.GET)
	public List<PagamentoProfessorDO> getDetalhePagamento(@PathVariable("id") Long idProfessor){
		return null;
	}
	
	@RequestMapping(value = "{id}/turmas-coletivas", method = RequestMethod.GET)
	public List<ConsultaTurma> getTurmas(@PathVariable("id") Long idProfessor) {
		return turmaColetivaDAO.getTurmasDoProfessor(idProfessor);
	}
	
	@RequestMapping(value = "{id}/recibos/{dataInicio}/{dataFim}", method = RequestMethod.GET)
	public List<FluxoCaixaDO> getRecibos(@PathVariable("id") Long idProfessor, @PathVariable("dataInicio") String dataInicio, @PathVariable("dataFim") String dataFim) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		
		Date diaInicio = sdf.parse(dataInicio);
		Date diaFim = sdf.parse(dataFim);
		
		Calendar c = Calendar.getInstance();
		c.setTime(diaFim);
		c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
		diaFim = c.getTime();
		
		return null;
	}
	
	@RequestMapping(value = "{id}/salario-periodo/{mes}", method = RequestMethod.POST)
	public void cadastrarRecebimento(@PathVariable("id") Long idProfessor, @PathVariable("mes") String mes) throws Exception{
	}
	
	@RequestMapping(value = "{id}/salario/{idSalario}", method = RequestMethod.POST)
	public void cadastrarRecebimento(@PathVariable("id") Long idProfessor, @PathVariable("idSalario") Long idSalario) throws Exception{
	}
	
	@RequestMapping(value = "{id}/salario-pendente/{mes}", method = RequestMethod.GET)
	public List<PagamentoProfessorDO> getSalarioProfessorPendente(@PathVariable("id") Long idProfessor, @PathVariable("mes") String mes) throws Exception{
		return null;		
	}

}
