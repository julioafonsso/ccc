package br.com.julios.ccc.negocio.turma.coletiva;

import br.com.julios.ccc.negocio.turma.Turma;

public class TurmaColetiva extends Turma{

	private Long idProfessor2;
	private Double percentualProfessor2;
	private Integer qtdVagas;
	private Double valorMensalidade;
	private String horarioInicial;
	private String horarioFinal;
	private boolean domingo;
	private boolean segunda;
	private boolean terca;
	private boolean quarta;
	private boolean quinta;
	private boolean sexta;
	private boolean sabado;

	private Long idNivel;
	private Long idSala;
	protected Long getIdProfessor2() {
		return idProfessor2;
	}
	protected void setIdProfessor2(Long idProfessor2) {
		this.idProfessor2 = idProfessor2;
	}
	protected Double getPercentualProfessor2() {
		return percentualProfessor2;
	}
	protected void setPercentualProfessor2(Double percentualProfessor2) {
		this.percentualProfessor2 = percentualProfessor2;
	}
	protected Integer getQtdVagas() {
		return qtdVagas;
	}
	protected void setQtdVagas(Integer qtdVagas) {
		this.qtdVagas = qtdVagas;
	}
	protected Double getValorMensalidade() {
		return valorMensalidade;
	}
	protected void setValorMensalidade(Double valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}
	protected String getHorarioInicial() {
		return horarioInicial;
	}
	protected void setHorarioInicial(String horarioInicial) {
		this.horarioInicial = horarioInicial;
	}
	protected String getHorarioFinal() {
		return horarioFinal;
	}
	protected void setHorarioFinal(String horarioFinal) {
		this.horarioFinal = horarioFinal;
	}
	protected boolean isDomingo() {
		return domingo;
	}
	protected void setDomingo(boolean domingo) {
		this.domingo = domingo;
	}
	protected boolean isSegunda() {
		return segunda;
	}
	protected void setSegunda(boolean segunda) {
		this.segunda = segunda;
	}
	protected boolean isTerca() {
		return terca;
	}
	protected void setTerca(boolean terca) {
		this.terca = terca;
	}
	protected boolean isQuarta() {
		return quarta;
	}
	protected void setQuarta(boolean quarta) {
		this.quarta = quarta;
	}
	protected boolean isQuinta() {
		return quinta;
	}
	protected void setQuinta(boolean quinta) {
		this.quinta = quinta;
	}
	protected boolean isSexta() {
		return sexta;
	}
	protected void setSexta(boolean sexta) {
		this.sexta = sexta;
	}
	protected boolean isSabado() {
		return sabado;
	}
	protected void setSabado(boolean sabado) {
		this.sabado = sabado;
	}
	protected Long getIdNivel() {
		return idNivel;
	}
	protected void setIdNivel(Long idNivel) {
		this.idNivel = idNivel;
	}
	protected Long getIdSala() {
		return idSala;
	}
	protected void setIdSala(Long idSala) {
		this.idSala = idSala;
	}
	
}
