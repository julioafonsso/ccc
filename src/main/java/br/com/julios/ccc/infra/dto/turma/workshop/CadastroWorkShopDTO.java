package br.com.julios.ccc.infra.dto.turma.workshop;

import java.text.ParseException;
import java.util.Date;

import br.com.julios.ccc.infra.dto.turma.CadastroTurmaDTO;
import br.com.julios.ccc.util.Util;

public class CadastroWorkShopDTO extends CadastroTurmaDTO{

	private Long idProfessor2;
	private Double percentualProfessor2;
	private Integer qtdVagas;
	private Double valorMensalidade;
	private String horarioInicial;
	private String horarioFinal;
	private Date dataInicio;
	private Date dataFim;

	public Long getIdProfessor2() {
		return idProfessor2;
	}

	public void setIdProfessor2(Long idProfessor2) {
		this.idProfessor2 = idProfessor2;
	}

	public Double getPercentualProfessor2() {
		return percentualProfessor2;
	}

	public void setPercentualProfessor2(Double percentualProfessor2) {
		this.percentualProfessor2 = percentualProfessor2;
	}

	public Integer getQtdVagas() {
		return qtdVagas;
	}

	public void setQtdVagas(Integer qtdVagas) {
		this.qtdVagas = qtdVagas;
	}

	public Double getValorMensalidade() {
		return valorMensalidade;
	}

	public void setValorMensalidade(String valorMensalidade) {
		
		this.valorMensalidade = Util.convertToDouble(valorMensalidade);
	}

	public String getHorarioInicial() {
		return horarioInicial;
	}

	public void setHorarioInicial(String horarioInicial) {
		this.horarioInicial = horarioInicial;
	}

	public String getHorarioFinal() {
		return horarioFinal;
	}

	public void setHorarioFinal(String horarioFinal) {
		this.horarioFinal = horarioFinal;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) throws ParseException {
		this.dataInicio = sdf.parse(dataInicio);
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) throws ParseException {
		this.dataFim = sdf.parse(dataFim);
	}

}
