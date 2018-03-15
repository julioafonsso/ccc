package br.com.julios.ccc.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.TaxasPagasDAO;
import br.com.julios.ccc.infra.bd.model.AlunoDO;
import br.com.julios.ccc.infra.bd.model.FluxoCaixaDO;
import br.com.julios.ccc.infra.bd.model.TaxasPagasDO;

@Service
public class TaxasPagasRepositorio {

	
	@Autowired
	private TaxasPagasDAO taxasDAO;
	
	public TaxasPagasDO getTaxaPaga(AlunoDO aluno, FluxoCaixaDO pagamento) {
		
		TaxasPagasDO taxa = new TaxasPagasDO();
		
		taxa.setAluno(aluno);
		taxa.setPagamento(pagamento);
		
		return taxa;
	}

	public void cadastrar(TaxasPagasDO taxasPagasDO) {
		this.taxasDAO.save(taxasPagasDO);
		
	}
}
