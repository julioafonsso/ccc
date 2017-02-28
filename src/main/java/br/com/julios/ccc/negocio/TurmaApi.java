package br.com.julios.ccc.negocio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.MatriculaDAO;
import br.com.julios.ccc.daos.TurmaDAO;
import br.com.julios.ccc.daos.TurmaProfessorDAO;
import br.com.julios.ccc.domains.DiasSemana;
import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.Professor;
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

		turma.setCodigo(geraCodigo(turma));

		turmaDAO.save(turma);
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

	public Iterable<Matricula> getAlunosTurma(Long idTurma) {
		Turma turma = turmaDAO.findOne(idTurma);
		return matriculaDAO.findByTurmaAndDataExclusaoIsNull(turma);

	}

	private String geraCodigo(Turma turma) {
		StringBuffer retorno = new StringBuffer();

		List<DiasSemana> dias = turma.getDiasSemana();
		dias.sort(new Comparator<DiasSemana>() {

			public int compare(DiasSemana o1, DiasSemana o2) {
				if (o1.getId() < o2.getId())
					return 1;
				return 0;
			}

		});
		for (DiasSemana dia : dias) {
			retorno.append(dia.getId());
		}

		retorno.append(turma.getHorarioInicial().substring(0, turma.getHorarioInicial().indexOf(":")));

		retorno.append(turma.getSala().getId());
		return retorno.toString();

	}

	public void validaProfessoresIguais(Turma turma) throws Exception {
		Professor prof1 = turma.getProfessores().get(0).getProfessor();
		Professor prof2 = turma.getProfessores().get(1).getProfessor();

		if (prof1.getId() == prof2.getId())
			throw new Exception("Os Professores não podem ser os mesmos!");

	}

	public void validaSala(Turma turma) throws Exception {

		List<Turma> turmas = turmaDAO.getTurmasPorSalaEDias(turma.getSala(), turma.getDiasSemana());

		if (existeTurmaConflitoHorario(turma, turmas))
			throw new Exception("A Sala já esta ocupada por outra turma nesse horario e dia");
	}

	public void validaHorarioProfessores(Turma turma) throws Exception {

		List<TurmaProfessor> turmaProfessor = turma.getProfessores();

		for (TurmaProfessor turmaProfessor2 : turmaProfessor) {
			List<Turma> turmas = turmaDAO.getTurmaPorProfessorEDia(turmaProfessor2.getProfessor(),
					turma.getDiasSemana());

			if (existeTurmaConflitoHorario(turma, turmas))
				throw new Exception("Professor(a) " + turmaProfessor2.getProfessor().getNome()
						+ " tem outra turma nesse mesmo horario! ");
		}

	}

	private boolean existeTurmaConflitoHorario(Turma turma, List<Turma> turmas) throws Exception {
		DateFormat sdf = new SimpleDateFormat("HH:mm");
		Date horaInicial = sdf.parse(turma.getHorarioInicial());
		Date horaFinal = sdf.parse(turma.getHorarioFinal());

		for (Turma turma2 : turmas) {
			Date h1 = sdf.parse(turma2.getHorarioInicial());
			Date h2 = sdf.parse(turma2.getHorarioFinal());
			if (horaFinal.after(h1) && horaFinal.before(h2) || horaInicial.after(h1) && horaInicial.before(h2)
					|| (horaInicial.before(h1) && horaFinal.after(h1))) {
				return true;
			}
		}
		return false;
	}

}
