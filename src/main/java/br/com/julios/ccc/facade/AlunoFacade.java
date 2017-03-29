	package br.com.julios.ccc.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.julios.ccc.componentes.ExceptionValidacoes;
import br.com.julios.ccc.daos.MensalidadesDAO;
import br.com.julios.ccc.domains.Aluno;
import br.com.julios.ccc.domains.FluxoCaixa;
import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.Mensalidades;
import br.com.julios.ccc.negocio.AlunoApi;
import br.com.julios.ccc.negocio.FluxoCaixaApi;
import br.com.julios.ccc.negocio.FtpApi;
import br.com.julios.ccc.negocio.MatriculaApi;
import br.com.julios.ccc.negocio.ProfessorApi;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AlunoFacade {

	@Autowired
	AlunoApi alunoApi;

	@Autowired
	FtpApi ftp;
	
	@Autowired
	FluxoCaixaApi fluxoApi;

	@Autowired
	MatriculaApi matriculaApi;
	
	@Autowired
	ProfessorApi professorApi;
	
	@Autowired
	MensalidadesDAO mensDAO;
	
	@Autowired
	ExceptionValidacoes validacao;

	public Iterable<Aluno> getAlunos(String nome, String cpf, String email) throws Exception {

		return alunoApi.getAlunos(nome, cpf, email);
	}

	public void cadastrarAluno(Aluno aluno) throws Exception {
			alunoApi.validaCPF(aluno);
			alunoApi.validaEmail(aluno);
			alunoApi.validaRG(aluno);
			alunoApi.cadastrarAluno(aluno);
	}

	public void atualizarAluno(Aluno aluno) throws Exception {
		alunoApi.validaCPF(aluno);
		alunoApi.validaEmail(aluno);
		alunoApi.validaRG(aluno);
		alunoApi.atualizarAluno(aluno);
	}

	public void apagarAluno(Aluno aluno) {
		alunoApi.apagarAluno(aluno);
	}

	public Aluno getAluno(@PathVariable("id") Long idAluno) {
		return alunoApi.getAluno(idAluno);
	}

	public List<Matricula> getMatriculas(Long idAluno) {
		return alunoApi.getMatriculas(idAluno);
	}

	public List<Mensalidades> getDebitos(Long idAluno) throws Exception {
		Aluno aluno = alunoApi.getAluno(idAluno);
		alunoApi.criarMensalidadesFuturas(aluno);
		
		return alunoApi.getMensalidadesParaPagar(aluno);
	}
	
	public void pagarMensalidade(Mensalidades mensalidade) throws Exception {
		Mensalidades mensalidadeParaPagar = mensDAO.findOne(mensalidade.getId());
		mensalidadeParaPagar.setValorParaPagar(mensalidade.getValorParaPagar());
		
		FluxoCaixa fluxo = fluxoApi.cadastrarFluxoCaixaPagamentoMensalidade(mensalidadeParaPagar);
		matriculaApi.pagarMensalidade(mensalidadeParaPagar, fluxo);
		professorApi.cadastarPagamentosFuturos(mensalidadeParaPagar);
	}

	
	public List<Mensalidades> getPagamentos(Long idAluno) {
		Aluno aluno = alunoApi.getAluno(idAluno);
		return alunoApi.getPagamentos(aluno);
	}

}
