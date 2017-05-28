package br.com.julios.ccc.negocio.turma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.negocio.funcionario.FuncionarioRepositorio;

@Service
public class TurmaRepositorio {

	@Autowired
	FuncionarioRepositorio funcRep;
	
	public FuncionarioDO getProfessor(Long idFuncionario) throws Exception
	{
		return funcRep.getFuncionario(idFuncionario);
	}
	
}
