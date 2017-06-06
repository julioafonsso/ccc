package br.com.julios.ccc.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.WorkShopDAO;
import br.com.julios.ccc.infra.bd.model.WorkShopDO;
import br.com.julios.ccc.infra.dto.turma.workshop.CadastroWorkShopDTO;

@Service
public class WorkShopRepositorio extends TurmaRepositorio {

	@Autowired
	private WorkShopDAO workDAO;


	public WorkShopDO get(CadastroWorkShopDTO cadastro) throws Exception {
		WorkShopDO work = new WorkShopDO();
		if (cadastro.getIdProfessor1() != null)
			work.setProfessor1(this.getProfessor(cadastro.getIdProfessor1()));
		work.setPercentualProfessor1(cadastro.getPercentualProfessor1());
		work.setModalidade(this.getModalidade(cadastro.getIdModalidade()));

		work.setHorarioInicial(cadastro.getHorarioInicial());
		work.setHorarioFinal(cadastro.getHorarioInicial());
		work.setVagas(cadastro.getQtdVagas());
		work.setDataInicio(cadastro.getDataInicio());
		work.setDataTermino(cadastro.getDataFim());
		if (cadastro.getIdProfessor2() != null)
			work.setProfessor2(this.getProfessor(cadastro.getIdProfessor2()));
		work.setPercentualProfessor2(cadastro.getPercentualProfessor2());
		work.setMensalidade(cadastro.getValorMensalidade());

		return work;

	}

	public void cadastrar(WorkShopDO workshop) {
		workDAO.save(workshop);
	}

	public WorkShopDO get(Long id) {
		return this.workDAO.findOne(id);
	}

}
