package br.com.julios.ccc.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.AlunoDAO;
import br.com.julios.ccc.domains.Aluno;

@Service
public class AlunoApi {

	@Autowired
	AlunoDAO alunoDAO;
	
	public void cadastrarAluno(Aluno aluno)
	{
		alunoDAO.save(aluno);
	}

	public Iterable<Aluno> getAlunos() {
		return alunoDAO.findAll();
	}

	public Aluno getAlunoByCPF(String cpf) {
		return alunoDAO.findByCpf(cpf);
	}

	public void atualizarAluno(Aluno aluno) {
		alunoDAO.save(aluno);
	}

	public void apagarAluno(Aluno aluno) {
		alunoDAO.delete(aluno);
	}
	
}
