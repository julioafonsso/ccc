package br.com.julios.ccc.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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

import br.com.julios.ccc.infra.bd.daos.FuncionarioDAO;
import br.com.julios.ccc.infra.bd.daos.SalarioDAO;
import br.com.julios.ccc.infra.bd.daos.TurmaColetivaDAO;
import br.com.julios.ccc.infra.bd.model.FluxoCaixaDO;
import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.bd.model.MesReferenciaDO;
import br.com.julios.ccc.infra.bd.model.SalarioDO;
import br.com.julios.ccc.infra.bd.model.ValeTransporteDO;
import br.com.julios.ccc.infra.dto.funcionario.CadastroFuncionarioDTO;
import br.com.julios.ccc.infra.dto.funcionario.ConsultaFuncionarioDTO;
import br.com.julios.ccc.infra.dto.funcionario.ConsultaRecebimentosDTO;
import br.com.julios.ccc.infra.dto.funcionario.pagamentos.CadastroPagamentoFuncionarioDTO;
import br.com.julios.ccc.infra.dto.funcionario.pagamentos.ConsultaSalarioDTO;
import br.com.julios.ccc.repositorios.FluxoCaixaRepositorio;
import br.com.julios.ccc.repositorios.FuncionarioRepositorio;
import br.com.julios.ccc.repositorios.MesRerefenciaRepositorio;
import br.com.julios.ccc.repositorios.PagamentoFuncionarioRepositorio;

@Controller
@ResponseBody
@Transactional(propagation = Propagation.REQUIRED)
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	FuncionarioDAO funcDAO;

	@Autowired
	TurmaColetivaDAO turmaColetivaDAO;

	@Autowired
	PagamentoFuncionarioRepositorio pagamentoFuncRepositorio;

	@Autowired
	MesRerefenciaRepositorio mesRepositorio;

	@Autowired
	FuncionarioRepositorio funcRep;

	@Autowired
	SalarioDAO salarioDAO;
	
	@Autowired
	FluxoCaixaRepositorio fluxoRepositorio;

	@RequestMapping(method = RequestMethod.GET)
	public List<ConsultaFuncionarioDTO> getProfessores() {
		return funcDAO.getFuncionarios();
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ConsultaFuncionarioDTO getProfessor(@PathVariable("id") Long idProfessor) {
		return funcDAO.getFuncionario(idProfessor);
	}

	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarProfessor(@RequestBody CadastroFuncionarioDTO funcionario) throws Exception {
		FuncionarioDO func = funcRep.getFuncionario(funcionario);
		func.cadastrar();

		SalarioDO salario = this.pagamentoFuncRepositorio.getSalario(func, this.mesRepositorio.getMesAtual());
		salario.cadastrar();

		ValeTransporteDO valeTrans = this.pagamentoFuncRepositorio.getValeTransporte(func,
				this.mesRepositorio.getMesAtual());
		valeTrans.cadastrar();

	}

	@RequestMapping(value = "{id}/salario/{mes}", method = RequestMethod.GET)
	public List<ConsultaSalarioDTO> getSalario(@PathVariable("id") Long idProfessor, @PathVariable("mes") String mes)
			throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
		SimpleDateFormat sdfAno = new SimpleDateFormat("yyyy");

		MesReferenciaDO mesDO = this.mesRepositorio.getMes(new Long(sdfMes.format(sdf.parse(mes))),
				new Long(sdfAno.format(sdf.parse(mes))));
		return this.salarioDAO.getSalarios(idProfessor, mesDO);
	}

	@RequestMapping(value = "{id}/valetransporte/{mes}", method = RequestMethod.GET)
	public ConsultaSalarioDTO getVale(@PathVariable("id") Long idProfessor, @PathVariable("mes") String mes)
			throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat sdfMes = new SimpleDateFormat("MM");
		SimpleDateFormat sdfAno = new SimpleDateFormat("yyyy");

		MesReferenciaDO mesDO = this.mesRepositorio.getMes(new Long(sdfMes.format(sdf.parse(mes))),
				new Long(sdfAno.format(sdf.parse(mes))));
		return this.salarioDAO.getVale(idProfessor, mesDO);
	}
	
	

	
	@RequestMapping(value = "{id}/salario/{idSalario}", method = RequestMethod.POST)
	public void pagarSalario(@PathVariable("id") Long idProfessor, @PathVariable("idSalario") Long idSalario, @RequestBody CadastroPagamentoFuncionarioDTO cadastro)
			throws Exception {

		SalarioDO salario = this.pagamentoFuncRepositorio.getSalario(idSalario);
		FluxoCaixaDO pagamento = this.fluxoRepositorio.getPagamentoSalario(salario, cadastro.getValor());
		
		salario.efetuarPagamento(pagamento);
		pagamento.cadastrar();
		SalarioDO  novoSalario = this.pagamentoFuncRepositorio.getSalario(salario);
		novoSalario.cadastrar();
		
	}
	
	@RequestMapping(value = "{id}/valetransporte/{idVale}", method = RequestMethod.POST)
	public void pagarSalario(@PathVariable("id") Long idProfessor, @PathVariable("idVale") Long idVale)
			throws Exception {

		ValeTransporteDO vale = this.pagamentoFuncRepositorio.getValeTransporte(idVale);
		FluxoCaixaDO pagamento = this.fluxoRepositorio.getPagamentoSalario(vale, vale.getValor());
		
		vale.efetuarPagamento(pagamento);
		pagamento.cadastrar();
		ValeTransporteDO  novoSalario = this.pagamentoFuncRepositorio.getVale(vale);
		novoSalario.cadastrar();
		
	}
	
	@RequestMapping(value = "{id}/recebimento/{dataInicio}/{dataFim}", method = RequestMethod.GET)
	public List<ConsultaRecebimentosDTO> getPagamentos(@PathVariable("id") Long idFunc,
			@PathVariable("dataInicio") String dataInicio, @PathVariable("dataFim") String dataFim) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");

		Date diaInicio = sdf.parse(dataInicio);
		Date diaFim = sdf.parse(dataFim);

		Calendar c = Calendar.getInstance();
		c.setTime(diaFim);
		c.add(Calendar.DATE, c.getActualMaximum(Calendar.DAY_OF_MONTH) - 1);
		diaFim = c.getTime();

				
		return this.pagamentoFuncRepositorio.getRecebimentos(idFunc, diaInicio, diaFim);
	}
	
	
}
