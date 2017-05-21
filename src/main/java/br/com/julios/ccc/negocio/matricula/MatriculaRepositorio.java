package br.com.julios.ccc.negocio.matricula;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.AlunoDAO;
import br.com.julios.ccc.infra.bd.daos.DescontoDAO;
import br.com.julios.ccc.infra.bd.daos.MatriculaDAO;
import br.com.julios.ccc.infra.bd.daos.TurmaDAO;
import br.com.julios.ccc.infra.bd.model.MatriculaDO;
import br.com.julios.ccc.infra.dto.matricula.CadastroMatriculaDTO;
import br.com.julios.ccc.negocio.desconto.Desconto;
import br.com.julios.ccc.negocio.desconto.DescontoRepositorio;
import br.com.julios.ccc.negocio.fluxos.FluxoCaixa;
import br.com.julios.ccc.negocio.fluxos.FluxoCaixaRepositorio;
import br.com.julios.ccc.negocio.mensalidade.Mensalidade;
import br.com.julios.ccc.negocio.mensalidade.MensalidadeRepositorio;
import br.com.julios.ccc.negocio.turma.coletiva.TurmaColetiva;
import br.com.julios.ccc.negocio.turma.coletiva.TurmaColetivaRepositorio;

@Service
public class MatriculaRepositorio {

	@Autowired
	FluxoCaixaRepositorio fluxoRepositorio;
	
	@Autowired
	MensalidadeRepositorio mensalidadeRepositorio;
	
	@Autowired
	private TurmaColetivaRepositorio turmaRepositorio;
	
	@Autowired
	private DescontoRepositorio descontoRepositorio;
	
	@Autowired
	MatriculaDAO mDAO;
	
	@Autowired
	TurmaDAO turmaDAO;
	
	@Autowired
	AlunoDAO alunoDAO;
	
	@Autowired
	DescontoDAO descontoDAO;
	
	
	public Matricula getMatricula(CadastroMatriculaDTO cadastro)
	{
		return new Matricula(cadastro, this);
	}
	
	public Matricula getMatricula(Long idMatricula) {
		MatriculaDO matricula = this.mDAO.findOne(idMatricula);
		CadastroMatriculaDTO cadastro = new CadastroMatriculaDTO();
		cadastro.setDiaVencimento(matricula.getDiaVencimento());
		cadastro.setId(matricula.getId());
		cadastro.setIdAluno(matricula.getAluno().getId());
		cadastro.setDataMatricula(matricula.getDataMatricula());
		if(matricula.getDesconto() != null)
			cadastro.setIdDesconto(matricula.getDesconto().getId());
		
		cadastro.setIdTurma(matricula.getTurma().getId());
		return getMatricula(cadastro);
	}

	protected void cadastrar(Matricula matricula) {
		
		MatriculaDO mDO = new MatriculaDO();
		mDO.setAluno(alunoDAO.findOne(matricula.getIdAluno()));
		
		if(matricula.getDataMatricula() == null){
			matricula.setDataMatricula(new Date());
		}
			mDO.setDataMatricula(matricula.getDataMatricula());
		
		if(matricula.getIdDesconto() != null)
			mDO.setDesconto(descontoDAO.findOne(matricula.getIdDesconto()));
		
		mDO.setDiaVencimento(matricula.getDiaVencimento());
		mDO.setTurma(turmaDAO.findOne(matricula.getIdTurma()));
		
		mDAO.save(mDO);
		matricula.setId(mDO.getId());
	}

	public Mensalidade getMensalidade(Matricula matricula) throws ParseException {
		return mensalidadeRepositorio.getMensalidade(matricula);
	}

	public FluxoCaixa getFluxoPagamentoMatricula(Double valor) {

		return this.fluxoRepositorio.getFluxoPagamentoMatricula(valor);
	}
	
	protected TurmaColetiva getTurmaColetiva(Long idTurma) throws ParseException {
		return turmaRepositorio.getTurma(idTurma);
	}

	protected Desconto getDesconto(Long idDesconto) {
		return descontoRepositorio.getDesconto(idDesconto);
	}

	
	
}
