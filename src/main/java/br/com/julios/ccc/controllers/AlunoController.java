package br.com.julios.ccc.controllers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.facade.AlunoFacade;
import br.com.julios.ccc.facade.FtpFacade;
import br.com.julios.ccc.infra.bd.model.AlunoDO;
import br.com.julios.ccc.infra.bd.model.AulaParticularDO;
import br.com.julios.ccc.infra.bd.model.MatriculaDO;
import br.com.julios.ccc.infra.bd.model.MensalidadeDO;

@Controller
@ResponseBody
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	AlunoFacade alunoFacade;

	@Autowired
	FtpFacade fileFacade;

//
//	@Autowired
//	private HttpServletRequest http;

	@RequestMapping(method = RequestMethod.GET)
	public Iterable<AlunoDO> getAlunos(@RequestParam(value = "nome", required = false) String nome,
			@RequestParam(value = "cpf", required = false) String cpf,
			@RequestParam(value = "email", required = false) String email) throws Exception {

		return null;
	}

	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarAluno(@RequestBody AlunoDO aluno) throws Exception {
	}

	

	@RequestMapping(method = RequestMethod.PUT)
	public void atualizarAluno(@RequestBody AlunoDO aluno) throws Exception {
	}

	@RequestMapping(method = RequestMethod.DELETE)
	public void apagarAluno(AlunoDO aluno) {
	}

	@RequestMapping(value = "pagamento", method = RequestMethod.POST)
	public void efetuarPagamento(@RequestBody MensalidadeDO mensalidade) throws Exception {
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public AlunoDO getAluno(@PathVariable("id") Long idAluno) {
		return null;
	}

	@RequestMapping(value = "{id}/pagamentos/{dataInicio}/{dataFim}", method = RequestMethod.GET)
	public List<MensalidadeDO> getPagamentos(@PathVariable("id") Long idAluno, @PathVariable("dataInicio") String dataInicio, @PathVariable("dataFim") String dataFim) throws Exception {
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		
		Date diaInicio = sdf.parse(dataInicio);
		Date diaFim = sdf.parse(dataFim);
		
		Calendar c = Calendar.getInstance();
		c.setTime(diaFim);
		c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
		diaFim = c.getTime();

		
//		return alunoFacade.getPagamentos(idAluno, diaInicio, diaFim);
		return null;
	}
	
	@RequestMapping(value = "{id}/turmas", method = RequestMethod.GET)
	public List<MatriculaDO> getTurmas(@PathVariable("id") Long idAluno) {
		return null;
	}

	@RequestMapping(value = "{id}/debitos", method = RequestMethod.GET)
	public List<MensalidadeDO> getDebitos(@PathVariable("id") Long idAluno) throws Exception {
		return null;
	}
	
	@RequestMapping(value = "{id}/aula-particular", method = RequestMethod.POST)
	public void cadastrarAulaParticular(@PathVariable("id") Long idAluno, @RequestBody AulaParticularDO aula) throws Exception {
		
	}
	
	@RequestMapping(value = "{id}/aula-particular/{dataInicio}/{dataFim}", method = RequestMethod.GET)
	public List<MensalidadeDO> consultarAulaParticular(@PathVariable("id") Long idAluno, @PathVariable("dataInicio") String dataInicio, @PathVariable("dataFim") String dataFim) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		
		Date diaInicio = sdf.parse(dataInicio);
		Date diaFim = sdf.parse(dataFim);
		
		Calendar c = Calendar.getInstance();
		c.setTime(diaFim);
		c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
		diaFim = c.getTime();
		
		return null;
	}
	


}
