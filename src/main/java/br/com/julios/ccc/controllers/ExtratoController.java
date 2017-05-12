package br.com.julios.ccc.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.facade.ExtratoFacade;
import br.com.julios.ccc.infra.bd.model.ExtratoDO;

@Controller
@ResponseBody
@RequestMapping("/extrato")
public class ExtratoController {

	@Autowired
	ExtratoFacade extratoFacade;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	@RequestMapping(value = "{dataInicio}/{dataFim}", method = RequestMethod.GET)
	public Collection<ExtratoDO> getExtrato(@PathVariable("dataInicio") String dataInicio, @PathVariable("dataFim") String dataFim)
			throws ParseException {

		Date dInicio = sdf.parse(dataInicio);
		Date dFim = sdf.parse(dataFim);

		return null;

	}

	
	@RequestMapping(value = "consolidado/entradas/{dataInicio}/{dataFim}", method = RequestMethod.GET)
	public Object[] getExtratoConsolidadoEntradas(@PathVariable("dataInicio") String dataInicio, @PathVariable("dataFim") String dataFim)
			throws ParseException {

		Date dInicio = sdf.parse(dataInicio);
		Date dFim = sdf.parse(dataFim);
		return extratoFacade.getExtratoConsolidado(dInicio, dFim, true);

	}


	@RequestMapping(value = "consolidado/saidas/{dataInicio}/{dataFim}", method = RequestMethod.GET)
	public Object[] getExtratoConsolidadoSaidas(@PathVariable("dataInicio") String dataInicio, @PathVariable("dataFim") String dataFim)
			throws ParseException {

		Date dInicio = sdf.parse(dataInicio);
		Date dFim = sdf.parse(dataFim);
		return extratoFacade.getExtratoConsolidado(dInicio, dFim, false);

	}

}
