package br.com.julios.ccc.negocio.turma.workshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.FuncionarioDAO;
import br.com.julios.ccc.infra.bd.daos.ModalidadeTurmaDAO;
import br.com.julios.ccc.infra.bd.daos.WorkShopDAO;
import br.com.julios.ccc.infra.bd.model.WorkShopDO;
import br.com.julios.ccc.infra.dto.turma.workshop.CadastroWorkShopDTO;
import br.com.julios.ccc.negocio.turma.TurmaRepositorio;

@Service
public class WorkShopRepositorio extends TurmaRepositorio {

	@Autowired
	WorkShopDAO workDAO;
	
	@Autowired
	ModalidadeTurmaDAO modalidadeDAO;
	
	@Autowired
	FuncionarioDAO funcionarioDAO;
	
	public WorkShop get(CadastroWorkShopDTO turma) {
		return new WorkShop(turma, this);
	}

	protected void cadastrar(WorkShop workshop) {
		WorkShopDO turma = new WorkShopDO();
		turma.setCodigo(workshop.getCodigo());
		
		turma.setId(workshop.getId());
		turma.setProfessor1(funcionarioDAO.findOne(workshop.getIdProfessor1()));
		turma.setPercentualProfessor1(workshop.getPercentualProfessor1());
		turma.setModalidade(modalidadeDAO.findOne(workshop.getIdModalidade()));
		
		turma.setHorarioInicial(workshop.getHorarioInicial());
		turma.setHorarioFinal(workshop.getHorarioInicial());
		turma.setVagas(workshop.getQtdVagas());
		turma.setDataInicio(workshop.getDataInicio());
		turma.setDataTermino(workshop.getDataFim());
		turma.setProfessor2(funcionarioDAO.findOne(workshop.getIdProfessor2()));
		turma.setPercentualProfessor2(workshop.getPercentualProfessor2());
		turma.setMensalidade(workshop.getValorMensalidade());
		
		workDAO.save(turma);
		
	}

}
