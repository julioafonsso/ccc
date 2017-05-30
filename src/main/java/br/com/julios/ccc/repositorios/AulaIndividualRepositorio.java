package br.com.julios.ccc.repositorios;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.AulaParticularDAO;
import br.com.julios.ccc.infra.bd.daos.FuncionarioDAO;
import br.com.julios.ccc.infra.bd.daos.ModalidadeTurmaDAO;
import br.com.julios.ccc.infra.bd.model.AulaParticularDO;
import br.com.julios.ccc.infra.dto.turma.individual.CadastroAulaIndividualDTO;
import br.com.julios.ccc.negocio.turma.TurmaRepositorio;

@Service
public class AulaIndividualRepositorio extends TurmaRepositorio {

	@Autowired
	private ModalidadeTurmaDAO modalidadeDAO;

	@Autowired
	private AulaParticularDAO aulaDAO;

	@Autowired
	private FuncionarioDAO profDAO;

	public AulaParticularDO getAula(CadastroAulaIndividualDTO aula) {
		AulaParticularDO aulaDO = new AulaParticularDO();
		aulaDO.setModalidade(modalidadeDAO.findOne(aula.getIdModalidade()));
		aulaDO.setProfessor1(profDAO.findOne(aula.getIdProfessor1()));
		aulaDO.setPercentualProfessor1(aula.getPercentualProfessor1());
		aulaDO.setQtdAulasContratadas(aula.getQtdAulas());
		aulaDO.setQtdAulasRestantes(aula.getQtdAulas());
		aulaDO.setMensalidade(aula.getValorPago());
		return aulaDO;
	}

	public void cadastrar(AulaParticularDO aula) {
		aulaDAO.save(aula);

	}

}
