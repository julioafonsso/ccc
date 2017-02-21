package br.com.julios.ccc.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.ProfessorDAO;
import br.com.julios.ccc.daos.SalarioDAO;
import br.com.julios.ccc.daos.TurmaProfessorDAO;
import br.com.julios.ccc.domains.Professor;
import br.com.julios.ccc.domains.Salario;
import br.com.julios.ccc.domains.TurmaProfessor;

@Service
public class ProfessorApi {
	
	@Autowired
	ProfessorDAO professorDAO;
	
	@Autowired
	TurmaProfessorDAO turmaProfessorDAO;
	
	@Autowired
	SalarioDAO salarioDAO;

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
	
	public List<Salario> getSalarioProfessorPendente(Long idProfessor){
		return salarioDAO.findByProfessor(idProfessor);
	}

}
