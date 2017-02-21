package br.com.julios.ccc.negocio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.daos.FluxoCaixaDAO;
import br.com.julios.ccc.domains.Extrato;
import br.com.julios.ccc.domains.FluxoCaixa;

@Service
public class ExtratoApi {

	@Autowired
	FluxoCaixaDAO fluxoDAO;

	public List<Extrato> getExtrato(Date dataInicio, Date dataFim) {
		
		HashMap<String, Extrato> map = new HashMap<String, Extrato>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Double saldoAtual = fluxoDAO.getSaldoAteData(dataInicio);
		if(saldoAtual == null)
			saldoAtual = new Double(0);
		
		List<FluxoCaixa> dados = fluxoDAO.findByDataFluxoBetweenOrderByDataFluxoDesc(dataInicio, dataFim);

		for (FluxoCaixa fluxoCaixa : dados) {
			Extrato valor;
			valor = map.get(sdf.format(fluxoCaixa.getDataFluxo()));
			saldoAtual += fluxoCaixa.getValor();

			if (valor == null) {
				valor = new Extrato();
				valor.setData(sdf.format(fluxoCaixa.getDataFluxo()));
			}
				
			valor.setValor(saldoAtual);
			valor.addFluxoCaixa(fluxoCaixa);

			map.put(sdf.format(fluxoCaixa.getDataFluxo()), valor);
		}
		List<Extrato> retorno = new ArrayList<Extrato>(map.values());
		
		retorno.sort(new Comparator<Extrato>(){

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			@Override
			public int compare(Extrato e1, Extrato e2) {
				
				Date d1;
				Date d2;
				try {
					d1 = sdf.parse(e1.getData());
					d2 = sdf.parse(e2.getData());
					return d2.compareTo(d1);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				return 0;
				
				
				
				
			}});
			return retorno;
	}

	public Object[] getExtratoConsolidado(Date dInicio, Date dFim, boolean indEntrada) {
		return fluxoDAO.findSum(dInicio, dFim,indEntrada);
		
		
		
		
	}

}
