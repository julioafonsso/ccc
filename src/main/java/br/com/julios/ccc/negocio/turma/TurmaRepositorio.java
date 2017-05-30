package br.com.julios.ccc.negocio.turma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.AulaParticularDAO;
import br.com.julios.ccc.infra.bd.daos.FuncionarioDAO;
import br.com.julios.ccc.infra.bd.daos.ModalidadeTurmaDAO;
import br.com.julios.ccc.infra.bd.daos.NivelTurmaDAO;
import br.com.julios.ccc.infra.bd.daos.SalaDAO;
import br.com.julios.ccc.infra.bd.daos.TurmaColetivaDAO;
import br.com.julios.ccc.infra.bd.daos.WorkShopDAO;
import br.com.julios.ccc.infra.bd.model.AulaParticularDO;
import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.bd.model.TurmaColetivaDO;
import br.com.julios.ccc.infra.bd.model.TurmaDO;
import br.com.julios.ccc.infra.bd.model.WorkShopDO;
import br.com.julios.ccc.repositorios.FuncionarioRepositorio;

@Service
public class TurmaRepositorio {

	@Autowired
	protected FuncionarioRepositorio funcRep;
	
	@Autowired
	protected TurmaColetivaDAO turmaDAO;
	
	@Autowired
	protected ModalidadeTurmaDAO modalidadeDAO;
	
	@Autowired
	protected NivelTurmaDAO nivelDAO;
	
	@Autowired
	protected FuncionarioDAO funcionarioDAO;
	
	@Autowired
	protected SalaDAO salaDAO;
	
	@Autowired
	protected WorkShopDAO workDAO;;
	
	@Autowired
	protected AulaParticularDAO aulaParticularDAO;
	
	public FuncionarioDO getProfessor(Long idFuncionario) throws Exception
	{
		return funcRep.getFuncionario(idFuncionario);
	}

	public WorkShopDO getWorkShop(TurmaDO turmaDO) {
		return this.workDAO.findOne(turmaDO.getId());
	}

	public TurmaColetivaDO getTurmaColetiva(TurmaDO turmaDO) {
		return this.turmaDAO.getOne(turmaDO.getId());
	}

	public AulaParticularDO getAulaParticular(TurmaDO turmaDO) {
		return this.aulaParticularDAO.findOne(turmaDO.getId());
	}
	
}
