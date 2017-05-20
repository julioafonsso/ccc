package br.com.julios.ccc.negocio.mensalidade;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.FluxoCaixaDAO;
import br.com.julios.ccc.infra.bd.daos.MatriculaDAO;
import br.com.julios.ccc.infra.bd.daos.MensalidadeDAO;
import br.com.julios.ccc.infra.bd.daos.MesReferenciaDAO;
import br.com.julios.ccc.infra.bd.model.MensalidadeDO;
import br.com.julios.ccc.infra.dto.menslidade.CadastroMensalidadeDTO;
import br.com.julios.ccc.negocio.desconto.Desconto;
import br.com.julios.ccc.negocio.desconto.DescontoRepositorio;
import br.com.julios.ccc.negocio.fluxos.FluxoCaixa;
import br.com.julios.ccc.negocio.fluxos.FluxoCaixaRepositorio;
import br.com.julios.ccc.negocio.matricula.Matricula;
import br.com.julios.ccc.negocio.matricula.MatriculaRepositorio;
import br.com.julios.ccc.negocio.mes.MesReferencia;
import br.com.julios.ccc.negocio.mes.MesRerefenciaRepositorio;
import br.com.julios.ccc.negocio.turma.coletiva.TurmaColetiva;
import br.com.julios.ccc.negocio.turma.coletiva.TurmaColetivaRepositorio;

@Service
public class MensalidadeRepositorio {

	@Autowired
	private MatriculaRepositorio matriculaRepositorio;
	
	@Autowired
	private MesRerefenciaRepositorio mesRepositorio;
	
	@Autowired
	private TurmaColetivaRepositorio turmaRepositorio;
	
	@Autowired
	private DescontoRepositorio descontoRepositorio;
	
	@Autowired
	private FluxoCaixaRepositorio fluxoRepositorio;
	
	@Autowired
	private MensalidadeDAO mDAO;
	
	@Autowired
	private MatriculaDAO matriculaDAO;
	
	@Autowired
	private MesReferenciaDAO mesDAO;
	
	@Autowired
	private FluxoCaixaDAO fluxoDAO;
	
	public Mensalidade getMensalidade( Matricula matricula) throws ParseException{
		CadastroMensalidadeDTO cadastro = new CadastroMensalidadeDTO();
		cadastro.setIdMatricula(matricula.getId());
		
		return new Mensalidade( cadastro, this);
	}
	
	public Mensalidade getMensalidade(Long idMensalidade) throws ParseException {
		MensalidadeDO mensalidadeDO = mDAO.findOne(idMensalidade);
		CadastroMensalidadeDTO cadastro = new CadastroMensalidadeDTO();
		cadastro.setId(mensalidadeDO.getId());
		cadastro.setIdMatricula(mensalidadeDO.getMatricula().getId());
		cadastro.setIdMesReferecia(mensalidadeDO.getMesReferencia().getId());
		return new Mensalidade(cadastro, this);
	}
	
	
	protected void cadastrar(Mensalidade mensalidade) {
		MensalidadeDO mdo = new MensalidadeDO();
		mdo.setDataVencimento(mensalidade.getDataVencimento());
		mdo.setMatricula(matriculaDAO.findOne(mensalidade.getIdMatricula()));
		mdo.setMesReferencia(mesDAO.findOne(mensalidade.getMes().getId()));
		mdo.setValorMensalidade(mensalidade.getValor());
		
		mDAO.save(mdo);
		
	}

	protected TurmaColetiva getTurmaColetiva(Long idTurma) throws ParseException {
		return turmaRepositorio.getTurma(idTurma);
	}

	protected Desconto getDesconto(Long idDesconto) {
		return descontoRepositorio.getDesconto(idDesconto);
	}

	protected Matricula getMatricula(Long idMatricula) {

		return matriculaRepositorio.getMatricula(idMatricula);
	}

	protected Long getQtdMensalidades(Long idMatricula) {
		return mDAO.getQtdMensalidades(idMatricula);
	}
	
	protected FluxoCaixa getFluxo(Double valor){
		return this.fluxoRepositorio.getFluxoPagamentoMensalidade(valor);
	}

	protected void atualizarPagamento(Mensalidade mensalidade) {
		MensalidadeDO mensalidadeDO = mDAO.findOne(mensalidade.getId());
		mensalidadeDO.setPagamentoMensalidade(fluxoDAO.findOne(mensalidade.getPagamento().getIdFluxo()));
		mDAO.save(mensalidadeDO);
		
	}

	protected MesReferencia getMesAtual() {
		return this.mesRepositorio.getMesAtual();
	}

	protected MesReferencia getMes(Long idMesReferencia) {
		return this.mesRepositorio.getMes(idMesReferencia);
	}

	protected Long getQtdMensalidadeMes(Long idMatricula, Long idMes) {
		return this.mDAO.getQtdMensalidadeMes(idMatricula, idMes);
		
	}
	
}
