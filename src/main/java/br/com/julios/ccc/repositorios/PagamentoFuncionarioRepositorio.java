package br.com.julios.ccc.repositorios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

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
import br.com.julios.ccc.infra.bd.model.TaxasPagasDO;
import br.com.julios.ccc.infra.bd.model.ValeTransporteDO;
import br.com.julios.ccc.infra.dto.funcionario.ConsultaRecebimentosDTO;

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

	public ValeTransporteDO getValeTransporte(Long idVale) {
		return this.valeDAO.findOne(idVale);
	}

	public ValeTransporteDO getVale(ValeTransporteDO vale) {
		ValeTransporteDO novo = new ValeTransporteDO();
		novo.setFuncionario(vale.getFuncionario());
		novo.setMesReferencia(vale.getMesReferencia().getProximoMes());
			
		return novo;
	}

	public List<ConsultaRecebimentosDTO> getRecebimentos(Long idFunc, Date diaInicio, Date diaFim) {

		List<ConsultaRecebimentosDTO> retorno = new ArrayList<ConsultaRecebimentosDTO>();
		
		retorno.addAll(this.salarioDAO.getRecebimentos(idFunc, diaInicio , diaFim));
		retorno.addAll(this.valeDAO.getRecebimentos(idFunc, diaInicio , diaFim));
		
		retorno.sort(new Comparator<ConsultaRecebimentosDTO>() {

			@Override
			public int compare(ConsultaRecebimentosDTO o1, ConsultaRecebimentosDTO o2) {
				if(o1.getIdPagamento().longValue() < o2.getIdPagamento().longValue())
					return 1;
				else 
					return -1;
			}
		});
		
		
		return retorno;
	}

	public ComissaoProfessorDO getComissao(TaxasPagasDO taxa, FuncionarioDO func, MesReferenciaDO mes) {
		ComissaoProfessorDO comissao = new ComissaoProfessorDO();
		comissao.setFuncionario(func);
		comissao.setTaxa(taxa);
		comissao.setMesReferencia(mes);
		
		return comissao;
	}
	
	

	
}
