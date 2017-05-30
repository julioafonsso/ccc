package br.com.julios.ccc.repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.ComissaoProfessorDAO;
import br.com.julios.ccc.infra.bd.daos.FuncionarioDAO;
import br.com.julios.ccc.infra.bd.daos.MensalidadeDAO;
import br.com.julios.ccc.infra.bd.daos.MesReferenciaDAO;
import br.com.julios.ccc.infra.bd.daos.SalarioDAO;
import br.com.julios.ccc.infra.bd.daos.TipoFuncionarioDAO;
import br.com.julios.ccc.infra.bd.daos.ValeTransporteDAO;
import br.com.julios.ccc.infra.bd.model.ComissaoProfessorDO;
import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.bd.model.MensalidadeDO;
import br.com.julios.ccc.infra.bd.model.MesReferenciaDO;
import br.com.julios.ccc.infra.bd.model.TipoFuncionarioDO;
import br.com.julios.ccc.infra.dto.funcionario.CadastroFuncionarioDTO;

@Service
public class FuncionarioRepositorio {

	@Autowired
	MesReferenciaDAO mesDAO;
	
	@Autowired
	FuncionarioDAO funcDAO;
	
	@Autowired
	SalarioDAO salarioDAO;
	
	@Autowired
	ValeTransporteDAO valeDAO;
	
	@Autowired 
	TipoFuncionarioDAO tipoFuncDAO;
	
	@Autowired
	ComissaoProfessorDAO comissaoDAO;
	
	@Autowired
	MensalidadeDAO mensalidadeDAO;
	
	@Autowired
	MesRerefenciaRepositorio mesRepositorio;
	
	public FuncionarioDO getFuncionario(Long idFuncionario) throws Exception {
		return funcDAO.findOne(idFuncionario);
	}
	
	private FuncionarioDO getFuncionarioGenerico(CadastroFuncionarioDTO cadastro) throws Exception
	{
		FuncionarioDO func = new FuncionarioDO();
		func.setCpf(cadastro.getCpf());
		func.setDataAdmissao(cadastro.getDataAdmissao());
		func.setDataNascimento(cadastro.getDataNascimento());
		func.setEmail(cadastro.getEmail());
		func.setFoto(cadastro.getFoto());
		func.setNome(cadastro.getNome());
		func.setObservacao(cadastro.getObservacao());
		func.setRg(cadastro.getRg());
		func.setSalario(cadastro.getSalario());
		func.setTelefone(cadastro.getTelefone());
		func.setTipoFuncionario(tipoFuncDAO.findOne(cadastro.getIdTipo()));
		func.setValeTransporte(cadastro.getValeTransporte());
		return func;
	}
	
	public FuncionarioDO getProfessor(CadastroFuncionarioDTO cadastro) throws Exception{
		cadastro.setIdTipo(TipoFuncionarioDO.PROFESSOR);
		return getFuncionarioGenerico(cadastro);
		
		
	}
	
	public FuncionarioDO getFuncionario(CadastroFuncionarioDTO cadastro) throws Exception {
		cadastro.setIdTipo(TipoFuncionarioDO.FUNCIONARIO);
		return getFuncionarioGenerico(cadastro);
	}
	
	public void cadastrar(FuncionarioDO funcionario) throws Exception {
		funcDAO.save(funcionario);
	}

	protected Long qtdFuncionarioComCPF(String cpf) {
		return this.funcDAO.countByCpf(cpf);
	}

	protected Long qtdFuncionarioComRG(String rg) {
		return this.funcDAO.countByRg(rg);
	}

	protected Long qtdFuncionarioComEmail(String email) {
		return this.funcDAO.countByEmail(email);
	}

	public ComissaoProfessorDO getComissao(MensalidadeDO mensalidade, FuncionarioDO funcionarioDO) {
		ComissaoProfessorDO comissao = new ComissaoProfessorDO();
		comissao.setFuncionario(funcionarioDO);
		comissao.setMensalidade(mensalidade);
		comissao.setMesReferencia(this.mesRepositorio.getMesAtual());
		return comissao;
	}

	public void cadastrar(ComissaoProfessorDO comissao) {
		this.comissaoDAO.save(comissao);
	}

	public List<ComissaoProfessorDO> getComissoesPendentes(FuncionarioDO funcionarioDO, MesReferenciaDO mes) {
		return this.comissaoDAO.getComissoesPendentes(funcionarioDO, mes);
	}

//
//	protected void criarComissao(Mensalidade mensalidade, MesReferencia mes, Double valor, Funcionario funcionario) throws ParseException, Exception {
//		
//		ComissaoProfessorDO salario = new ComissaoProfessorDO();
//		
//		salario.setFuncionario(funcDAO.findOne(funcionario.getId()));
//		salario.setMesReferencia(mesDAO.findOne(mes.getId()));
//		salario.setValor(valor);
//		salario.setMensalidade(mensalidadeDAO.findOne(mensalidade.getId()));
//		salario.setPercentual(mensalidade.getMatricula().getTurma().getPercentualProfessor(funcionario));
//		comissaoDAO.save(salario);
//		
//		
//	}
//
//	public void criarSalario(Funcionario funcionario, MesReferencia mes) {
//		SalarioDO salario = new SalarioDO();
//		
//		salario.setFuncionario(funcDAO.findOne(funcionario.getId()));
//		salario.setMesReferencia(mesDAO.findOne(mes.getId()));
//		salario.setValor(funcionario.getSalario());
//				
//		salarioDAO.save(salario);
//		
//	}
//	
//	public void criarValeTransporte(Funcionario funcionario, MesReferencia mes) {
//		ValeTransporteDO salario = new ValeTransporteDO();
//		
//		salario.setFuncionario(funcDAO.findOne(funcionario.getId()));
//		salario.setMesReferencia(mesDAO.findOne(mes.getId()));
//		salario.setValor(funcionario.getValeTransporte());
//				
//		valeDAO.save(salario);
//		
//	}

	

	
}


