package br.com.julios.ccc.infra.dto.turma.coletiva;

import java.util.Date;

import br.com.julios.ccc.infra.dto.turma.ConsultaTurmaDTO;

public class ConsultaTurmaColetivaDTO extends ConsultaTurmaDTO {

	public ConsultaTurmaColetivaDTO(Long id,
			String codigo,
			Long idProfessor1, 
			String nomeProfessor1, 
			Double percentualProfessor1,
			Long idModalidade, 
			String nomeModalidade, 
			Long idProfessor2, 
			String nomeProfessor2,
			Double percentualProfessor2, 
			Integer qtdVagas, 
			Double valorMensalidade, 
			String horarioInicial,
			String horarioFinal, 
			boolean domingo, 
			boolean segunda, 
			boolean terca, 
			boolean quarta, 
			boolean quinta,
			boolean sexta, 
			boolean sabado, 
			Long idNivel, 
			String nomeNivel, 
			Long idSala, 
			String nomeSala,
			Integer qtdAlunos, 
			Integer qtdAlunas,
			Date dataInicio,
			Date dataTermino  
			) {

		super(id,codigo, idProfessor1, nomeProfessor1, percentualProfessor1, idModalidade, nomeModalidade);

		setIdProfessor2(idProfessor2);
		setNomeProfessor2(nomeProfessor2);
		setPercentualProfessor2(percentualProfessor2);
		setQtdVagas(qtdVagas);
		setValorMensalidade(valorMensalidade);
		setHorarioInicial(horarioInicial);
		setHorarioFinal(horarioFinal);
		setDomingo(domingo);
		setSegunda(segunda);
		setTerca(terca);
		setQuarta(quarta);
		setQuinta(quinta);
		setSexta(sexta);
		setSabado(sabado);
		setIdNivel(idNivel);
		setNomeNivel(nomeNivel);
		setIdSala(idSala);
		setNomeSala(nomeSala);
		setQtdAlunos(qtdAlunos);
		setQtdAlunas(qtdAlunas);
		setDataInicio(dataInicio);
		setDataTermino(dataTermino);
	}

	private Long idProfessor2;
	private String nomeProfessor2;
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
	private String nomeNivel;
	private Long idSala;
	private String nomeSala;
	private Integer qtdAlunos;
	private Integer qtdAlunas;
	private Date dataInicio;
	private Date dataTermino; 

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

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

	public String getNomeNivel() {
		return nomeNivel;
	}

	public void setNomeNivel(String nomeNivel) {
		this.nomeNivel = nomeNivel;
	}

	public Long getIdSala() {
		return idSala;
	}

	public void setIdSala(Long idSala) {
		this.idSala = idSala;
	}

	public String getNomeSala() {
		return nomeSala;
	}

	public void setNomeSala(String nomeSala) {
		this.nomeSala = nomeSala;
	}

	public Integer getQtdAlunos() {
		return qtdAlunos;
	}

	public void setQtdAlunos(Integer qtdAlunos) {
		this.qtdAlunos = qtdAlunos;
	}

	public Integer getQtdAlunas() {
		return qtdAlunas;
	}

	public void setQtdAlunas(Integer qtdAlunas) {
		this.qtdAlunas = qtdAlunas;
	}

}
