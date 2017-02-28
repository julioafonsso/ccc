package br.com.julios.ccc.negocio;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.PagamentoProfessorDAO;
import br.com.julios.ccc.daos.ProfessorDAO;
import br.com.julios.ccc.daos.TurmaProfessorDAO;
import br.com.julios.ccc.domains.FluxoCaixa;
import br.com.julios.ccc.domains.Mensalidades;
import br.com.julios.ccc.domains.PagamentoProfessor;
import br.com.julios.ccc.domains.Professor;
import br.com.julios.ccc.domains.Turma;
import br.com.julios.ccc.domains.TurmaProfessor;

@Service
public class ProfessorApi {
	
	@Autowired
	ProfessorDAO professorDAO;
	
	@Autowired
	TurmaProfessorDAO turmaProfessorDAO;
	
	@Autowired
	PagamentoProfessorDAO pagamentoDAO;
	

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
	
	public Professor getProfessor(Long idProfessor){
		return professorDAO.findOne(idProfessor);
	
	}
	
	public List<TurmaProfessor> getTurmas(Long idProfessor){
		Professor p = professorDAO.findOne(idProfessor);
		return p.getTurmas();
	}

	public List<PagamentoProfessor> getSalarioProfessorPendente(Long idProfessor) {
		return pagamentoDAO.getPagamentosPendentes(idProfessor);
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
	
	public void cadastarPagamentosFuturos(List<Mensalidades> mensalidades, Turma turma){
		for (Mensalidades mensalidade : mensalidades) {
			List<TurmaProfessor> professores = turma.getProfessores();
			for (TurmaProfessor turmaProfessor : professores) {
				Professor professor = turmaProfessor.getProfessor();
				PagamentoProfessor pagamento = new PagamentoProfessor();
				pagamento.setMensalidade(mensalidade);
				pagamento.setProfessor(professor);
				pagamentoDAO.save(pagamento);
			}
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
		Professor a = professorDAO.findByCpf(professor.getCpfSemFormat());
		if(a !=  null)
		{
			throw new Exception("CPF já cadastrado!");
		}
		
	}

	public void validaEmail(Professor professor) throws Exception {
		Professor a = professorDAO.findByEmail(professor.getEmail());
		if(a !=  null)
		{
			throw new Exception("E-mail já cadastrado!");
		}
		
	}

	public void validaRG(Professor professor)  throws Exception {
		Professor a = professorDAO.findByRg(professor.getRg());
		if(a !=  null)
		{
			throw new Exception("RG já cadastrado!");
		}
		
	}
	
}
