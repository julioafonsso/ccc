package br.com.julios.ccc.negocio;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.TipoFluxoCaixaDAO;
import br.com.julios.ccc.infra.bd.model.TipoFluxoCaixaDO;

@Service
public class TipoFluxoCaixaApi {
	
//	@Autowired
	TipoFluxoCaixaDAO tipoFluxoCaixaDAO;

	public Iterable<TipoFluxoCaixaDO> getTipoFluxoCaixa() 
	{
//		return tipoFluxoCaixaDAO.findByDataExclusaoIsNull();
		return null;
	}

	public void cadastrarTipoFluxoCaixa(TipoFluxoCaixaDO tipoFluxoCaixa) 
	{
		tipoFluxoCaixaDAO.save(tipoFluxoCaixa);
		
	}

	public void atualizarTipoFluxoCaixa(TipoFluxoCaixaDO tipoFluxoCaixa) 
	{
		tipoFluxoCaixaDAO.save(tipoFluxoCaixa);
				
	}

	public void apagarTipoFluxoCaixa(TipoFluxoCaixaDO tipoFluxoCaixa) 
	{
		
	}

	public Iterable<TipoFluxoCaixaDO> getTipoFluxoCaixaEntrada() {
//		return tipoFluxoCaixaDAO.findByIndEntradaAndDataExclusaoIsNull(true);
		return null;
	}

	public Iterable<TipoFluxoCaixaDO> getTipoFluxoCaixaSaida() {
//		return tipoFluxoCaixaDAO.findByIndEntradaAndDataExclusaoIsNull(false);
		return null;
	}

	public TipoFluxoCaixaDO getTipoFluxoCaixa(Long id) {
		return tipoFluxoCaixaDAO.findOne(id);
	}


}
