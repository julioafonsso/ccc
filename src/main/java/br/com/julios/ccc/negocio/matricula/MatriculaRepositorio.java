package br.com.julios.ccc.negocio.matricula;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.AlunoDAO;
import br.com.julios.ccc.infra.bd.daos.DescontoDAO;
import br.com.julios.ccc.infra.bd.daos.MatriculaDAO;
import br.com.julios.ccc.infra.bd.daos.TurmaColetivaDAO;
import br.com.julios.ccc.infra.bd.daos.TurmaDAO;
import br.com.julios.ccc.infra.bd.model.AlunoDO;
import br.com.julios.ccc.infra.bd.model.AulaParticularDO;
import br.com.julios.ccc.infra.bd.model.MatriculaDO;
import br.com.julios.ccc.infra.bd.model.TurmaColetivaDO;
import br.com.julios.ccc.infra.bd.model.TurmaDO;
import br.com.julios.ccc.infra.dto.matricula.CadastroMatriculaDTO;

@Service
public class MatriculaRepositorio {

		
	@Autowired
	private MatriculaDAO mDAO;
	
	@Autowired
	private TurmaDAO turmaDAO;
	
	@Autowired
	private AlunoDAO alunoDAO;
	
	@Autowired
	private DescontoDAO descontoDAO;
	
	@Autowired
	private TurmaColetivaDAO turmaColetivaDAO;
	
	
	public MatriculaDO getMatricula(CadastroMatriculaDTO cadastro)
	{
		
		MatriculaDO matricula = new MatriculaDO();
		matricula.setTurma(this.turmaDAO.findOne(cadastro.getIdTurma()));
		
		matricula.setAluno(this.alunoDAO.findOne((cadastro.getIdAluno())));
		
		if(cadastro.getIdDesconto() != null )
			matricula.setDesconto(this.descontoDAO.findOne(cadastro.getIdDesconto()));
		
		matricula.setDiaVencimento(cadastro.getDiaVencimento());
		matricula.setDataMatricula(new Date());
		
		return matricula;
	}
	
	public MatriculaDO getMatricula(Long idMatricula) {
		MatriculaDO matricula = mDAO.findOne(idMatricula);
		return matricula;
	}

	public void cadastrar(MatriculaDO matricula) {
		
		if(matricula.getDataMatricula() == null){
			matricula.setDataMatricula(new Date());
		}
		mDAO.save(matricula);
	}

	public MatriculaDO getMatricula(AlunoDO aluno, AulaParticularDO turma) {
		MatriculaDO matricula = new MatriculaDO();
		matricula.setAluno(aluno);
		matricula.setTurma(turma);
		
		return matricula;
	}

	public TurmaColetivaDO getTurmaColetiva(TurmaDO turma) {
		return this.turmaColetivaDAO.findOne(turma.getId());
	}
	
}
