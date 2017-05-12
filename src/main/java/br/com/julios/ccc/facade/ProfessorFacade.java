package br.com.julios.ccc.facade;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.julios.ccc.componentes.ExceptionValidacoes;
import br.com.julios.ccc.infra.bd.model.FluxoCaixaDO;
import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.bd.model.PagamentoProfessorDO;
import br.com.julios.ccc.infra.bd.model.TurmaDO;
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
	
	public Iterable<FuncionarioDO> getProfessores() {
		return professorApi.getProfessores();
	}

	public void cadastrarProfessor(FuncionarioDO professor) throws Exception {
			professorApi.validaCPF(professor);
			professorApi.validaEmail(professor);
			professorApi.validaRG(professor);

			professorApi.cadastrarProfessor(professor);
	}

	public void atualizarProfessor(FuncionarioDO professor) throws Exception {
		professorApi.validaCPF(professor);
		professorApi.validaEmail(professor);
		professorApi.validaRG(professor);
		professorApi.atualizarProfessor(professor);

	}

	public void apagarProfessor(FuncionarioDO professor) {
		professorApi.apagarProfessor(professor);

	}

	public FuncionarioDO getProfessor(Long idProfessor) {
		return professorApi.getProfessor(idProfessor);
	}

	public List<TurmaDO> getTurmas(Long idProfessor) {
		return professorApi.getTurmas(idProfessor);
	}

	public List<PagamentoProfessorDO> getSalarioProfessorPendente(Long idProfessor, String mes) throws ParseException {
		return professorApi.getSalarioProfessorPendente(idProfessor, mes);
	}

	public void pagamentoProfessor(Long idProfessor, Long idSalario) throws Exception
	{
		PagamentoProfessorDO pp = professorApi.getSalario(idSalario);
		FuncionarioDO prof = professorApi.getProfessor(idProfessor);
		FluxoCaixaDO fluxo = fluxoApi.cadastrarFluxoCaixaPagamentoProfessor(prof, pp.getValor());
		
		List<PagamentoProfessorDO> pagamento = new ArrayList<PagamentoProfessorDO>();
		
		pagamento.add(pp);
		
		professorApi.pagamentoProfessor(pagamento, fluxo);
		
		email.enviarEmailPagametoProfessor(pagamento, fluxo, prof);
	}
	
	public void pagamentoProfessor(Long idProfessor, String mes) throws Exception {
		List<PagamentoProfessorDO> pagamento = getSalarioProfessorPendente(idProfessor, mes);
		Double valorParaPagar = professorApi.getValorParaPagar(pagamento);
		FuncionarioDO prof = professorApi.getProfessor(idProfessor);
		FluxoCaixaDO fluxo = fluxoApi.cadastrarFluxoCaixaPagamentoProfessor(prof, valorParaPagar);
		professorApi.pagamentoProfessor(pagamento, fluxo);
		
		email.enviarEmailPagametoProfessor(pagamento, fluxo, prof);
	}

	public List<FluxoCaixaDO> getRecibos(Long idProfessor, Date diaInicio, Date diaFim) {
		FuncionarioDO professor = professorApi.getProfessor(idProfessor);
		return professorApi.getRecibos(professor, diaInicio, diaFim);
	}

	public List<PagamentoProfessorDO> getDetalhePagamento(Long idFluxo) {
		FluxoCaixaDO fluxo = fluxoApi.getFluxo(idFluxo);
		return professorApi.getDetalheRecibo(fluxo);
	}
}
