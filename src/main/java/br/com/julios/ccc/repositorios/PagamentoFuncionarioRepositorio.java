package br.com.julios.ccc.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.SalarioDAO;
import br.com.julios.ccc.infra.bd.daos.ValeTransporteDAO;
import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.bd.model.MesReferenciaDO;
import br.com.julios.ccc.infra.bd.model.SalarioDO;
import br.com.julios.ccc.infra.bd.model.ValeTransporteDO;

@Service
public class PagamentoFuncionarioRepositorio {

	@Autowired
	SalarioDAO salarioDAO;
	
	@Autowired
	ValeTransporteDAO valeDAO;
	
	public SalarioDO getSalario(FuncionarioDO func, MesReferenciaDO mes)
	{
		SalarioDO pagamento = new SalarioDO();
		pagamento.setFuncionario(func);
		pagamento.setMesReferencia(mes);
		return pagamento;
	}
	
	public ValeTransporteDO getValeTransporte(FuncionarioDO func, MesReferenciaDO mes)
	{
		ValeTransporteDO pagamento = new ValeTransporteDO();
		pagamento.setFuncionario(func);
		pagamento.setMesReferencia(mes);
		return pagamento;
	}

	public void cadastrar(SalarioDO salarioDO) {
		this.salarioDAO.save(salarioDO);
	}
	
	public void cadastrar(ValeTransporteDO valeDO) {
		this.valeDAO.save(valeDO);
	}
	
}
