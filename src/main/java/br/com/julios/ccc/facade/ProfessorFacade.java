package br.com.julios.ccc.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.domains.Professor;
import br.com.julios.ccc.domains.TurmaProfessor;
import br.com.julios.ccc.negocio.FtpApi;
import br.com.julios.ccc.negocio.ProfessorApi;

@Service
public class ProfessorFacade {

	@Autowired
	ProfessorApi professorApi;

	@Autowired
	FtpApi ftp;
	
	public Iterable<Professor> getProfessores() {
		return professorApi.getProfessores();
	}

	public void cadastrarProfessor(Professor professor) {
		professorApi.cadastrarProfessor(professor);
		
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

}
