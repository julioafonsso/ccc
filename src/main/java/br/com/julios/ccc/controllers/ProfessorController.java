package br.com.julios.ccc.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.componentes.EmailApi;
import br.com.julios.ccc.infra.bd.daos.ComissaoProfessorDAO;
import br.com.julios.ccc.infra.bd.daos.FuncionarioDAO;
import br.com.julios.ccc.infra.bd.daos.TurmaColetivaDAO;
import br.com.julios.ccc.infra.bd.model.ComissaoProfessorDO;
import br.com.julios.ccc.infra.bd.model.FluxoCaixaDO;
import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.bd.model.MesReferenciaDO;
import br.com.julios.ccc.infra.dto.aluno.ConsultaHistoricoPagamentoDTO;
import br.com.julios.ccc.infra.dto.funcionario.CadastroFuncionarioDTO;
import br.com.julios.ccc.infra.dto.funcionario.ConsultaFuncionarioDTO;
import br.com.julios.ccc.infra.dto.funcionario.pagamentos.ConsultaComissaoConsolidadaDTO;
import br.com.julios.ccc.infra.dto.funcionario.pagamentos.ConsultaComissaoDTO;
import br.com.julios.ccc.infra.dto.turma.coletiva.ConsultaTurmaColetivaDTO;
import br.com.julios.ccc.repositorios.FluxoCaixaRepositorio;
import br.com.julios.ccc.repositorios.FuncionarioRepositorio;
import br.com.julios.ccc.repositorios.MesRerefenciaRepositorio;
import br.com.julios.ccc.repositorios.PagamentoFuncionarioRepositorio;

@Controller
@ResponseBody
@Transactional(propagation = Propagation.REQUIRED)
@RequestMapping("/professores")
public class ProfessorController {

	@Autowired
	private FuncionarioDAO funcDAO;

	@Autowired
	private TurmaColetivaDAO turmaColetivaDAO;

	@Autowired
	private FuncionarioRepositorio funcRep;

	@Autowired
	private ComissaoProfessorDAO comissaoDAO;

	@Autowired
	private PagamentoFuncionarioRepositorio comissaoRepositorio;

	@Autowired
	private FluxoCaixaRepositorio pagamentoRepositorio;

	@Autowired
	private MesRerefenciaRepositorio mesRepositorio;

	@Autowired
	private EmailApi email;

	@RequestMapping(method = RequestMethod.GET)
	public List<ConsultaFuncionarioDTO> getProfessores() {
		return funcDAO.getProfessores();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ConsultaFuncionarioDTO cadastrarProfessor(@RequestBody CadastroFuncionarioDTO professor) throws Exception {
		return funcRep.getProfessor(professor).cadastrar();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public ConsultaFuncionarioDTO atualizarProfessor(@RequestBody CadastroFuncionarioDTO professor,
			@PathVariable("id") Long id) throws Exception {
		return funcRep.getFuncionario(id).alterar(professor);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ConsultaFuncionarioDTO getProfessor(@PathVariable("id") Long idProfessor) {
		return funcDAO.getFuncionario(idProfessor);
	}

	@RequestMapping(value = "{id}/turmas", method = RequestMethod.GET)
	public List<ConsultaTurmaColetivaDTO> getTurmas(@PathVariable("id") Long idProfessor) {
		return turmaColetivaDAO.getTurmasDoProfessor(idProfessor);
	}

	@RequestMapping(value = "{id}/salario-pendente/{mes}", method = RequestMethod.GET)
	public List<ConsultaComissaoDTO> getSalarioProfessorPendente(@PathVariable("id") Long idProfessor,
			@PathVariable("mes") String mes) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
		SimpleDateFormat sdfAno = new SimpleDateFormat("yyyy");

		List<ConsultaComissaoDTO> retorno = new ArrayList<ConsultaComissaoDTO>();

		retorno.addAll(comissaoDAO.getComissoesMensalidadePendentes(idProfessor,
				new Long(sdfMes.format(sdf.parse(mes))), new Long(sdfAno.format(sdf.parse(mes)))));

		retorno.addAll(comissaoDAO.getComissoesAulasAvulsasPendentes(idProfessor,
				new Long(sdfMes.format(sdf.parse(mes))), new Long(sdfAno.format(sdf.parse(mes)))));

		retorno.sort(new Comparator<ConsultaComissaoDTO>() {

			@Override
			public int compare(ConsultaComissaoDTO o1, ConsultaComissaoDTO o2) {
				if (o1.getId() < o2.getId())
					return 1;
				else
					return -1;
			}
		});
		return retorno;

	}

	@RequestMapping(value = "{id}/salario/{idSalario}", method = RequestMethod.POST)
	public void cadastrarRecebimento(@PathVariable("id") Long idProfessor, @PathVariable("idSalario") Long idSalario)
			throws Exception {

		FuncionarioDO professor = this.funcRep.getFuncionario(idProfessor);

		List<ComissaoProfessorDO> comissoes = new ArrayList<ComissaoProfessorDO>();

		ComissaoProfessorDO comissao = this.comissaoRepositorio.getComissao(idSalario);

		FluxoCaixaDO pagamento = this.pagamentoRepositorio.getPagamentoComissao(comissao);
		pagamento.cadastrar();

		comissao.efetuarPagamento(pagamento);

		comissoes.add(comissao);

		email.enviarEmailPagametoProfessor(comissoes, pagamento, professor);

	}

	@RequestMapping(value = "{id}/salario-periodo/{mes}", method = RequestMethod.POST)
	public void cadastrarRecebimento(@PathVariable("id") Long idProfessor, @PathVariable("mes") String mes)
			throws Exception {
		FuncionarioDO professor = this.funcRep.getFuncionario(idProfessor);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
		SimpleDateFormat sdfAno = new SimpleDateFormat("yyyy");

		MesReferenciaDO mesDO = this.mesRepositorio.getMes(new Long(sdfMes.format(sdf.parse(mes))),
				new Long(sdfAno.format(sdf.parse(mes))));

		List<ComissaoProfessorDO> comissoes = professor.getComissoesPendentes(mesDO);
		FluxoCaixaDO pagamento = this.pagamentoRepositorio.getPagamentoComissao(mesDO, professor.getNome());

		Double valor = 0.0;
		for (ComissaoProfessorDO comissaoProfessorDO : comissoes) {
			comissaoProfessorDO.efetuarPagamento(pagamento);
			valor += comissaoProfessorDO.getValor();
		}
		pagamento.setValor(valor);
		pagamento.cadastrar();

		email.enviarEmailPagametoProfessor(comissoes, pagamento, professor);
	}

	@RequestMapping(value = "{id}/recibos/{dataInicio}/{dataFim}", method = RequestMethod.GET)
	public List<ConsultaComissaoConsolidadaDTO> getRecibos(@PathVariable("id") Long idProfessor,
			@PathVariable("dataInicio") String dataInicio, @PathVariable("dataFim") String dataFim)
			throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

		Date diaInicio = sdf.parse(dataInicio);
		Date diaFim = sdf.parse(dataFim);

		Calendar c = Calendar.getInstance();
		c.setTime(diaFim);
		c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
		diaFim = c.getTime();

		return this.comissaoDAO.getComissoesRecebidasConsolidada(idProfessor, diaInicio, diaFim);
	}

	@RequestMapping(value = "detalhe-pagamento/{id}", method = RequestMethod.GET)
	public List<ConsultaComissaoDTO> getDetalhePagamento(@PathVariable("id") Long idPagamento) {
		List<ConsultaComissaoDTO> retorno = new ArrayList<>();
		
		retorno.addAll(this.comissaoDAO.getDetalheComissaoMensalidade(idPagamento));
		retorno.addAll(this.comissaoDAO.getDetalheComissaoAulaAvulsa(idPagamento));
		
		return retorno;
	}

	// @RequestMapping(method = RequestMethod.PUT)
	// public void atualizarProfessor(@RequestBody FuncionarioDO professor)
	// throws Exception{
	// }
	//
	// @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	// public void apagarProfessor(@PathVariable("id") Long idProfessor){
	// }
	//

	//
	//
	// @RequestMapping(value = "{id}/recibos/{dataInicio}/{dataFim}", method =
	// RequestMethod.GET)
	// public List<FluxoCaixaDO> getRecibos(@PathVariable("id") Long
	// idProfessor, @PathVariable("dataInicio") String dataInicio,
	// @PathVariable("dataFim") String dataFim) throws ParseException {
	//
	// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
	//
	// Date diaInicio = sdf.parse(dataInicio);
	// Date diaFim = sdf.parse(dataFim);
	//
	// Calendar c = Calendar.getInstance();
	// c.setTime(diaFim);
	// c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
	// diaFim = c.getTime();
	//
	// return null;
	// }
	//
	//
	//
	// @RequestMapping(value = "{id}/salario-pendente/{mes}", method =
	// RequestMethod.GET)
	// public List<PagamentoProfessorDO>
	// getSalarioProfessorPendente(@PathVariable("id") Long idProfessor,
	// @PathVariable("mes") String mes) throws Exception{
	// return null;
	// }

}
