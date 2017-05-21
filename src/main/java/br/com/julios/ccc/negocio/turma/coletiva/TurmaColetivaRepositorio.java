package br.com.julios.ccc.negocio.turma.coletiva;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.FuncionarioDAO;
import br.com.julios.ccc.infra.bd.daos.ModalidadeTurmaDAO;
import br.com.julios.ccc.infra.bd.daos.NivelTurmaDAO;
import br.com.julios.ccc.infra.bd.daos.SalaDAO;
import br.com.julios.ccc.infra.bd.daos.TurmaColetivaDAO;
import br.com.julios.ccc.infra.bd.model.TurmaColetivaDO;
import br.com.julios.ccc.infra.dto.turma.coletiva.CadastroTurmaColetivaDTO;
import br.com.julios.ccc.negocio.turma.TurmaRepositorio;

@Service
public class TurmaColetivaRepositorio extends TurmaRepositorio{

	protected SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	TurmaColetivaDAO turmaDAO;
	
	@Autowired
	ModalidadeTurmaDAO modalidadeDAO;
	
	@Autowired
	NivelTurmaDAO nivelDAO;
	
	@Autowired
	FuncionarioDAO funcionarioDAO;
	
	@Autowired
	SalaDAO salaDAO;
	
	public TurmaColetiva getTurma(CadastroTurmaColetivaDTO cadastro) {
		return new TurmaColetiva(cadastro, this);
		
	}

	public void cadastrar(TurmaColetiva tc) {
		TurmaColetivaDO turma = new TurmaColetivaDO();
		turma.setCodigo(tc.getCodigo());
		
		turma.setId(tc.getId());
		turma.setProfessor1(funcionarioDAO.findOne(tc.getIdProfessor1()));
		turma.setPercentualProfessor1(tc.getPercentualProfessor1());
		turma.setModalidade(modalidadeDAO.findOne(tc.getIdModalidade()));
		
		turma.setDomingo(tc.isDomingo());
		turma.setSegunda(tc.isSegunda());
		turma.setTerca(tc.isTerca());
		turma.setQuarta(tc.isQuarta());
		turma.setQuinta(tc.isQuinta());
		turma.setSexta(tc.isSexta());
		turma.setSabado(tc.isSabado());
		turma.setHorarioInicial(tc.getHorarioInicial());
		turma.setHorarioFinal(tc.getHorarioInicial());
		turma.setVagas(tc.getQtdVagas());
		turma.setDataInicio(tc.getDataInicio());
		turma.setDataTermino(tc.getDataFim());
		turma.setProfessor2(funcionarioDAO.findOne(tc.getIdProfessor2()));
		turma.setPercentualProfessor2(tc.getPercentualProfessor2());
		turma.setNivel(nivelDAO.findOne(tc.getIdNivel()));
		turma.setSala(salaDAO.findOne(tc.getIdSala()));
		turma.setMensalidade(tc.getValorMensalidade());
		
		turmaDAO.save(turma);
		
				
		
	}

	public TurmaColetiva getTurma(Long idTurma) throws ParseException {
		TurmaColetivaDO tDO = turmaDAO.findOne(idTurma);
		CadastroTurmaColetivaDTO cadastro = new CadastroTurmaColetivaDTO();
		cadastro.setIdProfessor1(tDO.getProfessor1().getId());
		cadastro.setPercentualProfessor1(tDO.getPercentualProfessor1());
		
		if(tDO.getProfessor2() != null)
			cadastro.setIdProfessor2(tDO.getProfessor2().getId());
		
		cadastro.setPercentualProfessor2(tDO.getPercentualProfessor2());
		
		cadastro.setQtdVagas(tDO.getVagas());
		cadastro.setValorMensalidade(tDO.getMensalidade());
		cadastro.setHorarioInicial(tDO.getHorarioInicial());
		cadastro.setHorarioFinal(tDO.getHorarioFinal());
		cadastro.setDataInicio(sdf.format(tDO.getDataInicio()));
		
		cadastro.setDataFim(sdf.format(tDO.getDataTermino()));
		
		cadastro.setDomingo(tDO.isDomingo());
		cadastro.setSegunda(tDO.isSegunda());
		cadastro.setTerca(tDO.isTerca());
		cadastro.setQuarta(tDO.isQuarta());
		cadastro.setQuinta(tDO.isQuinta());
		cadastro.setSexta(tDO.isSexta());
		cadastro.setSabado(tDO.isSabado());
		cadastro.setIdNivel(tDO.getNivel().getId());
		cadastro.setIdSala(tDO.getSala().getId());
		
		return new TurmaColetiva(cadastro, this);
	
	}

	
	
}
