package br.com.julios.ccc.negocio.funcionario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.FuncionarioDAO;
import br.com.julios.ccc.infra.bd.daos.TipoFuncionarioDAO;
import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.bd.model.TipoFuncionarioDO;
import br.com.julios.ccc.infra.dto.funcionario.CadastroFuncionarioDTO;

@Service
public class FuncionarioRepositorio {

	@Autowired
	FuncionarioDAO funcDAO;
	
	@Autowired 
	TipoFuncionarioDAO tipoFuncDAO;
	
	public Funcionario getProfessor(CadastroFuncionarioDTO funcionarioDTO){
		Funcionario funcionario = new Funcionario(this);
		funcionario.setNome(funcionarioDTO.getNome());
		funcionario.setCpf(funcionarioDTO.getCpf());
		funcionario.setDataAdmissao(funcionarioDTO.getdataAdmissao());
		funcionario.setDataNascimento(funcionarioDTO.getDataNascimento());
		funcionario.setEmail(funcionarioDTO.getEmail());
		funcionario.setFoto(funcionarioDTO.getFoto());
		funcionario.setId(funcionarioDTO.getId());
		funcionario.setObservacao(funcionarioDTO.getObservacao());
		funcionario.setRg(funcionarioDTO.getRg());
		funcionario.setTelefone(funcionarioDTO.getTelefone());
		funcionario.setTipo(TipoFuncionarioDO.PROFESSOR);
		return funcionario;
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
		funcDAO.save(func);
		
	}

	public Long qtdFuncionarioComCPF(String cpf) {
		return this.funcDAO.countByCpf(cpf);
	}

	public Long qtdFuncionarioComRG(String rg) {
		return this.funcDAO.countByRg(rg);
	}

	public Long qtdFuncionarioComEmail(String email) {
		return this.funcDAO.countByEmail(email);
	}
}
