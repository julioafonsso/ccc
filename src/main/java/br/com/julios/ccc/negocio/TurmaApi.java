package br.com.julios.ccc.negocio;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.MatriculaDAO;
import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.bd.model.MatriculaDO;
import br.com.julios.ccc.infra.bd.model.TurmaDO;

@Service
public class TurmaApi {

	
	@Autowired
	MatriculaDAO matriculaDAO;

	public Iterable<TurmaDO> getTurmas() {

//		return turmaDAO.getTurmas();
		return null;
	}

	public void cadastrarTurma(TurmaDO turma) {
//		TipoTurmaDO tipo = tipoTurmaDAO.findOne(TipoTurmaDO.TURMA);
//		
//		turma.setCodigo(geraCodigo(turma));
//		turma.setTipo(tipo);
//		turmaDAO.save(turma);
	}

	public void atualizarTurma(TurmaDO turma) {
	}

	public void apagarTurma(TurmaDO turma) throws ParseException {
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		turma.setDataTermino(sdf.parse( sdf.format(new Date()))	);
//		turmaDAO.save(turma);

	}

	public TurmaDO getTurma(long id) {
		return null;
	}

	public Iterable<MatriculaDO> getAlunosTurma(Long idTurma) {
		return null;
	}



	public void validaProfessoresIguais(TurmaDO turma) throws Exception {
//		if (turma.getProfessor1() != null && turma.getProfessor2() != null)
//			if (turma.getProfessor1().getId() == turma.getProfessor2().getId())
//				throw new Exception("Os Professores não podem ser os mesmos!");
	}

	public void validaSala(TurmaDO turma) throws Exception {

//		List<TurmaDO> turmas = turmaDAO.getTurmasPorSala(turma.getSala());
//
//		if (existeTurmaConflitoHorario(turma, turmas))
//			throw new Exception("A Sala já esta ocupada por outra turma nesse horario e dia");
	}

	public void validaHorarioProfessores(TurmaDO turma, FuncionarioDO professor) throws Exception {
//		if(professor == null)
//			return;
//		List<TurmaDO> turmas = turmaDAO.getTurmaPorProfessor(professor);
//
//		if (existeTurmaConflitoHorario(turma, turmas))
//			throw new Exception("Professor(a) " + professor.getNome() + " tem outra turma nesse mesmo horario! ");
//
	}

	private boolean existeTurmaConflitoHorario(TurmaDO turma, List<TurmaDO> turmas) throws Exception {

//		DateFormat sdf = new SimpleDateFormat("HH:mm");
//		Date horaInicial = sdf.parse(turma.getHorarioInicial());
//		Date horaFinal = sdf.parse(turma.getHorarioFinal());
//
//		for (TurmaDO turma2 : turmas) {
//			if ((turma.isDomingo() && turma2.isDomingo()) || (turma.isSegunda() && turma2.isSegunda())
//					|| (turma.isTerca() && turma2.isTerca()) || (turma.isQuarta() && turma2.isQuarta())
//					|| (turma.isQuinta() && turma2.isQuinta()) || (turma.isSexta() && turma2.isSexta())
//					|| (turma.isSabado() && turma2.isSabado())) 
//			{
//				
//				Date h1 = sdf.parse(turma2.getHorarioInicial());
//				Date h2 = sdf.parse(turma2.getHorarioFinal());
//				if (horaFinal.after(h1) && horaFinal.before(h2) || horaInicial.after(h1) && horaInicial.before(h2)
//						|| (horaInicial.before(h1) && horaFinal.after(h1))) {
//					return true;
//				}
//			}
//
//		}
		return false;
	}

	public void atualizaDataExclusaoMatriculas(TurmaDO turma) throws Exception {
//		Iterable<MatriculaDO> matriculas = getAlunosTurma(turma.getId());
//		for (MatriculaDO matricula : matriculas) {
//			matricula.setDataExclusao(turma.getDataTermino());
//			matriculaDAO.save(matricula);
//		}
	}

	public TurmaDO cadastrarTurmaParticular(TurmaDO turma) {
//		TipoTurmaDO tipo = tipoTurmaDAO.findOne(TipoTurmaDO.AULA_PARTICULAR);
//		turma.setNivel(null);
//		turma.setSala(null);
//		
//		turma.setCodigo("Particular");
//		turma.setTipo(tipo);
//		return turmaDAO.save(turma);
		return null;
	}

}
