package br.com.julios.ccc.negocio.funcionario;

import java.text.ParseException;

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
import br.com.julios.ccc.infra.bd.model.SalarioDO;
import br.com.julios.ccc.infra.bd.model.TipoFuncionarioDO;
import br.com.julios.ccc.infra.bd.model.ValeTransporteDO;
import br.com.julios.ccc.infra.dto.funcionario.CadastroFuncionarioDTO;
import br.com.julios.ccc.negocio.mensalidade.Mensalidade;
import br.com.julios.ccc.negocio.mes.MesReferencia;
import br.com.julios.ccc.negocio.mes.MesRerefenciaRepositorio;

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
	
	public Funcionario getFuncionario(Long idFuncionario) throws Exception {
		FuncionarioDO funcDO = funcDAO.findOne(idFuncionario);
		CadastroFuncionarioDTO funcionarioDTO = new CadastroFuncionarioDTO();
		funcionarioDTO.setCpf(funcDO.getCpf());
		funcionarioDTO.setDataAdmissao(funcDO.getDataAdmissao());
		funcionarioDTO.setDataNascimento(funcDO.getDataNascimento());
		funcionarioDTO.setEmail(funcDO.getEmail());
		funcionarioDTO.setFoto(funcDO.getFoto());
		funcionarioDTO.setId(funcDO.getId());
		funcionarioDTO.setNome(funcDO.getNome());
		funcionarioDTO.setObservacao(funcDO.getObservacao());
		funcionarioDTO.setRg(funcDO.getRg());
		funcionarioDTO.setTelefone(funcDO.getTelefone());
		funcionarioDTO.setIdTipo(funcDO.getTipoFuncionario().getId());
		return getProfessor(funcionarioDTO);
	}
	
	public Funcionario getProfessor(CadastroFuncionarioDTO funcionarioDTO){
		funcionarioDTO.setIdTipo(TipoFuncionarioDO.PROFESSOR);
		return  new Funcionario(this, funcionarioDTO);
		
	}
	
	public Funcionario getFuncionario(CadastroFuncionarioDTO funcionarioDTO) {
		funcionarioDTO.setIdTipo(TipoFuncionarioDO.FUNCIONARIO);
		return  new Funcionario(this, funcionarioDTO);
	}
	
	protected void cadastrar(Funcionario funcionario) throws Exception {
		FuncionarioDO func = new FuncionarioDO();
		func.setCpf(funcionario.getCpf());
		func.setDataAdmissao(funcionario.getDataAdmissao());
		func.setDataNascimento(funcionario.getDataNascimento());
		func.setEmail(funcionario.getEmail());
		func.setFoto(funcionario.getFoto());
		func.setId(funcionario.getId());
		func.setObservacao(funcionario.getObservacao());
		func.setRg(funcionario.getRg());
		func.setTelefone(funcionario.getTelefone());
		func.setTipoFuncionario(tipoFuncDAO.findOne(funcionario.getTipo()));
		func.setNome(funcionario.getNome());
		func.setSalario(funcionario.getSalario());
		func.setValeTransporte(funcionario.getValeTransporte());
		funcDAO.save(func);
		
		funcionario.setId(func.getId());
		
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

	protected MesReferencia getMesAtual() {
		return mesRepositorio.getMesAtual();
	}

	protected void criarComissao(Mensalidade mensalidade, MesReferencia mes, Double valor, Funcionario funcionario) throws ParseException, Exception {
		
		ComissaoProfessorDO salario = new ComissaoProfessorDO();
		
		salario.setFuncionario(funcDAO.findOne(funcionario.getId()));
		salario.setMesReferencia(mesDAO.findOne(mes.getId()));
		salario.setValor(valor);
		salario.setMensalidade(mensalidadeDAO.findOne(mensalidade.getId()));
		salario.setPercentual(mensalidade.getMatricula().getTurma().getPercentualProfessor(funcionario));
		comissaoDAO.save(salario);
		
		
	}

	public void criarSalario(Funcionario funcionario, MesReferencia mes) {
		SalarioDO salario = new SalarioDO();
		
		salario.setFuncionario(funcDAO.findOne(funcionario.getId()));
		salario.setMesReferencia(mesDAO.findOne(mes.getId()));
		salario.setValor(funcionario.getSalario());
				
		salarioDAO.save(salario);
		
	}
	
	public void criarValeTransporte(Funcionario funcionario, MesReferencia mes) {
		ValeTransporteDO salario = new ValeTransporteDO();
		
		salario.setFuncionario(funcDAO.findOne(funcionario.getId()));
		salario.setMesReferencia(mesDAO.findOne(mes.getId()));
		salario.setValor(funcionario.getValeTransporte());
				
		valeDAO.save(salario);
		
	}

	

	
}
