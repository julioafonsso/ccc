package br.com.julios.ccc.repositorios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.AulaParticularDAO;
import br.com.julios.ccc.infra.bd.daos.FuncionarioDAO;
import br.com.julios.ccc.infra.bd.daos.MatriculaDAO;
import br.com.julios.ccc.infra.bd.daos.ModalidadeTurmaDAO;
import br.com.julios.ccc.infra.bd.daos.NivelTurmaDAO;
import br.com.julios.ccc.infra.bd.daos.SalaDAO;
import br.com.julios.ccc.infra.bd.daos.TurmaColetivaDAO;
import br.com.julios.ccc.infra.bd.daos.WorkShopDAO;
import br.com.julios.ccc.infra.bd.model.AulaParticularDO;
import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.bd.model.MatriculaDO;
import br.com.julios.ccc.infra.bd.model.MesReferenciaDO;
import br.com.julios.ccc.infra.bd.model.ModalidadeTurmaDO;
import br.com.julios.ccc.infra.bd.model.TurmaColetivaDO;
import br.com.julios.ccc.infra.bd.model.TurmaDO;
import br.com.julios.ccc.infra.bd.model.WorkShopDO;

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
	
	@Autowired
	protected MatriculaDAO matriculaDAO;
	
	@Autowired
	protected MesRerefenciaRepositorio mesRepo;
	
	public MesReferenciaDO getMesAtual() {
		return mesRepo.getMesAtual();
	}
	
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
	
	public ModalidadeTurmaDO getModalidade(Long idModalidade) {
		return this.modalidadeDAO.findOne(idModalidade);
	}
	
	public List<MatriculaDO> getMatriculas(TurmaDO turma){
		return this.matriculaDAO.getMatriculas(turma);
	}
}