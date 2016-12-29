package br.com.julios.ccc.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.ProfessorDAO;
import br.com.julios.ccc.domains.Professor;

@Service
public class ProfessorApi {
	
	@Autowired
	ProfessorDAO professorDAO;

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

}
