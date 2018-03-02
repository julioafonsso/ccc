package br.com.julios.ccc.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.FluxoCaixaDAO;
import br.com.julios.ccc.infra.bd.daos.TipoFluxoCaixaDAO;
import br.com.julios.ccc.infra.bd.model.TipoFluxoCaixaDO;
import br.com.julios.ccc.infra.dto.fluxo_caixa.CadastroTipoFluxoDTO;

@Service
public class TipoFluxoRepositorio {

	@Autowired
	private TipoFluxoCaixaDAO tipoFluxoDAO;

	@Autowired
	private FluxoCaixaDAO fluxoDAO;
	
	public TipoFluxoCaixaDO get(Long id) {
		return this.tipoFluxoDAO.findOne(id);
	}

	public TipoFluxoCaixaDO get(CadastroTipoFluxoDTO cadastro) throws Exception {
		TipoFluxoCaixaDO tipo = new TipoFluxoCaixaDO();
		tipo.setIndEntrada(cadastro.isIndEntrada());
		tipo.setNome(cadastro.getNome());
		return tipo;
	}

	public TipoFluxoCaixaDO get(String nome, boolean indEntrada) {
		return this.tipoFluxoDAO.get(nome, indEntrada);
	}

	public void cadastrar(TipoFluxoCaixaDO tipoFluxoCaixaDO) {
		this.tipoFluxoDAO.save(tipoFluxoCaixaDO);
	}

	public Long getQtdFluxoCadastrados(TipoFluxoCaixaDO tipoFluxoCaixaDO) {
		return this.fluxoDAO.getQtdFluxoCadastrados(tipoFluxoCaixaDO);
	}

	
}
