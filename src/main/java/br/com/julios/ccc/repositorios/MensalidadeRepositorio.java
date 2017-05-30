package br.com.julios.ccc.repositorios;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.MensalidadeDAO;
import br.com.julios.ccc.infra.bd.model.MatriculaDO;
import br.com.julios.ccc.infra.bd.model.MensalidadeDO;
import br.com.julios.ccc.infra.bd.model.MesReferenciaDO;

@Service
public class MensalidadeRepositorio {

//	@Autowired
//	private MatriculaRepositorio matriculaRepositorio;
	
	@Autowired
	private MesRerefenciaRepositorio mesRepositorio;
	
	@Autowired
	private MensalidadeDAO mDAO;
	
//	@Autowired
//	private MatriculaDAO matriculaDAO;
//	
//	@Autowired
//	private MesReferenciaDAO mesDAO;
//	
//	@Autowired
//	private FluxoCaixaDAO fluxoDAO;
//	
	public MensalidadeDO getMensalidade( MatriculaDO matricula) throws ParseException{
		return getMensalidade(matricula, this.mesRepositorio.getMesAtual());
	}
	
	public MensalidadeDO getMensalidade( MatriculaDO matricula, MesReferenciaDO mes) throws ParseException{
		MensalidadeDO mensalidade = new MensalidadeDO();
		mensalidade.setMatricula(matricula);
		mensalidade.setMesReferencia(mes);
		return mensalidade;
	}
	
	public MensalidadeDO getMensalidade(Long idMensalidade) throws ParseException {
		MensalidadeDO mensalidade = mDAO.findOne(idMensalidade);
		return mensalidade;
	}
	
	
	public void cadastrar(MensalidadeDO mensalidade) {
		
		mDAO.save(mensalidade);
	}
//	
//	protected Long getQtdMensalidades(Long idMatricula) {
//		return this.mDAO.getQtdMensalidades(idMatricula);
//	}
//
//	protected void atualizarPagamento(Mensalidade mensalidade) {
//		MensalidadeDO mensalidadeDO = mDAO.findOne(mensalidade.getId());
//		mensalidadeDO.setPagamentoMensalidade(fluxoDAO.findOne(mensalidade.getPagamento().getIdFluxo()));
//		mensalidadeDO.setDesconto(matriculaDAO.findOne(mensalidade.getIdMatricula()).getDesconto());
//		this.mDAO.save(mensalidadeDO);
//		
//	}
//
//	protected MesReferencia getMesAtual() {
//		return this.mesRepositorio.getMesAtual();
//	}
//
//	protected MesReferencia getMes(Long idMesReferencia) {
//		return this.mesRepositorio.getMes(idMesReferencia);
//	}
//
//	protected Long getQtdMensalidadeMes(Long idMatricula, Long idMes) {
//		return this.mDAO.getQtdMensalidadeMes(idMatricula, idMes);
//		
//	}

	public Long getQtdMensalidadeMes(MatriculaDO matricula, MesReferenciaDO mesReferencia) {
		return this.mDAO.getQtdMensalidadeMes(matricula.getId(), mesReferencia.getId());
	}

	
}
