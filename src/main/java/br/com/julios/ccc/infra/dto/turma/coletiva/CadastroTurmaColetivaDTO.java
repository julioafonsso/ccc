package br.com.julios.ccc.infra.dto.turma.coletiva;

import java.text.ParseException;
import java.util.Date;

import br.com.julios.ccc.infra.dto.turma.CadastroTurmaDTO;

public class CadastroTurmaColetivaDTO extends CadastroTurmaDTO {

	private Long idProfessor2;
	private Double percentualProfessor2;
	private Integer qtdVagas;
	private Double valorMensalidade;
	private String horarioInicial;
	private String horarioFinal;
	private Date dataInicio;
	private Date dataFim;
	private boolean domingo;
	private boolean segunda;
	private boolean terca;
	private boolean quarta;
	private boolean quinta;
	private boolean sexta;
	private boolean sabado;
	private Long idNivel;
	private Long idSala;

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

	public void setValorMensalidade(Double valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
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

	public boolean isDomingo() {
		return domingo;
	}

	public void setDomingo(boolean domingo) {
		this.domingo = domingo;
	}

	public boolean isSegunda() {
		return segunda;
	}

	public void setSegunda(boolean segunda) {
		this.segunda = segunda;
	}

	public boolean isTerca() {
		return terca;
	}

	public void setTerca(boolean terca) {
		this.terca = terca;
	}

	public boolean isQuarta() {
		return quarta;
	}

	public void setQuarta(boolean quarta) {
		this.quarta = quarta;
	}

	public boolean isQuinta() {
		return quinta;
	}

	public void setQuinta(boolean quinta) {
		this.quinta = quinta;
	}

	public boolean isSexta() {
		return sexta;
	}

	public void setSexta(boolean sexta) {
		this.sexta = sexta;
	}

	public boolean isSabado() {
		return sabado;
	}

	public void setSabado(boolean sabado) {
		this.sabado = sabado;
	}

	public Long getIdNivel() {
		return idNivel;
	}

	public void setIdNivel(Long idNivel) {
		this.idNivel = idNivel;
	}

	public Long getIdSala() {
		return idSala;
	}

	public void setIdSala(Long idSala) {
		this.idSala = idSala;
	}

}
