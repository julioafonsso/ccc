package br.com.julios.ccc.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.componentes.cpf.CPFValidador;
import br.com.julios.ccc.daos.AlunoDAO;
import br.com.julios.ccc.daos.MensalidadesDAO;
import br.com.julios.ccc.domains.Aluno;
import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.Mensalidades;
import br.com.julios.ccc.domains.MesReferencia;
import br.com.julios.ccc.util.Util;

@Service
public class AlunoApi {

	@Autowired
	AlunoDAO alunoDAO;

	@Autowired
	MesApi mesApi;

	@Autowired
	MensalidadesDAO mensalidadeDAO;

	@Autowired
	MatriculaApi matriculaApi;

	public void cadastrarAluno(Aluno aluno) throws Exception {
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

	public List<Mensalidades> getMensalidadesParaPagar(Aluno aluno) {

		return mensalidadeDAO.getMensalidadesParaPagar(aluno);
	}

	public void validaCPF(Aluno aluno) throws Exception {
		CPFValidador cpfV = new CPFValidador();
		if(!cpfV.isValid(aluno.getCpf(), null))
			throw new Exception("CPF Invalido!");
		Aluno a = alunoDAO.findByCpf(aluno.getCpfSemFormat());
		if (a != null) {
			throw new Exception("CPF já cadastrado!");
		}

	}

	public void validaEmail(Aluno aluno) throws Exception {
		Aluno a = alunoDAO.findByEmail(aluno.getEmail());
		if (a != null) {
			throw new Exception("E-mail já cadastrado!");
		}

	}

	public void validaRG(Aluno aluno) throws Exception {
		Aluno a = alunoDAO.findByRg(aluno.getRg());
		if (a != null) {
			throw new Exception("RG já cadastrado!");
		}

	}

	public List<Mensalidades> criarMensalidadesFuturas(Aluno aluno) throws Exception {
		List<Mensalidades> retorno = new ArrayList<Mensalidades>();
		List<Matricula> matriculas = aluno.getMatriculas();
		MesReferencia mesAtual = mesApi.getMesAtual();

		for (Matricula matricula : matriculas) {
			if (!matriculaApi.existeMensalidade(matricula, mesAtual)) {

				Mensalidades mensalidade = matriculaApi.criarMensalidade(matricula, mesApi.getMesAtual(),
						mesApi.getPrimeiroDia(mesAtual));

				if (mensalidade != null)
					retorno.add(mensalidade);

			}
		}

		return retorno;
	}

	public List<Mensalidades> getPagamentos(Aluno aluno) {
		return mensalidadeDAO.getMensalidadesPaga(aluno);
	}
}
