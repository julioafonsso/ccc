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
import br.com.julios.ccc.domains.TipoFluxoCaixa;

@Service
public class ExtratoApi {

	@Autowired
	FluxoCaixaDAO fluxoDAO;
	
	@Autowired
	TipoFluxoCaixaApi tipoApi;

	private List<Extrato> tratarDados(List<FluxoCaixa> dados) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		HashMap<String, Extrato> map = new HashMap<String, Extrato>();

		for (FluxoCaixa fluxoCaixa : dados) {
			Extrato valor;
			valor = map.get(sdf.format(fluxoCaixa.getData()));
			
			if (valor == null) {
				valor = new Extrato();
				valor.setData(sdf.format(fluxoCaixa.getData()));
			}
			
			valor.addValor(fluxoCaixa.getValor());
			valor.addFluxoCaixa(fluxoCaixa);

			map.put(sdf.format(fluxoCaixa.getData()), valor);
		}
		List<Extrato> retorno = new ArrayList<Extrato>(map.values());

		retorno.sort(new Comparator<Extrato>() {

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

			}
		});
		return retorno;

	}

	public List<Extrato> getExtrato(Date dataInicio, Date dataFim) {
		List<FluxoCaixa> dados = fluxoDAO.findByDataBetweenOrderByData(dataInicio, dataFim);
		return tratarDados(dados);
	}

	public List<Extrato> getExtratoAgrupadoData(TipoFluxoCaixa tipo, Date dataInicio, Date dataFim) {

		List<FluxoCaixa> dados = fluxoDAO.findByTipoFluxoAndDataBetweenOrderByData(tipo, dataInicio, dataFim);
		return tratarDados(dados);
	}
	
	public List<FluxoCaixa> getFluxos(TipoFluxoCaixa tipo, Date dataInicio, Date dataFim) {

		return fluxoDAO.findByTipoFluxoAndDataBetweenOrderByData(tipo, dataInicio, dataFim);
	}

	public Object[] getExtratoConsolidado(Date dInicio, Date dFim, boolean indEntrada) {
		List<Object> retorno = new ArrayList<Object>();
		
		Object[] dadosConsolidados = fluxoDAO.findConsolidado(dInicio, dFim, indEntrada);
		for (Object object : dadosConsolidados) {
			TipoFluxoCaixa tipo = tipoApi.getTipoFluxoCaixa((Long) ((Object[])object)[3]);
			Object[] dados = new Object[5];
			dados[0] = ((Object[])object)[0] ;
			dados[1] = ((Object[])object)[1] ;
			dados[2] = ((Object[])object)[2] ;
			dados[3] = ((Object[])object)[3] ;
			
			
			dados[4] =  getFluxos(tipo, dInicio, dFim);
			retorno.add(dados);
		}
		return retorno.toArray() ;

	}

}
