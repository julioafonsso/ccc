package br.com.julios.ccc.negocio.turma.individual;

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
	ModalidadeTurmaDAO modalidadeDAO;

	@Autowired
	AulaParticularDAO aulaDAO;

	@Autowired
	FuncionarioDAO profDAO;

	public AulaIndividual getAula(CadastroAulaIndividualDTO aula) {
		return new AulaIndividual(aula, this);
	}

	public void cadastrar(AulaIndividual aulaIndividual) {
		
		AulaParticularDO aulaDO = new AulaParticularDO();
		aulaDO.setCodigo(aulaIndividual.getCodigo());
		aulaDO.setDataContratacao(aulaIndividual.getDataContratacao());
		aulaDO.setDataUltimaAula(aulaIndividual.getDataContratacao());
		aulaDO.setModalidade(modalidadeDAO.findOne(aulaIndividual.getIdModalidade()));
		aulaDO.setPercentualProfessor1(aulaIndividual.getPercentualProfessor1());
		aulaDO.setProfessor1(profDAO.findOne(aulaIndividual.getIdProfessor1()));
		aulaDO.setQtdAulasContratadas(aulaIndividual.getQtdAulasContratadas());
		aulaDO.setQtdAulasRestantes(aulaIndividual.getQtdAulasRestantes());
		aulaDAO.save(aulaDO);
		
		aulaIndividual.setId(aulaDO.getId());
	}

}
