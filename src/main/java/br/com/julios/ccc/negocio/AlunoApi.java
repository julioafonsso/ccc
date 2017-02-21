package br.com.julios.ccc.negocio;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.AlunoDAO;
import br.com.julios.ccc.daos.MesReferenciaDAO;
import br.com.julios.ccc.domains.Aluno;
import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.util.Util;

@Service
public class AlunoApi {

	@Autowired
	AlunoDAO alunoDAO;

	@Autowired
	MesReferenciaDAO mesReferenciaDAO;

	public void cadastrarAluno(Aluno aluno) throws Exception {
		aluno.setFoto("imagens" + "/" + aluno.getFoto());
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

	public Iterable<Aluno> getAlunos(String nome, String cpf, String email) throws Exception {

		Aluno al = new Aluno();

		al.setNome(Util.parametroVazio(nome));
		al.setCpf(Util.parametroVazio(cpf));
		al.setEmail(Util.parametroVazio(email));

		Example<Aluno> ex = Example.of(al, ExampleMatcher.matching().withIgnoreCase(true)
				.withStringMatcher(StringMatcher.CONTAINING).withIgnoreNullValues().withIgnorePaths("id"));

		return alunoDAO.findAll(ex);
	}

	public Aluno getAluno(Long idAluno) {
		return alunoDAO.findOne(idAluno);

	}

	public List<Matricula> getMatriculas(Long idAluno) {
		Aluno a = alunoDAO.findOne(idAluno);
		return a.getMatriculas();
	}

}
