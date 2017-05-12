package br.com.julios.ccc.negocio;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.model.FluxoCaixaDO;
import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.bd.model.MensalidadeDO;
import br.com.julios.ccc.infra.bd.model.PagamentoProfessorDO;
import br.com.julios.ccc.infra.bd.model.TurmaDO;

@Service
public class ProfessorApi {

//	@Autowired
//	ProfessorDAO professorDAO;
//
//	@Autowired
//	PagamentoProfessorDAO pagamentoDAO;
//
//	@Autowired
//	TurmaDAO turmaDAO;
//	
//	@Autowired
//	TipoTurmaDAO tipoTurmaDAO;

	public Iterable<FuncionarioDO> getProfessores() {

//		return professorDAO.findAll();
		return null;
	}

	public void cadastrarProfessor(FuncionarioDO professor) {
//		professorDAO.save(professor);

	}

	public void atualizarProfessor(FuncionarioDO professor) {
//		professorDAO.save(professor);

	}

	public void apagarProfessor(FuncionarioDO professor) {
//		professorDAO.delete(professor);

	}

	public FuncionarioDO getProfessor(Long idProfessor) {
//		return professorDAO.findOne(idProfessor);
		return null;

	}

	public List<TurmaDO> getTurmas(Long idProfessor) {
//		FuncionarioDO prof = professorDAO.findOne(idProfessor);
//		return turmaDAO.getTurmaPorProfessor(prof);
		return null;
	}

	public List<PagamentoProfessorDO> getSalarioProfessorPendente(Long idProfessor, String mes) throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
//		Calendar c = Calendar.getInstance();
//		c.setTime(sdf.parse(mes));
//		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
//		
//		return pagamentoDAO.getPagamentosPendentesNoPeriodo(idProfessor, sdf.parse(mes), c.getTime());
		return null;
	}

	public Double getValorParaPagar(List<PagamentoProfessorDO> salario) {
		Double total = new Double(0);
		for (PagamentoProfessorDO pagamento : salario) {
			total += pagamento.getValor();
		}
		return total;
	}

	public void pagamentoProfessor(List<PagamentoProfessorDO> pagamento, FluxoCaixaDO fluxo) {
//		for (PagamentoProfessorDO pagamentoProfessor : pagamento) {
//			pagamentoProfessor.setFluxoCaixa(fluxo);
//			pagamentoDAO.save(pagamentoProfessor);
//		}
	}

	public void cadastarPagamentosFuturos(MensalidadeDO mensalidade) {

//		
//		FuncionarioDO prof1 = mensalidade.getMatricula().getTurma().getProfessor1();
//		if (prof1 != null) {
//			PagamentoProfessorDO pagamento = new PagamentoProfessorDO();
//			pagamento.setMensalidade(mensalidade);
//			pagamento.setProfessor(prof1);
//			pagamentoDAO.save(pagamento);
//		}
//
//		FuncionarioDO prof2 = mensalidade.getMatricula().getTurma().getProfessor2();
//		if (prof2 != null) {
//			PagamentoProfessorDO pagamento = new PagamentoProfessorDO();
//			pagamento.setMensalidade(mensalidade);
//			pagamento.setProfessor(prof2);
//			pagamentoDAO.save(pagamento);
//		}

	}

	public void excluirPagamentosFuturos(List<MensalidadeDO> mensalidades) {
//		for (MensalidadeDO mensalidade : mensalidades) {
//			List<PagamentoProfessorDO> pagamentos = pagamentoDAO.findByMensalidade(mensalidade);
//			for (PagamentoProfessorDO pagamento : pagamentos) {
//				pagamento.setDataExclusao(new Date());
//				pagamentoDAO.save(pagamento);
//			}
//		}
	}

	public void validaCPF(FuncionarioDO professor) throws Exception {
//		CPFValidador cpfV = new CPFValidador();
//		if(!cpfV.isValid(professor.getCpf(), null))
//			throw new Exception("CPF Invalido!");
//
//		FuncionarioDO a = professorDAO.findByCpf(professor.getCpfSemFormat());
//		if (a != null && a.getId() != professor.getId()) {
//			throw new Exception("CPF já cadastrado!");
//		}

	}

	public void validaEmail(FuncionarioDO professor) throws Exception {
//		FuncionarioDO a = professorDAO.findByEmail(professor.getEmail());
//		if (a != null && a.getId() != professor.getId()) {
//			throw new Exception("E-mail já cadastrado!");
//		}

	}

	public void validaRG(FuncionarioDO professor) throws Exception {
//		FuncionarioDO a = professorDAO.findByRg(professor.getRg());
//		if (a != null && a.getId() != professor.getId()) {
//			throw new Exception("RG já cadastrado!");
//		}

	}

	public List<FluxoCaixaDO> getRecibos(FuncionarioDO professor, Date diaInicio, Date diaFim) {
//		return pagamentoDAO.getRecibosCosolidados(professor, diaInicio, diaFim);
		return null;
	}

	public List<PagamentoProfessorDO> getDetalheRecibo(FluxoCaixaDO fluxo) {
//		return pagamentoDAO.getDetalheRecibo(fluxo);
		return null;
	}

	public PagamentoProfessorDO getSalario(Long id)
	{
//		return pagamentoDAO.findOne(id);
		return null;
	}
}
