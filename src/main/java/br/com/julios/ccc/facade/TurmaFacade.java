package br.com.julios.ccc.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.julios.ccc.infra.bd.model.MatriculaDO;
import br.com.julios.ccc.infra.bd.model.TurmaDO;
import br.com.julios.ccc.negocio.MatriculaApi;
import br.com.julios.ccc.negocio.TurmaApi;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class TurmaFacade {

	@Autowired
	TurmaApi turmaApi;
	
	@Autowired
	MatriculaApi matriculaApi;
	
	
	public Iterable<TurmaDO> getTurmas() {
		return turmaApi.getTurmas();
	}

	public Iterable<MatriculaDO> getAlunosTurma(Long idTurma) {
		return turmaApi.getAlunosTurma(idTurma);
	}

	public TurmaDO getTurma(long id) {
		return turmaApi.getTurma(id);
	}

	public void cadastrarTurma(TurmaDO turma) throws Exception {
//		turmaApi.validaProfessoresIguais(turma);
//		turmaApi.validaSala(turma);
//		turmaApi.validaHorarioProfessores(turma, turma.getProfessor1());
//		turmaApi.validaHorarioProfessores(turma, turma.getProfessor2());
//		turmaApi.cadastrarTurma(turma);
		
	}
	
	public void atualizarTurma(TurmaDO turma) throws Exception {
		turmaApi.atualizarTurma(turma);
		turmaApi.atualizaDataExclusaoMatriculas(turma);
		
		
	}

	public void apagarTurma(long id) throws Exception {
		TurmaDO turma = turmaApi.getTurma(id);
		turmaApi.apagarTurma(turma);
		turmaApi.atualizaDataExclusaoMatriculas(turma);
		
	}
}
