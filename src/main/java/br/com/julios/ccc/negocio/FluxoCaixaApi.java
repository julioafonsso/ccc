package br.com.julios.ccc.negocio;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.FluxoCaixaDAO;
import br.com.julios.ccc.daos.TipoFluxoCaixaDAO;
import br.com.julios.ccc.domains.FluxoCaixa;
import br.com.julios.ccc.domains.Mensalidades;
import br.com.julios.ccc.domains.Professor;
import br.com.julios.ccc.domains.TipoFluxoCaixa;

@Service
public class FluxoCaixaApi {

	@Autowired
	FluxoCaixaDAO fluxoCaixaDAO;
	
	@Autowired 
	TipoFluxoCaixaDAO tipoFluxoCaixaDAO;

	public Iterable<FluxoCaixa> getFluxosCaixa() {
		return fluxoCaixaDAO.findAll();
	}

	public FluxoCaixa cadastrarFluxoCaixa(FluxoCaixa fluxoCaixa) {
		if (!fluxoCaixa.getTipoFluxo().isIndEntrada())
			fluxoCaixa.setValor(fluxoCaixa.getValor() * -1);
		
		fluxoCaixaDAO.save(fluxoCaixa);
		return fluxoCaixa;
	}

	public FluxoCaixa cadastrarFluxoCaixaPagamentoMensalidade(Mensalidades mensalidade) throws Exception{
		
		
		TipoFluxoCaixa tipoFluxoMensalidade = tipoFluxoCaixaDAO.findOne(TipoFluxoCaixa.MENSALIDADE);
		
		FluxoCaixa fluxo = new FluxoCaixa();
		fluxo.setData(new Date());
		fluxo.setDescricao("Recebimento Mensalidade Aluno : " + mensalidade.getMatricula().getAluno().getNome());
		fluxo.setTipoFluxo(tipoFluxoMensalidade);
		fluxo.setValor(mensalidade.getValorCalculado());

		return cadastrarFluxoCaixa(fluxo);
	}

	public void atualizarFluxoCaixa(FluxoCaixa fluxoCaixa) {
		fluxoCaixaDAO.save(fluxoCaixa);
	}

	public void apagarFluxoCaixa(FluxoCaixa fluxoCaixa) {
		fluxoCaixaDAO.delete(fluxoCaixa);
	}

	public FluxoCaixa cadastrarFluxoCaixaPagamentoProfessor(Professor professor, Double valor) {
		TipoFluxoCaixa tipoFluxoPagamentoProfessor = tipoFluxoCaixaDAO.findOne(TipoFluxoCaixa.PAGAMENTO_PROFESSOR);
		

		FluxoCaixa fluxo = new FluxoCaixa();
		fluxo.setData(new Date());
		fluxo.setDescricao("Pagamento Professor: " + professor.getNome());
		fluxo.setTipoFluxo(tipoFluxoPagamentoProfessor);
		fluxo.setValor(valor);

		return cadastrarFluxoCaixa(fluxo);

	}

}
