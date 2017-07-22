package br.com.julios.ccc.repositorios;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.model.AlunoDO;
import br.com.julios.ccc.infra.bd.model.NivelTurmaDO;
import br.com.julios.ccc.infra.bd.model.SalaDO;
import br.com.julios.ccc.infra.bd.model.TurmaColetivaDO;
import br.com.julios.ccc.infra.dto.turma.coletiva.CadastroTurmaColetivaDTO;

@Service
public class TurmaColetivaRepositorio extends TurmaRepositorio {

	protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public TurmaColetivaDO getTurma(CadastroTurmaColetivaDTO cadastro) throws Exception {
		TurmaColetivaDO turma = new TurmaColetivaDO();
		
		turma.setHorarioInicial(cadastro.getHorarioInicial());
		turma.setHorarioFinal(cadastro.getHorarioFinal());
		turma.setDomingo(cadastro.isDomingo());
		turma.setSegunda(cadastro.isSegunda());
		turma.setTerca(cadastro.isTerca());
		turma.setQuarta(cadastro.isQuarta());
		turma.setQuinta(cadastro.isQuinta());
		turma.setSexta(cadastro.isSexta());
		turma.setSabado(cadastro.isSabado());
		turma.setDataInicio(cadastro.getDataInicio());
		turma.setDataTermino(cadastro.getDataFim());
		
		if (cadastro.getIdProfessor1() != null)
			turma.setProfessor1(this.getProfessor(cadastro.getIdProfessor1()));

		turma.setPercentualProfessor1(cadastro.getPercentualProfessor1());
		turma.setModalidade(this.getModalidade(cadastro.getIdModalidade()));
		turma.setVagas(cadastro.getQtdVagas());
		
		if (cadastro.getIdProfessor2() != null)
			turma.setProfessor2(this.getProfessor(cadastro.getIdProfessor2()));
		turma.setPercentualProfessor2(cadastro.getPercentualProfessor2());
		turma.setNivel(this.getNivel(cadastro.getIdNivel()));
		turma.setSala(this.getSala(cadastro.getIdSala()));
		turma.setMensalidade(cadastro.getValorMensalidade());

		return turma;

	}

	public SalaDO getSala(Long idSala) {
		return this.salaDAO.findOne(idSala);
	}

	public NivelTurmaDO getNivel(Long idNivel) {
		return this.nivelDAO.findOne(idNivel);
	}

	public void cadastrar(TurmaColetivaDO tc) {
		turmaDAO.save(tc);
	}

	public TurmaColetivaDO getTurma(Long idTurma) throws ParseException {
		TurmaColetivaDO turma = turmaDAO.findOne(idTurma);
		return turma;
	}

	public List<AlunoDO> getAlunos(TurmaColetivaDO turmaColetivaDO) {
		return this.matriculaDAO.getAlunosMatriculados(turmaColetivaDO);
	}

	


}
