package br.com.julios.ccc.repositorios;

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
	private WorkShopDAO workDAO;
	
	@Autowired
	private 	ModalidadeTurmaDAO modalidadeDAO;
	
	@Autowired
	private FuncionarioDAO funcionarioDAO;
	
	public WorkShopDO get(CadastroWorkShopDTO cadastro) {
		WorkShopDO work = new WorkShopDO();
		work.setProfessor1(funcionarioDAO.findOne(cadastro.getIdProfessor1()));
		work.setPercentualProfessor1(cadastro.getPercentualProfessor1());
		work.setModalidade(modalidadeDAO.findOne(cadastro.getIdModalidade()));

		work.setHorarioInicial(cadastro.getHorarioInicial());
		work.setHorarioFinal(cadastro.getHorarioInicial());
		work.setVagas(cadastro.getQtdVagas());
		work.setDataInicio(cadastro.getDataInicio());
		work.setDataTermino(cadastro.getDataFim());
		work.setProfessor2(funcionarioDAO.findOne(cadastro.getIdProfessor2()));
		work.setPercentualProfessor2(cadastro.getPercentualProfessor2());
		work.setMensalidade(cadastro.getValorMensalidade());
		
		
		return work;
		
	}

	public void cadastrar(WorkShopDO workshop) {
		workDAO.save(workshop);
	}

}
