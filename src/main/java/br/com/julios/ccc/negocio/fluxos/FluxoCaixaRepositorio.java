package br.com.julios.ccc.negocio.fluxos;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.FluxoCaixaDAO;
import br.com.julios.ccc.infra.bd.daos.TipoFluxoCaixaDAO;
import br.com.julios.ccc.infra.bd.model.FluxoCaixaDO;
import br.com.julios.ccc.infra.bd.model.TipoFluxoCaixaDO;
import br.com.julios.ccc.infra.dto.CadastroFluxoCaixaDTO;
import br.com.julios.ccc.negocio.mensalidade.Mensalidade;

@Service
public class FluxoCaixaRepositorio {

	@Autowired
	FluxoCaixaDAO fluxoDAO;
	
	@Autowired
	TipoFluxoCaixaDAO tipoFluxoDAO;
	
	public FluxoCaixa getFluxoPagamentoMatricula(CadastroFluxoCaixaDTO cadastro){
		 cadastro.setIdTipo(TipoFluxoCaixaDO.MATRICULA);
		 return getFluxo(cadastro);
	}

	public FluxoCaixa getFluxo(CadastroFluxoCaixaDTO cadastro){
		return  new FluxoCaixa(cadastro, this);
	}
	
	protected void cadastrar(FluxoCaixa fluxoPagamento) {
		FluxoCaixaDO fluxoDO = new FluxoCaixaDO();
		fluxoDO.setValor(fluxoPagamento.getValorFluxo());
		fluxoDO.setData(fluxoPagamento.getDataFluxo());
		fluxoDO.setQuantidade(fluxoPagamento.getQtd());
		fluxoDO.setDescricao(fluxoPagamento.getDescricao());
		fluxoDO.setObservacao(fluxoPagamento.getObservacao());
		fluxoDO.setTipoFluxo(tipoFluxoDAO.findOne(fluxoPagamento.getIdTipoFluxo()));
		fluxoDAO.save(fluxoDO);
		
		fluxoPagamento.setIdFluxo(fluxoDO.getId());
		
	}

	public FluxoCaixa getPagamentoMensalidade(Mensalidade mensalidade, Double valor) throws Exception {
			CadastroFluxoCaixaDTO cadastro = new CadastroFluxoCaixaDTO();
			cadastro.setIdTipo(TipoFluxoCaixaDO.MENSALIDADE);
			cadastro.setData(new Date());
			cadastro.setQtd(new Long(1));
			cadastro.setValor(valor);
			cadastro.setDescricao("Aluno - " + mensalidade.getMatricula().getAluno().getNome());
			cadastro.setObservacao("Mes Referencia " + mensalidade.getMes().getNomeMes() + " " + mensalidade.getMes().getAno());
			return this.getFluxo(cadastro);
		}
	
	public FluxoCaixa getPagamentoAulaParticular(String aluno, Long qtdAulas, Double valor) throws Exception {
		CadastroFluxoCaixaDTO cadastro = new CadastroFluxoCaixaDTO();
		cadastro.setIdTipo(TipoFluxoCaixaDO.AULA_PARTICULAR);
		cadastro.setData(new Date());
		cadastro.setQtd(new Long(qtdAulas));
		cadastro.setValor(valor);
		cadastro.setDescricao("Aluno - " + aluno);
//		cadastro.setObservacao("Quantidade de Aulas : " +  qtdAulas);
		return this.getFluxo(cadastro);
	}
	}

	
	
