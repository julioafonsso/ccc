package br.com.julios.ccc.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.Turma;
import br.com.julios.ccc.negocio.TurmaApi;

@Service
public class TurmaFacade {

	@Autowired
	TurmaApi turmaApi;
	
	public Iterable<Turma> getTurmas() {
		return turmaApi.getTurmas();
	}

	public Iterable<Matricula> getAlunosTurma(Long idTurma) {
		return turmaApi.getAlunosTurma(idTurma);
	}

	public Turma getTurma(long id) {
		return turmaApi.getTurma(id);
	}

	public void cadastrarTurma(Turma turma) {
		turmaApi.cadastrarTurma(turma);
		
	}
	
	public void atualizarTurma(Turma turma) {
		turmaApi.atualizarTurma(turma);
		
	}

	public void apagarTurma(Turma turma) {
		turmaApi.apagarTurma(turma);
		
	}
}
