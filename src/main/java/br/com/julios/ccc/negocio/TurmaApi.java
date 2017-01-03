package br.com.julios.ccc.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.TurmaDAO;
import br.com.julios.ccc.daos.TurmaProfessorDAO;
import br.com.julios.ccc.domains.Turma;
import br.com.julios.ccc.domains.TurmaProfessor;

@Service
public class TurmaApi {
	
	@Autowired
	TurmaDAO turmaDAO;
	
	@Autowired
	TurmaProfessorDAO turmaProfessorDAO;
	
	

	public Iterable<Turma> getTurmas() {
		
		return turmaDAO.findAll();
	}

	public void cadastrarTurma(Turma turma) {
		
		Turma t = turmaDAO.save(turma);
		Iterable<TurmaProfessor> turmaProfessor = turma.getProfessores();
		for (TurmaProfessor tp : turmaProfessor) {
			tp.setTurma(turma);
			turmaProfessorDAO.save(tp);
		}
	}

	public void atualizarTurma(Turma turma) {
		turmaDAO.save(turma);
				
	}

	public void apagarTurma(Turma turma) {
		turmaDAO.delete(turma);
				
	}

}
