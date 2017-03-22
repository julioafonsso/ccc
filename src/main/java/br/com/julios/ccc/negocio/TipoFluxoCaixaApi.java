package br.com.julios.ccc.negocio;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.TipoFluxoCaixaDAO;
import br.com.julios.ccc.domains.TipoFluxoCaixa;

@Service
public class TipoFluxoCaixaApi {
	
	@Autowired
	TipoFluxoCaixaDAO tipoFluxoCaixaDAO;

	public Iterable<TipoFluxoCaixa> getTipoFluxoCaixa() 
	{
		return tipoFluxoCaixaDAO.findByDataExclusaoIsNull();
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
		tipoFluxoCaixa.setDataExclusao(new Date());
		tipoFluxoCaixaDAO.save(tipoFluxoCaixa);
		
	}

	public Iterable<TipoFluxoCaixa> getTipoFluxoCaixaEntrada() {
		return tipoFluxoCaixaDAO.findByIndEntradaAndDataExclusaoIsNull(true);
	}

	public Iterable<TipoFluxoCaixa> getTipoFluxoCaixaSaida() {
		return tipoFluxoCaixaDAO.findByIndEntradaAndDataExclusaoIsNull(false);
	}

	public TipoFluxoCaixa getTipoFluxoCaixa(Long id) {
		return tipoFluxoCaixaDAO.findOne(id);
	}


}
