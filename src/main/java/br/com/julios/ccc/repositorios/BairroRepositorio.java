package br.com.julios.ccc.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.BairroDAO;
import br.com.julios.ccc.infra.bd.model.BairroDO;
import br.com.julios.ccc.infra.dto.bairro.CadastroBairroDTO;

@Service
public class BairroRepositorio {

	@Autowired
	BairroDAO bairroDAO;
	
	public BairroDO getBairro(CadastroBairroDTO cadastro) throws Exception
	{
		
		BairroDO bairro = new BairroDO();
		bairro.setNome(cadastro.getNome());
		bairro.setZona(cadastro.getZona());
		return bairro;
	}

	public void cadastrar(BairroDO bairro) {
		bairroDAO.save(bairro);
		
	}

	public BairroDO getBairro(String nome) {
		return this.bairroDAO.getBairroPorNome(nome);
	}
}
