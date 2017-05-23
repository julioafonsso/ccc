package br.com.julios.ccc.infra.dto.turma.workshop;

import java.util.Date;

import br.com.julios.ccc.infra.dto.turma.ConsultaTurmaDTO;

public class ConsultaWorkShopDTO extends ConsultaTurmaDTO {

	public ConsultaWorkShopDTO(Long id,
							   String codigo, 
							   Long idProfessor1, 
							   String nomeProfessor1, 
							   Double percentualProfessor1,
							   Long idProfessor2,
								String nomeProfessor2,
								Double percentualProfessor2,
							   Long idModalidade,
							   String nomeModalidade,
							   Integer qtdVagas,
								Double valorMensalidade,
								String horarioInicial,
								String horarioFinal,
								Date dataInicio,
								Date dataFim
							   ) {
		super(id,codigo, idProfessor1, nomeProfessor1, percentualProfessor1, idModalidade, nomeModalidade);
		this.setIdProfessor2(idProfessor2);
		this.setNomeProfessor2(nomeProfessor2);
		this.setPercentualProfessor2(percentualProfessor2);
		this.setQtdVagas(qtdVagas);
		this.setValorMensalidade(valorMensalidade);
		this.setHorarioFinal(horarioFinal);
		this.setHorarioInicial(horarioInicial);
		this.setDataFim(dataFim);
		this.setDataInicio(dataInicio);
	}

	private Long idProfessor2;
	private String nomeProfessor2;
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

	public String getNomeProfessor2() {
		return nomeProfessor2;
	}

	public void setNomeProfessor2(String nomeProfessor2) {
		this.nomeProfessor2 = nomeProfessor2;
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

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

}
