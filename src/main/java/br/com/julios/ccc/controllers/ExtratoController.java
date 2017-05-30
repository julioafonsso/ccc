package br.com.julios.ccc.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.julios.ccc.infra.bd.daos.FluxoCaixaDAO;
import br.com.julios.ccc.infra.dto.extrato.ExtratoConsolidadoDTO;
import br.com.julios.ccc.infra.dto.extrato.ExtratoDetalhadoDTO;

@Controller
@ResponseBody
@RequestMapping("/extrato")
public class ExtratoController {


	@Autowired
	FluxoCaixaDAO fluxoDAO;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	@RequestMapping(value = "detalhado/{idTipo}/{dataInicio}/{dataFim}", method = RequestMethod.GET)
	public List<ExtratoDetalhadoDTO> getExtratoDetalhado(@PathVariable("dataInicio") String dataInicio, @PathVariable("dataFim") String dataFim, @PathVariable("idTipo") Long idTipo)
			throws ParseException {

		Date dInicio = sdf.parse(dataInicio);
		Date dFim = sdf.parse(dataFim);
		return this.fluxoDAO.getExtratoDetalhado(dInicio, dFim, idTipo);

	}

	
	@RequestMapping(value = "consolidado/entradas/{dataInicio}/{dataFim}", method = RequestMethod.GET)
	public List<ExtratoConsolidadoDTO> getExtratoConsolidadoEntradas(@PathVariable("dataInicio") String dataInicio, @PathVariable("dataFim") String dataFim)
			throws ParseException {

		Date dInicio = sdf.parse(dataInicio);
		Date dFim = sdf.parse(dataFim);
		return this.fluxoDAO.getExtratoConsolidadodo(dInicio, dFim, true);

	}


	@RequestMapping(value = "consolidado/saidas/{dataInicio}/{dataFim}", method = RequestMethod.GET)
	public List<ExtratoConsolidadoDTO> getExtratoConsolidadoSaidas(@PathVariable("dataInicio") String dataInicio, @PathVariable("dataFim") String dataFim)
			throws ParseException {

		Date dInicio = sdf.parse(dataInicio);
		Date dFim = sdf.parse(dataFim);
		return this.fluxoDAO.getExtratoConsolidadodo(dInicio, dFim, false);

	}

}
