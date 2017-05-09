package br.com.julios.ccc.negocio;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.MatriculaDAO;
import br.com.julios.ccc.daos.TipoTurmaDAO;
import br.com.julios.ccc.daos.TurmaDAO;
import br.com.julios.ccc.domains.Matricula;
import br.com.julios.ccc.domains.Professor;
import br.com.julios.ccc.domains.TipoTurma;
import br.com.julios.ccc.domains.Turma;

@Service
public class TurmaApi {

	@Autowired
	TurmaDAO turmaDAO;

	@Autowired
	TipoTurmaDAO tipoTurmaDAO;
	
	@Autowired
	MatriculaDAO matriculaDAO;

	public Iterable<Turma> getTurmas() {

		return turmaDAO.getTurmas();
	}

	public void cadastrarTurma(Turma turma) {
		TipoTurma tipo = tipoTurmaDAO.findOne(TipoTurma.TURMA);
		
		turma.setCodigo(geraCodigo(turma));
		turma.setTipo(tipo);
		turmaDAO.save(turma);
	}

	public void atualizarTurma(Turma turma) {
		turmaDAO.save(turma);
	}

	public void apagarTurma(Turma turma) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		turma.setDataTermino(sdf.parse( sdf.format(new Date()))	);
		turmaDAO.save(turma);

	}

	public Turma getTurma(long id) {

		return turmaDAO.findOne(id);
	}

	public Iterable<Matricula> getAlunosTurma(Long idTurma) {
		Turma turma = turmaDAO.findOne(idTurma);
		return turma.getMatriculas();

	}

	private String geraCodigo(Turma turma) {
		StringBuffer retorno = new StringBuffer();

		if (turma.isDomingo())
			retorno.append("1");
		if (turma.isSegunda())
			retorno.append("2");
		if (turma.isTerca())
			retorno.append("3");
		if (turma.isQuarta())
			retorno.append("4");
		if (turma.isQuinta())
			retorno.append("5");
		if (turma.isSexta())
			retorno.append("6");
		if (turma.isSabado())
			retorno.append("7");

		retorno.append(turma.getHorarioInicial().substring(0, turma.getHorarioInicial().indexOf(":")));

		retorno.append(turma.getSala().getId());
		return retorno.toString();

	}

	public void validaProfessoresIguais(Turma turma) throws Exception {
		if (turma.getProfessor1() != null && turma.getProfessor2() != null)
			if (turma.getProfessor1().getId() == turma.getProfessor2().getId())
				throw new Exception("Os Professores não podem ser os mesmos!");
	}

	public void validaSala(Turma turma) throws Exception {

		List<Turma> turmas = turmaDAO.getTurmasPorSala(turma.getSala());

		if (existeTurmaConflitoHorario(turma, turmas))
			throw new Exception("A Sala já esta ocupada por outra turma nesse horario e dia");
	}

	public void validaHorarioProfessores(Turma turma, Professor professor) throws Exception {
		if(professor == null)
			return;
		List<Turma> turmas = turmaDAO.getTurmaPorProfessor(professor);

		if (existeTurmaConflitoHorario(turma, turmas))
			throw new Exception("Professor(a) " + professor.getNome() + " tem outra turma nesse mesmo horario! ");

	}

	private boolean existeTurmaConflitoHorario(Turma turma, List<Turma> turmas) throws Exception {

		DateFormat sdf = new SimpleDateFormat("HH:mm");
		Date horaInicial = sdf.parse(turma.getHorarioInicial());
		Date horaFinal = sdf.parse(turma.getHorarioFinal());

		for (Turma turma2 : turmas) {
			if ((turma.isDomingo() && turma2.isDomingo()) || (turma.isSegunda() && turma2.isSegunda())
					|| (turma.isTerca() && turma2.isTerca()) || (turma.isQuarta() && turma2.isQuarta())
					|| (turma.isQuinta() && turma2.isQuinta()) || (turma.isSexta() && turma2.isSexta())
					|| (turma.isSabado() && turma2.isSabado())) 
			{
				
				Date h1 = sdf.parse(turma2.getHorarioInicial());
				Date h2 = sdf.parse(turma2.getHorarioFinal());
				if (horaFinal.after(h1) && horaFinal.before(h2) || horaInicial.after(h1) && horaInicial.before(h2)
						|| (horaInicial.before(h1) && horaFinal.after(h1))) {
					return true;
				}
			}

		}
		return false;
	}

	public void atualizaDataExclusaoMatriculas(Turma turma) throws Exception {
		Iterable<Matricula> matriculas = getAlunosTurma(turma.getId());
		for (Matricula matricula : matriculas) {
			matricula.setDataExclusao(turma.getDataTermino());
			matriculaDAO.save(matricula);
		}
		
	}

	public Turma cadastrarTurmaParticular(Turma turma) {
		TipoTurma tipo = tipoTurmaDAO.findOne(TipoTurma.AULA_PARTICULAR);
		turma.setNivel(null);
		turma.setSala(null);
		
		turma.setCodigo("Particular");
		turma.setTipo(tipo);
		return turmaDAO.save(turma);
		
	}

}
