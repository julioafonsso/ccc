package br.com.julios.ccc.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.Turma;
import br.com.julios.ccc.negocio.MatriculaApi;
import br.com.julios.ccc.negocio.TurmaApi;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TurmaFacade {

	@Autowired
	TurmaApi turmaApi;
	
	@Autowired
	MatriculaApi matriculaApi;
	
	
	public Iterable<Turma> getTurmas() {
		return turmaApi.getTurmas();
	}

	public Iterable<Matricula> getAlunosTurma(Long idTurma) {
		return turmaApi.getAlunosTurma(idTurma);
	}

	public Turma getTurma(long id) {
		return turmaApi.getTurma(id);
	}

	public void cadastrarTurma(Turma turma) throws Exception {
		turmaApi.validaProfessoresIguais(turma);
		turmaApi.validaSala(turma);
		turmaApi.validaHorarioProfessores(turma, turma.getProfessor1());
		turmaApi.validaHorarioProfessores(turma, turma.getProfessor2());
		turmaApi.cadastrarTurma(turma);
		
	}
	
	public void atualizarTurma(Turma turma) throws Exception {
		turmaApi.atualizarTurma(turma);
		turmaApi.atualizaDataExclusaoMatriculas(turma);
		
		
	}

	public void apagarTurma(long id) throws Exception {
		Turma turma = turmaApi.getTurma(id);
		turmaApi.apagarTurma(turma);
		turmaApi.atualizaDataExclusaoMatriculas(turma);
		
	}
}
