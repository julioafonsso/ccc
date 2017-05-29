package br.com.julios.ccc.negocio.turma.coletiva;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.model.TurmaColetivaDO;
import br.com.julios.ccc.infra.dto.turma.coletiva.CadastroTurmaColetivaDTO;
import br.com.julios.ccc.negocio.turma.TurmaRepositorio;

@Service
public class TurmaColetivaRepositorio extends TurmaRepositorio{

	protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	
	
	public TurmaColetivaDO getTurma(CadastroTurmaColetivaDTO cadastro) {
		TurmaColetivaDO turma = new TurmaColetivaDO();
		turma.setProfessor1(funcionarioDAO.findOne(cadastro.getIdProfessor1()));
		turma.setPercentualProfessor1(cadastro.getPercentualProfessor1());
		turma.setModalidade(modalidadeDAO.findOne(cadastro.getIdModalidade()));

		turma.setDomingo(cadastro.isDomingo());
		turma.setSegunda(cadastro.isSegunda());
		turma.setTerca(cadastro.isTerca());
		turma.setQuarta(cadastro.isQuarta());
		turma.setQuinta(cadastro.isQuinta());
		turma.setSexta(cadastro.isSexta());
		turma.setSabado(cadastro.isSabado());
		turma.setHorarioInicial(cadastro.getHorarioInicial());
		turma.setHorarioFinal(cadastro.getHorarioInicial());
		turma.setVagas(cadastro.getQtdVagas());
		turma.setDataInicio(cadastro.getDataInicio());
		turma.setDataTermino(cadastro.getDataFim());
		turma.setProfessor2(funcionarioDAO.findOne(cadastro.getIdProfessor2()));
		turma.setPercentualProfessor2(cadastro.getPercentualProfessor2());
		turma.setNivel(nivelDAO.findOne(cadastro.getIdNivel()));
		turma.setSala(salaDAO.findOne(cadastro.getIdSala()));
		turma.setMensalidade(cadastro.getValorMensalidade());
		
		return turma;
		
	}

	public void cadastrar(TurmaColetivaDO tc) {
		turmaDAO.save(tc);
	}

	public TurmaColetivaDO getTurma(Long idTurma) throws ParseException {
		TurmaColetivaDO turma = turmaDAO.findOne(idTurma);
		return turma;
	}
	
	

	
	
}
