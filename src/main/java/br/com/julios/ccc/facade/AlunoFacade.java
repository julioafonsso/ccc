package br.com.julios.ccc.facade;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.julios.ccc.componentes.ExceptionValidacoes;
import br.com.julios.ccc.infra.bd.model.AlunoDO;
import br.com.julios.ccc.infra.bd.model.AulaParticularDO;
import br.com.julios.ccc.infra.bd.model.MatriculaDO;
import br.com.julios.ccc.infra.bd.model.MensalidadeDO;
import br.com.julios.ccc.negocio.AlunoApi;
import br.com.julios.ccc.negocio.EmailApi;
import br.com.julios.ccc.negocio.FluxoCaixaApi;
import br.com.julios.ccc.negocio.FtpApi;
import br.com.julios.ccc.negocio.MatriculaApi;
import br.com.julios.ccc.negocio.ProfessorApi;
import br.com.julios.ccc.negocio.TurmaApi;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class AlunoFacade {

	@Autowired
	AlunoApi alunoApi;

	@Autowired
	TurmaApi turmaApi;

	@Autowired
	FtpApi ftp;

	@Autowired
	FluxoCaixaApi fluxoApi;

	@Autowired
	MatriculaApi matriculaApi;

	@Autowired
	ProfessorApi professorApi;

	// @Autowired
	// MensalidadesDAO mensDAO;

	@Autowired
	ExceptionValidacoes validacao;

	@Autowired
	EmailApi email;

	public Iterable<AlunoDO> getAlunos(String nome, String cpf, String email) throws Exception {

		return alunoApi.getAlunos(nome, cpf, email);
	}

	public void cadastrarAluno(AlunoDO aluno) throws Exception {
		alunoApi.validaCPF(aluno);
		// alunoApi.validaEmail(aluno);
		alunoApi.validaRG(aluno);
		alunoApi.cadastrarAluno(aluno);
	}

	public void atualizarAluno(AlunoDO aluno) throws Exception {
		alunoApi.validaCPF(aluno);
		// alunoApi.validaEmail(aluno);
		alunoApi.validaRG(aluno);
		alunoApi.atualizarAluno(aluno);
	}

	public void apagarAluno(AlunoDO aluno) {
		alunoApi.apagarAluno(aluno);
	}

	public AlunoDO getAluno(@PathVariable("id") Long idAluno) {
		return alunoApi.getAluno(idAluno);
	}

	public List<MatriculaDO> getMatriculas(Long idAluno) {
		return alunoApi.getMatriculas(idAluno);
	}

	public List<MensalidadeDO> getDebitos(Long idAluno) throws Exception {
		AlunoDO aluno = alunoApi.getAluno(idAluno);
		// alunoApi.criarMensalidadesFuturas(aluno);

		return alunoApi.getMensalidadesParaPagar(aluno);
	}

	public void pagarMensalidade(MensalidadeDO mensalidade) throws Exception {
		// MensalidadeDO mensalidadeParaPagar =
		// mensDAO.findOne(mensalidade.getId());
		// mensalidadeParaPagar.setValorParaPagar(mensalidade.getValorParaPagar());
		//
		// FluxoCaixaDO fluxo =
		// fluxoApi.cadastrarFluxoCaixaPagamentoMensalidade(mensalidadeParaPagar);
		// matriculaApi.pagarMensalidade(mensalidadeParaPagar, fluxo);
		// professorApi.cadastarPagamentosFuturos(mensalidadeParaPagar);
		//
		// matriculaApi.criarMensalidade(mensalidadeParaPagar.getMatricula());
		//
		// email.enviarEmailReciboMensalidade(mensalidadeParaPagar);
	}

	public List<MensalidadeDO> getPagamentos(Long idAluno, Date diaInicio, Date diaFim) {
		AlunoDO aluno = alunoApi.getAluno(idAluno);
		return alunoApi.getPagamentos(aluno, diaInicio, diaFim);
	}

	public void cadastrarAulaParticular(AulaParticularDO aula, Long idAluno) throws Exception {
		// AlunoDO aluno = alunoApi.getAluno(idAluno);
		// TurmaDO turma = turmaApi.cadastrarTurmaParticular(aula.getTurma());
		//
		// MatriculaDO matricula = matriculaApi.matricularAluno(turma, aluno);
		// MensalidadeDO mensalidade = matriculaApi.criarMensalidade(matricula);
		// mensalidade.setValorParaPagar(mensalidade.getValorMensalidade());
		// FluxoCaixaDO fluxo =
		// fluxoApi.cadastrarFluxoCaixaAulaParticular(mensalidade,
		// aula.getQtd());
		// matriculaApi.pagarMensalidade(mensalidade, fluxo);
		//
		// professorApi.cadastarPagamentosFuturos(mensalidade);
		//
	}

	public List<MensalidadeDO> getAulasParticulares(Long idAluno, Date diaInicio, Date diaFim) {
		AlunoDO aluno = alunoApi.getAluno(idAluno);
		return matriculaApi.getAulasParticulares(aluno, diaInicio, diaFim);
	}

}
