package br.com.julios.ccc.facade;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.componentes.ExceptionValidacoes;
import br.com.julios.ccc.domains.FluxoCaixa;
import br.com.julios.ccc.domains.PagamentoProfessor;
import br.com.julios.ccc.domains.Professor;
import br.com.julios.ccc.domains.TurmaProfessor;
import br.com.julios.ccc.negocio.FluxoCaixaApi;
import br.com.julios.ccc.negocio.FtpApi;
import br.com.julios.ccc.negocio.ProfessorApi;

@Service
public class ProfessorFacade {

	@Autowired
	ProfessorApi professorApi;

	@Autowired
	FluxoCaixaApi fluxoApi;

	@Autowired
	FtpApi ftp;

	@Autowired
	ExceptionValidacoes validacao;

	public Iterable<Professor> getProfessores() {
		return professorApi.getProfessores();
	}

	public void cadastrarProfessor(Professor professor) throws Exception {
		try {
			professorApi.validaCPF(professor);
			professorApi.validaEmail(professor);
			professorApi.validaRG(professor);

			professorApi.cadastrarProfessor(professor);
		} catch (ConstraintViolationException e) {
			throw new Exception(validacao.getMessage(e.getConstraintViolations()));
		}
	}

	public void atualizarProfessor(Professor professor) {
		professorApi.atualizarProfessor(professor);

	}

	public void apagarProfessor(Professor professor) {
		professorApi.apagarProfessor(professor);

	}

	public Professor getProfessor(Long idProfessor) {
		return professorApi.getProfessor(idProfessor);
	}

	public List<TurmaProfessor> getTurmas(Long idProfessor) {
		return professorApi.getTurmas(idProfessor);
	}

	public List<PagamentoProfessor> getSalarioProfessorPendente(Long idProfessor) {
		return professorApi.getSalarioProfessorPendente(idProfessor);
	}

	public void pagamentoProfessor(Long idProfessor, List<PagamentoProfessor> pagamento) {
		Double valorParaPagar = professorApi.getValorParaPagar(pagamento);
		Professor prof = professorApi.getProfessor(idProfessor);
		FluxoCaixa fluxo = fluxoApi.cadastrarFluxoCaixaPagamentoProfessor(prof, valorParaPagar);
		professorApi.pagamentoProfessor(pagamento, fluxo);
	}
}
