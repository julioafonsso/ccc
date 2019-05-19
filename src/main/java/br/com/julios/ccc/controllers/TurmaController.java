package br.com.julios.ccc.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.Excel;
import br.com.julios.ccc.infra.bd.daos.MatriculaDAO;
import br.com.julios.ccc.infra.bd.daos.MensalidadeDAO;
import br.com.julios.ccc.infra.bd.daos.TurmaColetivaDAO;
import br.com.julios.ccc.infra.bd.model.MatriculaDO;
import br.com.julios.ccc.infra.bd.model.MensalidadeDO;
import br.com.julios.ccc.infra.bd.model.TurmaColetivaDO;
import br.com.julios.ccc.infra.dto.matricula.ConsultaAlunosMatriculadosDTO;
import br.com.julios.ccc.infra.dto.matricula.ConsultaAlunosMatriculadosTurmaExcluidaDTO;
import br.com.julios.ccc.infra.dto.turma.coletiva.CadastroTurmaColetivaDTO;
import br.com.julios.ccc.infra.dto.turma.coletiva.ConsultaHistoricoPagamentoTurmaDTO;
import br.com.julios.ccc.infra.dto.turma.coletiva.ConsultaTurmaColetivaDTO;
import br.com.julios.ccc.infra.dto.turma.coletiva.ConsultaTurmaColetivaExcluidasDTO;
import br.com.julios.ccc.repositorios.MesRerefenciaRepositorio;
import br.com.julios.ccc.repositorios.TurmaColetivaRepositorio;

@Controller
@ResponseBody
@Transactional(propagation = Propagation.REQUIRED)
@RequestMapping("/turmas")
public class TurmaController {

	@Autowired
	TurmaColetivaRepositorio turmaRepositorio;

	@Autowired
	TurmaColetivaDAO turmaDAO;

	@Autowired
	MatriculaDAO mDAO;

	@Autowired
	MesRerefenciaRepositorio mes;

	@Autowired
	MensalidadeDAO mensalidadeDAO;

	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarTurma(@RequestBody CadastroTurmaColetivaDTO turma) throws Exception {
		turmaRepositorio.getTurma(turma).cadastrar();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public void alterarTurma(@RequestBody CadastroTurmaColetivaDTO turma, @PathVariable("id") Long id)
			throws Exception {
		TurmaColetivaDO turmaDO = turmaRepositorio.getTurma(id);

		turmaDO.alterar(turma);
		List<MatriculaDO> matriculas = this.mDAO.getMatriculas(turmaDO);
		
		Date hoje = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(hoje);
				cal.set(Calendar.DAY_OF_MONTH,
				cal.getActualMinimum(Calendar.DAY_OF_MONTH));
				
				Date primeiroDiaMes = cal.getTime();
		
		for (MatriculaDO matriculaDO : matriculas) {
			List<MensalidadeDO> mensalidades = this.mensalidadeDAO.getMensalidadesFuturas(matriculaDO, primeiroDiaMes);
			for (MensalidadeDO mensalidadeDO : mensalidades) {
				mensalidadeDO.recalcular();
			}
		}
	}

	@RequestMapping(value="excluidas", method = RequestMethod.GET)
	public List<ConsultaTurmaColetivaExcluidasDTO> getTurmas() {
		return turmaDAO.getTurmasExcluidas();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ConsultaTurmaColetivaDTO> getTurmasExcluidas() {
		return turmaDAO.getTurmas();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ConsultaTurmaColetivaDTO getTurma(@PathVariable("id") Long id) {
		return turmaDAO.getTurma(id);
	}

	@RequestMapping(value = "{id}/alunos", method = RequestMethod.GET)
	public List<ConsultaAlunosMatriculadosDTO> getAluno(@PathVariable("id") Long idTurma) {
		return mDAO.getAlunosMatriculados(idTurma);
	}

	@RequestMapping(value = "excluidas/{id}/alunos", method = RequestMethod.GET)
	public List<ConsultaAlunosMatriculadosTurmaExcluidaDTO> getAlunosTurmaExcluidas(@PathVariable("id") Long idTurma) {
		return mDAO.getAlunosMatriculadosTurmaExcluida(idTurma);
	}
	
	@RequestMapping(value = "{id}/lista-presenca", method = RequestMethod.GET)
	public String getListaPresenca(@PathVariable("id") Long idTurma) throws Exception {
		Excel excel = new Excel();

		TurmaColetivaDO turma = this.turmaRepositorio.getTurma(idTurma);

		return DatatypeConverter.printBase64Binary(excel.getLista(turma, mes.getMesAtual()));

	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void apagarTurma(@PathVariable("id") long id) throws Exception {
		turmaRepositorio.getTurma(id).excluir();
	}
	
	@RequestMapping(value = "{id}/pagamentos/{dataInicio}/{dataFim}", method = RequestMethod.GET)
	public List<ConsultaHistoricoPagamentoTurmaDTO> getPagamentos(@PathVariable("id") Long id,
			@PathVariable("dataInicio") String dataInicio, @PathVariable("dataFim") String dataFim) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

		Date diaInicio = sdf.parse(dataInicio);
		Date diaFim = sdf.parse(dataFim);

		Calendar c = Calendar.getInstance();
		c.setTime(diaFim);
		c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
		diaFim = c.getTime();
		
		return turmaDAO.getMensalidadesPagas(id, diaInicio, diaFim);
	}

}
