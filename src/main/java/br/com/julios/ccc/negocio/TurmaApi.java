package br.com.julios.ccc.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.TurmaDAO;
import br.com.julios.ccc.domains.Turma;

@Service
public class TurmaApi {
	
	@Autowired
	TurmaDAO turmaDAO;

	public Iterable<Turma> getTurmas() {
		
		return turmaDAO.findAll();
	}

	public void cadastrarTurma(Turma turma) {
		turmaDAO.save(turma);
				
	}

	public void atualizarTurma(Turma turma) {
		turmaDAO.save(turma);
				
	}

	public void apagarTurma(Turma turma) {
		turmaDAO.delete(turma);
				
	}

}
