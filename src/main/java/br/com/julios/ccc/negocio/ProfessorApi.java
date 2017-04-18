package br.com.julios.ccc.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.componentes.cpf.CPFValidador;
import br.com.julios.ccc.daos.PagamentoProfessorDAO;
import br.com.julios.ccc.daos.ProfessorDAO;
import br.com.julios.ccc.daos.TurmaDAO;
import br.com.julios.ccc.domains.FluxoCaixa;
import br.com.julios.ccc.domains.Mensalidades;
import br.com.julios.ccc.domains.PagamentoProfessor;
import br.com.julios.ccc.domains.Professor;
import br.com.julios.ccc.domains.Turma;

@Service
public class ProfessorApi {

	@Autowired
	ProfessorDAO professorDAO;

	@Autowired
	PagamentoProfessorDAO pagamentoDAO;

	@Autowired
	TurmaDAO turmaDAO;

	public Iterable<Professor> getProfessores() {

		return professorDAO.findAll();
	}

	public void cadastrarProfessor(Professor professor) {
		professorDAO.save(professor);

	}

	public void atualizarProfessor(Professor professor) {
		professorDAO.save(professor);

	}

	public void apagarProfessor(Professor professor) {
		professorDAO.delete(professor);

	}

	public Professor getProfessor(Long idProfessor) {
		return professorDAO.findOne(idProfessor);

	}

	public List<Turma> getTurmas(Long idProfessor) {
		Professor prof = professorDAO.findOne(idProfessor);
		return turmaDAO.findByProfessor1OrProfessor2(prof, prof);
	}

	public List<PagamentoProfessor> getSalarioProfessorPendente(Long idProfessor, String mes) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(mes));
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		return pagamentoDAO.getPagamentosPendentesNoPeriodo(idProfessor, sdf.parse(mes), c.getTime());
	}

	public Double getValorParaPagar(List<PagamentoProfessor> salario) {
		Double total = new Double(0);
		for (PagamentoProfessor pagamento : salario) {
			total += pagamento.getValor();
		}
		return total;
	}

	public void pagamentoProfessor(List<PagamentoProfessor> pagamento, FluxoCaixa fluxo) {
		for (PagamentoProfessor pagamentoProfessor : pagamento) {
			pagamentoProfessor.setFluxoCaixa(fluxo);
			pagamentoDAO.save(pagamentoProfessor);
		}
	}

	public void cadastarPagamentosFuturos(Mensalidades mensalidade) {

		
		Professor prof1 = mensalidade.getMatricula().getTurma().getProfessor1();
		if (prof1 != null) {
			PagamentoProfessor pagamento = new PagamentoProfessor();
			pagamento.setMensalidade(mensalidade);
			pagamento.setProfessor(prof1);
			pagamentoDAO.save(pagamento);
		}

		Professor prof2 = mensalidade.getMatricula().getTurma().getProfessor2();
		if (prof2 != null) {
			PagamentoProfessor pagamento = new PagamentoProfessor();
			pagamento.setMensalidade(mensalidade);
			pagamento.setProfessor(prof2);
			pagamentoDAO.save(pagamento);
		}

	}

	public void excluirPagamentosFuturos(List<Mensalidades> mensalidades) {
		for (Mensalidades mensalidade : mensalidades) {
			List<PagamentoProfessor> pagamentos = pagamentoDAO.findByMensalidade(mensalidade);
			for (PagamentoProfessor pagamento : pagamentos) {
				pagamento.setDataExclusao(new Date());
				pagamentoDAO.save(pagamento);
			}
		}
	}

	public void validaCPF(Professor professor) throws Exception {
		CPFValidador cpfV = new CPFValidador();
		if(!cpfV.isValid(professor.getCpf(), null))
			throw new Exception("CPF Invalido!");

		Professor a = professorDAO.findByCpf(professor.getCpfSemFormat());
		if (a != null && a.getId() != professor.getId()) {
			throw new Exception("CPF já cadastrado!");
		}

	}

	public void validaEmail(Professor professor) throws Exception {
		Professor a = professorDAO.findByEmail(professor.getEmail());
		if (a != null && a.getId() != professor.getId()) {
			throw new Exception("E-mail já cadastrado!");
		}

	}

	public void validaRG(Professor professor) throws Exception {
		Professor a = professorDAO.findByRg(professor.getRg());
		if (a != null && a.getId() != professor.getId()) {
			throw new Exception("RG já cadastrado!");
		}

	}

	public List<FluxoCaixa> getRecibos(Professor professor, Date diaInicio, Date diaFim) {
		return pagamentoDAO.getRecibosCosolidados(professor, diaInicio, diaFim);
	}

	public List<PagamentoProfessor> getDetalheRecibo(FluxoCaixa fluxo) {
		return pagamentoDAO.getDetalheRecibo(fluxo);
	}

	public PagamentoProfessor getSalario(Long id)
	{
		return pagamentoDAO.findOne(id);
	}
}
