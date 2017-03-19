package br.com.julios.ccc.negocio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.DescontosDAO;
import br.com.julios.ccc.domains.Descontos;

@Service
public class DescontosApi {
	
	@Autowired
	DescontosDAO descontosDAO;
	
	public Iterable<Descontos> getdescontos() {
		return descontosDAO.findAll();
}

	public void cadastrar(Descontos desconto) {
		descontosDAO.save(desconto);
	}

	public Descontos getdesconto(Long id) {
		return descontosDAO.findOne(id);
	}

	public void alterar(Descontos desconto) {
		descontosDAO.save(desconto);
	}

}
