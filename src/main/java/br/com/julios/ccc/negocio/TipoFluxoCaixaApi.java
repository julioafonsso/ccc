package br.com.julios.ccc.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.TipoFluxoCaixaDAO;
import br.com.julios.ccc.domains.TipoFluxoCaixa;

@Service
public class TipoFluxoCaixaApi {
	
	@Autowired
	TipoFluxoCaixaDAO tipoFluxoCaixaDAO;

	public Iterable<TipoFluxoCaixa> gettipoFluxoCaixa() 
	{
				return tipoFluxoCaixaDAO.findAll();
	}

	public void cadastrarTipoFluxoCaixa(TipoFluxoCaixa tipoFluxoCaixa) 
	{
		tipoFluxoCaixaDAO.save(tipoFluxoCaixa);
		
	}

	public void atualizarTipoFluxoCaixa(TipoFluxoCaixa tipoFluxoCaixa) 
	{
		tipoFluxoCaixaDAO.save(tipoFluxoCaixa);
				
	}

	public void apagarTipoFluxoCaixa(TipoFluxoCaixa tipoFluxoCaixa) 
	{
		tipoFluxoCaixaDAO.delete(tipoFluxoCaixa);
		
	}

	public Iterable<TipoFluxoCaixa> gettipoFluxoCaixaEntrada() {
		return tipoFluxoCaixaDAO.findByIndEntrada(true);
	}

	public Iterable<TipoFluxoCaixa> gettipoFluxoCaixaSaida() {
		return tipoFluxoCaixaDAO.findByIndEntrada(false);
	}


}
