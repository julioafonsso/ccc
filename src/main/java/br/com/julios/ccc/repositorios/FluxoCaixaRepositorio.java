package br.com.julios.ccc.repositorios;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.FluxoCaixaDAO;
import br.com.julios.ccc.infra.bd.daos.TipoFluxoCaixaDAO;
import br.com.julios.ccc.infra.bd.model.AlunoDO;
import br.com.julios.ccc.infra.bd.model.ComissaoProfessorDO;
import br.com.julios.ccc.infra.bd.model.FluxoCaixaDO;
import br.com.julios.ccc.infra.bd.model.MatriculaDO;
import br.com.julios.ccc.infra.bd.model.MensalidadeDO;
import br.com.julios.ccc.infra.bd.model.MesReferenciaDO;
import br.com.julios.ccc.infra.bd.model.PagamentoFuncionariosDO;
import br.com.julios.ccc.infra.bd.model.TipoFluxoCaixaDO;
import br.com.julios.ccc.infra.dto.fluxo_caixa.CadastroFluxoCaixaDTO;

@Service
public class FluxoCaixaRepositorio {

	@Autowired
	FluxoCaixaDAO fluxoDAO;

	@Autowired
	TipoFluxoCaixaDAO tipoFluxoDAO;
	
	public TipoFluxoCaixaDO getTipo(Long id)
	{
		return this.tipoFluxoDAO.findOne(id);
	}

	public FluxoCaixaDO getFluxoPagamentoMatricula(MatriculaDO matricula, Double valor, String observacao) throws ParseException {
		FluxoCaixaDO pagamento = new FluxoCaixaDO();
		pagamento.setData(matricula.getDataMatricula());
		pagamento.setDescricao((matricula.getNomeAluno() +  matricula.getCodigoTurma() + " - " + matricula.getNomeModalidade()));
		pagamento.setObservacao(observacao);
		pagamento.setTipoFluxo(tipoFluxoDAO.findOne(TipoFluxoCaixaDO.MATRICULA));
		if (valor != null && valor.longValue() > 0)
			pagamento.setValor(valor);
		else
			pagamento.setValor(new Double(0));
		return pagamento;
	}

	public FluxoCaixaDO getFluxo(CadastroFluxoCaixaDTO cadastro) throws ParseException {
		FluxoCaixaDO pagamento = new FluxoCaixaDO();
		pagamento.setData(cadastro.getData());
		pagamento.setDescricao(cadastro.getDescricao());
		pagamento.setObservacao(cadastro.getObservacao());
		pagamento.setValor(cadastro.getValor());
		pagamento.setTipoFluxo(tipoFluxoDAO.findOne(cadastro.getIdTipo()));
		pagamento.setQuantidade(cadastro.getQtd());
		return pagamento;

	}

	public void cadastrar(FluxoCaixaDO fluxoCaixaDO) {
		fluxoDAO.save(fluxoCaixaDO);
	}

	public FluxoCaixaDO getPagamentoMensalidade(MensalidadeDO mensalidade, Double valor, String observacao)
			throws Exception {
		CadastroFluxoCaixaDTO cadastro = new CadastroFluxoCaixaDTO();
		cadastro.setIdTipo(TipoFluxoCaixaDO.MENSALIDADE);
		cadastro.setData(new Date());
		cadastro.setQtd(new Long(1));
		cadastro.setValor(valor);
		cadastro.setDescricao(mensalidade.getNomeAluno() + "  -   " + mensalidade.getCodigoTurma() + " - "
				+ mensalidade.getNomeModalidade() + " - " + mensalidade.getMesReferencia().getMesFormatado());
		cadastro.setObservacao(observacao);
		return this.getFluxo(cadastro);
	}

	public FluxoCaixaDO getPagamentoWorkShop(MensalidadeDO mensalidade) throws Exception {
		CadastroFluxoCaixaDTO cadastro = new CadastroFluxoCaixaDTO();
		cadastro.setIdTipo(TipoFluxoCaixaDO.WORKSHOP);
		cadastro.setData(new Date());
		cadastro.setQtd(new Long(1));
		cadastro.setValor(mensalidade.getValorMensalidade());
		cadastro.setDescricao(mensalidade.getNomeAluno());
		return this.getFluxo(cadastro);
	}

	public FluxoCaixaDO getPagamentoAulaParticular(String aluno, Long qtdAulas, Double valor, String observacao)
			throws Exception {
		CadastroFluxoCaixaDTO cadastro = new CadastroFluxoCaixaDTO();
		cadastro.setIdTipo(TipoFluxoCaixaDO.AULA_PARTICULAR);
		cadastro.setData(new Date());
		cadastro.setQtd(new Long(qtdAulas));
		cadastro.setValor(valor);
		cadastro.setDescricao(aluno);
		cadastro.setObservacao(observacao);
		return this.getFluxo(cadastro);
	}

	public FluxoCaixaDO getPagamentoComissao(ComissaoProfessorDO comissao) throws ParseException {
		CadastroFluxoCaixaDTO cadastro = new CadastroFluxoCaixaDTO();
		cadastro.setIdTipo(TipoFluxoCaixaDO.PAGAMENTO_PROFESSOR);
		cadastro.setData(new Date());
		cadastro.setQtd(new Long(1));
		cadastro.setValor(comissao.getValor());
		cadastro.setDescricao("Pagamento Professor - " + comissao.getNomeFuncionario());
		cadastro.setObservacao("Mes Referencia: " + comissao.getNomeMes());

		return getFluxo(cadastro);
	}

	public FluxoCaixaDO getPagamentoComissao(MesReferenciaDO mes, String nomeProfessor) throws ParseException {

		CadastroFluxoCaixaDTO cadastro = new CadastroFluxoCaixaDTO();
		cadastro.setIdTipo(TipoFluxoCaixaDO.PAGAMENTO_PROFESSOR);
		cadastro.setData(new Date());
		cadastro.setQtd(new Long(1));
		cadastro.setValor(new Double(0));
		cadastro.setDescricao("Pagamento Professor - " + nomeProfessor);
		cadastro.setObservacao("Mes Referencia: " + mes.getNomeMes());

		return getFluxo(cadastro);
	}

	public FluxoCaixaDO getPagamentoSalario(PagamentoFuncionariosDO salario, Double valor) throws ParseException {

		CadastroFluxoCaixaDTO cadastro = new CadastroFluxoCaixaDTO();
		cadastro.setIdTipo(TipoFluxoCaixaDO.PAGAMENTO_SALARIO);
		cadastro.setData(new Date());
		cadastro.setQtd(new Long(1));
		cadastro.setValor(valor);
		cadastro.setDescricao("Pagamento - " + salario.getNomeFuncionario());
		cadastro.setObservacao("Mes Referencia: " + salario.getMes());

		return getFluxo(cadastro);
	}

	public FluxoCaixaDO getFluxo(Long idFluxo) {
				return fluxoDAO.findOne(idFluxo);
	}

	public FluxoCaixaDO getFluxoPagamentoTaxas(AlunoDO aluno, Double valor, Date dataPagamento, String observacao, Long tipo) throws ParseException {
		CadastroFluxoCaixaDTO cadastro = new CadastroFluxoCaixaDTO();
		cadastro.setIdTipo(tipo);
		cadastro.setData(dataPagamento);
		cadastro.setQtd(new Long(1));
		cadastro.setValor(valor);
		cadastro.setObservacao(observacao);
		cadastro.setDescricao("Aluno : " + aluno.getNome());
		return this.getFluxo(cadastro);
	}

	public FluxoCaixaDO getFluxoPagamentoAulaAvulsa(AlunoDO aluno, Double valor, Date dataPagamento,
			String observacao) throws ParseException {
		CadastroFluxoCaixaDTO cadastro = new CadastroFluxoCaixaDTO();
		cadastro.setIdTipo(TipoFluxoCaixaDO.PAGAMENTO_AULA_AVULSA);
		cadastro.setData(dataPagamento);
		cadastro.setQtd(new Long(1));
		cadastro.setValor(valor);
		cadastro.setObservacao(observacao);
		cadastro.setDescricao("Aluno : " + aluno.getNome());
		return this.getFluxo(cadastro);
	}
	
	
}
