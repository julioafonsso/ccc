package br.com.julios.ccc.facade;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.julios.ccc.componentes.ExceptionValidacoes;
import br.com.julios.ccc.domains.FluxoCaixa;
import br.com.julios.ccc.domains.PagamentoProfessor;
import br.com.julios.ccc.domains.Professor;
import br.com.julios.ccc.domains.Turma;
import br.com.julios.ccc.negocio.EmailApi;
import br.com.julios.ccc.negocio.FluxoCaixaApi;
import br.com.julios.ccc.negocio.FtpApi;
import br.com.julios.ccc.negocio.ProfessorApi;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProfessorFacade {

	@Autowired
	ProfessorApi professorApi;

	@Autowired
	FluxoCaixaApi fluxoApi;

	@Autowired
	FtpApi ftp;

	@Autowired
	ExceptionValidacoes validacao;

	@Autowired
	EmailApi email;
	
	public Iterable<Professor> getProfessores() {
		return professorApi.getProfessores();
	}

	public void cadastrarProfessor(Professor professor) throws Exception {
			professorApi.validaCPF(professor);
			professorApi.validaEmail(professor);
			professorApi.validaRG(professor);

			professorApi.cadastrarProfessor(professor);
	}

	public void atualizarProfessor(Professor professor) throws Exception {
		professorApi.validaCPF(professor);
		professorApi.validaEmail(professor);
		professorApi.validaRG(professor);
		professorApi.atualizarProfessor(professor);

	}

	public void apagarProfessor(Professor professor) {
		professorApi.apagarProfessor(professor);

	}

	public Professor getProfessor(Long idProfessor) {
		return professorApi.getProfessor(idProfessor);
	}

	public List<Turma> getTurmas(Long idProfessor) {
		return professorApi.getTurmas(idProfessor);
	}

	public List<PagamentoProfessor> getSalarioProfessorPendente(Long idProfessor) {
		return professorApi.getSalarioProfessorPendente(idProfessor);
	}

	public void pagamentoProfessor(Long idProfessor) throws Exception {
		List<PagamentoProfessor> pagamento = getSalarioProfessorPendente(idProfessor);
		Double valorParaPagar = professorApi.getValorParaPagar(pagamento);
		Professor prof = professorApi.getProfessor(idProfessor);
		FluxoCaixa fluxo = fluxoApi.cadastrarFluxoCaixaPagamentoProfessor(prof, valorParaPagar);
		professorApi.pagamentoProfessor(pagamento, fluxo);
		
		email.enviarEmailPagametoProfessor(pagamento, fluxo, prof);
	}

	public List<FluxoCaixa> getRecibos(Long idProfessor, Date diaInicio, Date diaFim) {
		Professor professor = professorApi.getProfessor(idProfessor);
		return professorApi.getRecibos(professor, diaInicio, diaFim);
	}

	public List<PagamentoProfessor> getDetalhePagamento(Long idFluxo) {
		FluxoCaixa fluxo = fluxoApi.getFluxo(idFluxo);
		return professorApi.getDetalheRecibo(fluxo);
	}
}
