package br.com.julios.ccc.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.domains.Descontos;
import br.com.julios.ccc.negocio.DescontosApi;

@Service
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
	
}
