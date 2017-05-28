package br.com.julios.ccc.negocio.desconto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.DescontoDAO;
import br.com.julios.ccc.infra.bd.model.DescontosDO;
import br.com.julios.ccc.infra.dto.DescontoDTO;

@Service
public class DescontoRepositorio {

	@Autowired
	DescontoDAO descontoDAO;
	
	public DescontosDO getDesconto(DescontoDTO cadastro){
		DescontosDO desconto = new DescontosDO();
		desconto.setNome(cadastro.getNome());
		desconto.setValor(cadastro.getValor());
		return desconto;
	}

	public void cadastrar(DescontosDO desconto) {
		
		descontoDAO.save(desconto);
		
	}

	public DescontosDO getDesconto(Long idDesconto) {
		
		return descontoDAO.findOne(idDesconto);
	}
	
}
