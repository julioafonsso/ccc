package br.com.julios.ccc.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.Util;
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

	public Iterable<Aluno> getAlunos(String nome, String cpf, String email) {
		
		Aluno al = new Aluno();
		
		al.setNome(Util.parametroVazio(nome));
		al.setCpf(Util.parametroVazio(cpf));
		al.setEmail(Util.parametroVazio(email));
		
		Example<Aluno> ex = Example.of(al, ExampleMatcher.
				matching().withIgnoreCase(true).withStringMatcher(StringMatcher.CONTAINING).
				withIgnoreNullValues().withIgnorePaths("id"));
		
		
		return alunoDAO.findAll(ex);
	}

	public Aluno getAluno(Long idAluno) {
		return alunoDAO.findOne(idAluno);	
		
	}
	
}
