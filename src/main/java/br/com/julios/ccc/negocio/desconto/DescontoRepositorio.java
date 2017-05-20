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
	
	public Desconto getDesconto(DescontoDTO cadastro){
		return new Desconto(cadastro, this);
	}

	protected void cadastrar(Desconto desconto) {
		DescontosDO descontoDO = new DescontosDO();
		descontoDO.setNome(desconto.getNome());
		descontoDO.setValor(desconto.getValor());
		descontoDAO.save(descontoDO);
		
	}

	public Desconto getDesconto(Long idDesconto) {
		DescontosDO dDO = null;
		
		if(idDesconto != null)
			dDO = descontoDAO.findOne(idDesconto);
		
		DescontoDTO dto = new DescontoDTO();
		if(dDO != null)
		{
			dto.setId(dDO.getId());
			dto.setNome(dDO.getNome());
			dto.setValor(dDO.getValor());
		}
		
		return getDesconto(dto);
	}
	
}
