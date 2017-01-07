package br.com.julios.ccc.negocio;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.MatriculaDAO;
import br.com.julios.ccc.daos.TurmaDAO;
import br.com.julios.ccc.daos.TurmaProfessorDAO;
import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.Turma;
import br.com.julios.ccc.domains.TurmaProfessor;

@Service
public class TurmaApi {

	@Autowired
	TurmaDAO turmaDAO;

	@Autowired
	TurmaProfessorDAO turmaProfessorDAO;

	@Autowired
	MatriculaDAO matriculaDAO;

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

	public Turma getTurma(long id) {
		
		return turmaDAO.findOne(id);
	}

	public void matricularAluno(Matricula matricula) {
		matricula.setDataMatricula(new Date());
		matriculaDAO.save(matricula);

	}

	public void excluirAlunoTurma(Matricula matricula) {
		matricula = matriculaDAO.findOne(matricula.getId());
		matricula.setDataExclusao(new Date());
		matriculaDAO.save(matricula);
	}

	public Iterable<Matricula> getAlunosTurma(Long idTurma) {
		Turma turma = turmaDAO.findOne(idTurma);
		return matriculaDAO.findByTurmaAndDataExclusaoIsNull(turma);
		
	}
	
	

}
