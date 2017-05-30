package br.com.julios.ccc.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.DescontoDAO;
import br.com.julios.ccc.infra.bd.daos.MatriculaDAO;
import br.com.julios.ccc.infra.bd.model.DescontosDO;
import br.com.julios.ccc.infra.dto.DescontoDTO;

@Service
public class DescontoRepositorio {

	@Autowired
	private DescontoDAO descontoDAO;
	
	@Autowired
	private  MatriculaDAO matriculaDAO;
	
	public DescontosDO getDesconto(DescontoDTO cadastro) throws Exception{
		DescontosDO desconto = new DescontosDO();
		desconto.setNome(cadastro.getNome());
		desconto.setValor(cadastro.getValor());
		return desconto;
	}

	public void cadastrar(DescontosDO desconto) {
		
		this.descontoDAO.save(desconto);
		
	}

	public DescontosDO getDesconto(Long idDesconto) {
		
		return this.descontoDAO.findOne(idDesconto);
	}

	public DescontosDO getDesconto(String nome) {
		return this.descontoDAO.getDesconto(nome);
	}

	public Long getQtdMatriculas(DescontosDO descontosDO) {
		return this.matriculaDAO.getQtdMatriculas(descontosDO);
	}
	
}
