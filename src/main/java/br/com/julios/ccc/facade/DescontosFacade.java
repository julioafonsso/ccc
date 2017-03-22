package br.com.julios.ccc.facade;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.julios.ccc.domains.Descontos;
import br.com.julios.ccc.negocio.DescontosApi;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class DescontosFacade {

	@Autowired
	DescontosApi descontosApi;
	
	public Iterable<Descontos> getdescontos(){
		return descontosApi.getdescontos();
	}
	
	public void cadastrarDesconto(Descontos desconto){
		descontosApi.cadastrar(desconto);
	}

	public Descontos getdesconto(Long id) {
		return descontosApi.getdesconto(id);
	}

	public void alterarDesconto(Descontos desconto) {
		descontosApi.alterar(desconto);
	}

	public void deletar(Long id) throws Exception {
		Descontos desconto = descontosApi.getdesconto(id);
		descontosApi.validaExisteDescontoMatriculaAtiva(desconto);
		descontosApi.deletar(desconto);
	}
	
}
