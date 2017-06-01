package br.com.julios.ccc.controllers;

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
import br.com.julios.ccc.infra.bd.daos.TurmaColetivaDAO;
import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.bd.model.SalarioDO;
import br.com.julios.ccc.infra.bd.model.ValeTransporteDO;
import br.com.julios.ccc.infra.dto.funcionario.CadastroFuncionarioDTO;
import br.com.julios.ccc.infra.dto.funcionario.ConsultaFuncionarioDTO;
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
	
	@RequestMapping(method = RequestMethod.GET)
	public List<ConsultaFuncionarioDTO> getProfessores(){
		return funcDAO.getFuncionarios();
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	public ConsultaFuncionarioDTO getProfessor(@PathVariable("id") Long idProfessor){
		return funcDAO.getFuncionario(idProfessor);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void cadastrarProfessor(@RequestBody CadastroFuncionarioDTO funcionario) throws Exception{
		FuncionarioDO func = funcRep.getFuncionario(funcionario);
		func.cadastrar();
		
		SalarioDO salario = this.pagamentoFuncRepositorio.getSalario(func, this.mesRepositorio.getMesAtual());
		salario.cadastrar();
		
		ValeTransporteDO valeTrans = this.pagamentoFuncRepositorio.getValeTransporte(func, this.mesRepositorio.getMesAtual());
		valeTrans.cadastrar();
		
	}
	
	@RequestMapping(value = "{id}/salario", method = RequestMethod.GET)
	public ConsultaFuncionarioDTO getSalario(@PathVariable("id") Long idProfessor){
		return funcDAO.getFuncionario(idProfessor);
	}
	
}
