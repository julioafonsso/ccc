package br.com.julios.ccc.negocio.bairro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.BairroDAO;
import br.com.julios.ccc.infra.bd.model.BairroDO;
import br.com.julios.ccc.infra.dto.bairro.CadastroBairroDTO;

@Service
public class BairroRepositorio {

	@Autowired
	BairroDAO bairroDAO;
	
	public Bairro getBairro(CadastroBairroDTO cadastro)
	{
		return new Bairro(cadastro, this);
	}

	protected void cadastrar(Bairro bairro) {
		BairroDO b = new BairroDO();
		b.setNome(bairro.getNome());
		b.setZona(bairro.getZona());
		
		bairroDAO.save(b);
		
	}
}
