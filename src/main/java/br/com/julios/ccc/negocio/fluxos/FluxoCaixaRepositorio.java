package br.com.julios.ccc.negocio.fluxos;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.FluxoCaixaDAO;
import br.com.julios.ccc.infra.bd.daos.TipoFluxoCaixaDAO;
import br.com.julios.ccc.infra.bd.model.FluxoCaixaDO;
import br.com.julios.ccc.infra.bd.model.MatriculaDO;
import br.com.julios.ccc.infra.bd.model.MensalidadeDO;
import br.com.julios.ccc.infra.bd.model.TipoFluxoCaixaDO;
import br.com.julios.ccc.infra.dto.fluxo_caixa.CadastroFluxoCaixaDTO;

@Service
public class FluxoCaixaRepositorio {

	@Autowired
	FluxoCaixaDAO fluxoDAO;

	@Autowired
	TipoFluxoCaixaDAO tipoFluxoDAO;

	public FluxoCaixaDO getFluxoPagamentoMatricula(MatriculaDO matricula, Double valor) {
		if(valor != null && valor.longValue() > 0)
		{
			FluxoCaixaDO pagamento = new FluxoCaixaDO();
			pagamento.setData(matricula.getDataMatricula());
			pagamento.setDescricao(("Aluno : " + matricula.getNomeAluno()));
			pagamento.setValor(valor);
			pagamento.setTipoFluxo(tipoFluxoDAO.findOne(TipoFluxoCaixaDO.MATRICULA));
			return pagamento;
		}
		return null;
	}

	public FluxoCaixaDO getFluxo(CadastroFluxoCaixaDTO cadastro) {
		FluxoCaixaDO pagamento = new FluxoCaixaDO();
		pagamento.setData(cadastro.getData());
		pagamento.setDescricao(cadastro.getDescricao());
		pagamento.setObservacao(cadastro.getObservacao());
		pagamento.setValor(cadastro.getValor());
		pagamento.setTipoFluxo(tipoFluxoDAO.findOne(cadastro.getIdTipo()));
		return pagamento;

	}

	public void cadastrar(FluxoCaixaDO fluxoCaixaDO) {
		fluxoDAO.save(fluxoCaixaDO);
	}

	public FluxoCaixaDO getPagamentoMensalidade(MensalidadeDO mensalidade, Double valor) throws Exception {
		CadastroFluxoCaixaDTO cadastro = new CadastroFluxoCaixaDTO();
		cadastro.setIdTipo(TipoFluxoCaixaDO.MENSALIDADE);
		cadastro.setData(new Date());
		cadastro.setQtd(new Long(1));
		cadastro.setValor(valor);
		cadastro.setDescricao("Aluno - " + mensalidade.getNomeAluno() );
		cadastro.setObservacao(
				"Mes Referencia " + mensalidade.getMesReferencia().getNomeMes() + " " + mensalidade.getMesReferencia().getAno());
		return this.getFluxo(cadastro);
	}

	public FluxoCaixaDO getPagamentoWorkShop(MensalidadeDO mensalidade) throws Exception {
		CadastroFluxoCaixaDTO cadastro = new CadastroFluxoCaixaDTO();
		cadastro.setIdTipo(TipoFluxoCaixaDO.WORKSHOP);
		cadastro.setData(new Date());
		cadastro.setQtd(new Long(1));
		cadastro.setValor(mensalidade.getValorMensalidade());
		cadastro.setDescricao("Aluno - " + mensalidade.getNomeAluno());
		return this.getFluxo(cadastro);
	}
	
	public FluxoCaixaDO getPagamentoAulaParticular(String aluno, Long qtdAulas, Double valor) throws Exception {
		CadastroFluxoCaixaDTO cadastro = new CadastroFluxoCaixaDTO();
		cadastro.setIdTipo(TipoFluxoCaixaDO.AULA_PARTICULAR);
		cadastro.setData(new Date());
		cadastro.setQtd(new Long(qtdAulas));
		cadastro.setValor(valor);
		cadastro.setDescricao("Aluno - " + aluno);
		return this.getFluxo(cadastro);
	}

}
