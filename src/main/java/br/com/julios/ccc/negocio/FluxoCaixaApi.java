
package br.com.julios.ccc.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.FluxoCaixaDAO;
import br.com.julios.ccc.infra.bd.daos.TipoFluxoCaixaDAO;
import br.com.julios.ccc.infra.bd.model.AlunoDO;
import br.com.julios.ccc.infra.bd.model.FluxoCaixaDO;
import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.bd.model.MensalidadeDO;
import br.com.julios.ccc.infra.bd.model.TurmaDO;

@Service
public class FluxoCaixaApi {

	@Autowired
	FluxoCaixaDAO fluxoCaixaDAO;
	
	@Autowired 
	TipoFluxoCaixaDAO tipoFluxoCaixaDAO;

	public Iterable<FluxoCaixaDO> getFluxosCaixa() {
		return fluxoCaixaDAO.findAll();
	}

	public FluxoCaixaDO cadastrarFluxoCaixa(FluxoCaixaDO fluxoCaixa) {
//		if (!fluxoCaixa.getTipoFluxo().isIndEntrada())
//			fluxoCaixa.setValor(fluxoCaixa.getValor() * -1);
//		
//		if(fluxoCaixa.getQuantidade() < 1)
//			fluxoCaixa.setQuantidade(1);
//		
//		fluxoCaixaDAO.save(fluxoCaixa);
//		return fluxoCaixa;
	return null;
	}
	

	public FluxoCaixaDO cadastrarFluxoCaixaPagamentoMensalidade(MensalidadeDO mensalidade) throws Exception{
		
		
//		TipoFluxoCaixaDO tipoFluxoMensalidade = tipoFluxoCaixaDAO.findOne(TipoFluxoCaixaDO.MENSALIDADE);
//		
//		FluxoCaixaDO fluxo = new FluxoCaixaDO();
//		fluxo.setData(new Date());
//		fluxo.setDescricao("Recebimento Mensalidade Aluno : " + mensalidade.getMatricula().getAluno().getNome());
//		fluxo.setObservacao("Mensalidade do Mês :" + mensalidade.getMesReferencia().getNomeMes()  + "  de " +  mensalidade.getMesReferencia().getAno());
//		fluxo.setTipoFluxo(tipoFluxoMensalidade);
//		fluxo.setValor(mensalidade.getValorParaPagar());
//
//		return cadastrarFluxoCaixa(fluxo);
		return null;
	}
	
	public FluxoCaixaDO cadastrarFluxoCaixaAulaParticular(MensalidadeDO mensalidade, Integer qtdAulas) throws Exception{

//		TipoFluxoCaixaDO tipoFluxoMensalidade = tipoFluxoCaixaDAO.findOne(TipoFluxoCaixaDO.AULA_PARTICULAR);
//		
//		FluxoCaixaDO fluxo = new FluxoCaixaDO();
//		fluxo.setData(new Date());
//		fluxo.setDescricao("Aula Particular Aluno : " + mensalidade.getMatricula().getAluno().getNome());
//		fluxo.setObservacao("");
//		fluxo.setTipoFluxo(tipoFluxoMensalidade);
//		fluxo.setQuantidade(qtdAulas);
//		fluxo.setValor(mensalidade.getValorParaPagar());
//
//		return cadastrarFluxoCaixa(fluxo);
		return null;
	}

	public void atualizarFluxoCaixa(FluxoCaixaDO fluxoCaixa) {
		fluxoCaixaDAO.save(fluxoCaixa);
	}

	public void apagarFluxoCaixa(FluxoCaixaDO fluxoCaixa) {
		fluxoCaixaDAO.delete(fluxoCaixa);
	}

	public FluxoCaixaDO cadastrarFluxoCaixaPagamentoProfessor(FuncionarioDO professor, Double valor) {
//		TipoFluxoCaixaDO tipoFluxoPagamentoProfessor = tipoFluxoCaixaDAO.findOne(TipoFluxoCaixaDO.PAGAMENTO_PROFESSOR);
//		
//
//		FluxoCaixaDO fluxo = new FluxoCaixaDO();
//		fluxo.setData(new Date());
//		fluxo.setDescricao("Pagamento Professor: " + professor.getNome());
//		fluxo.setTipoFluxo(tipoFluxoPagamentoProfessor);
//		fluxo.setValor(valor);
//
//		return cadastrarFluxoCaixa(fluxo);
		return null;
	}

	public FluxoCaixaDO lancamentoMatricula(AlunoDO aluno, TurmaDO turma, Double valor) {
//		TipoFluxoCaixaDO tipoFluxoMatricula = tipoFluxoCaixaDAO.findOne(TipoFluxoCaixaDO.MATRICULA);
//		FluxoCaixaDO fluxo = new FluxoCaixaDO();
//		fluxo.setData(new Date());
//		fluxo.setDescricao("Matricula do Aluno: " + aluno.getNome() + " - Turma Codigo: " + turma.getCodigo());
//		fluxo.setTipoFluxo(tipoFluxoMatricula);
//		fluxo.setValor(valor);
//
//		return cadastrarFluxoCaixa(fluxo);

		return null;
		
	}

	public FluxoCaixaDO getFluxo(Long idFluxo) {
		return fluxoCaixaDAO.findOne(idFluxo);
	}

}
