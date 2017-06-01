package br.com.julios.ccc.repositorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.bd.daos.ComissaoProfessorDAO;
import br.com.julios.ccc.infra.bd.daos.PagamentoFuncionariosDAO;
import br.com.julios.ccc.infra.bd.daos.SalarioDAO;
import br.com.julios.ccc.infra.bd.daos.ValeTransporteDAO;
import br.com.julios.ccc.infra.bd.model.ComissaoProfessorDO;
import br.com.julios.ccc.infra.bd.model.FuncionarioDO;
import br.com.julios.ccc.infra.bd.model.MensalidadeDO;
import br.com.julios.ccc.infra.bd.model.MesReferenciaDO;
import br.com.julios.ccc.infra.bd.model.PagamentoFuncionariosDO;
import br.com.julios.ccc.infra.bd.model.SalarioDO;
import br.com.julios.ccc.infra.bd.model.ValeTransporteDO;

@Service
public class PagamentoFuncionarioRepositorio {

	@Autowired
	SalarioDAO salarioDAO;
	
	@Autowired
	ValeTransporteDAO valeDAO;
	
	@Autowired
	ComissaoProfessorDAO comissaoDAO;
	
	@Autowired
	PagamentoFuncionariosDAO pagamentoDAO;
	
	public ComissaoProfessorDO getComissao(MensalidadeDO mensalidade, MesReferenciaDO mesReferencia, FuncionarioDO funcionario){
		ComissaoProfessorDO comissao = new ComissaoProfessorDO();
		comissao.setFuncionario(funcionario);
		comissao.setMensalidade(mensalidade);
		comissao.setMesReferencia(mesReferencia);
		
		return comissao;
	}

	public void cadastrar(PagamentoFuncionariosDO pagamento) {
		this.pagamentoDAO.save(pagamento);
	}
	
	

	public ComissaoProfessorDO getComissao(Long idSalario) {
		return this.comissaoDAO.findOne(idSalario);
	}

	
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

	public SalarioDO getSalario(Long idSalario) {
		
		return this.salarioDAO.findOne(idSalario);
	}

	public SalarioDO getSalario(SalarioDO salario) throws Exception {
		SalarioDO novo = new SalarioDO();
		novo.setFuncionario(salario.getFuncionario());
		Double valorRestante = salario.getValorPendente();
		if( valorRestante.longValue() > 0 )
		{
			novo.setMesReferencia(salario.getMesReferencia());
			novo.setValorRestante(valorRestante);
		}
		else{
			novo.setMesReferencia(salario.getMesReferencia().getProximoMes());
		}
			
		return novo;
	}
	
	

	
}
