package br.com.julios.ccc.infra.bd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="turma_coletiva")
@PrimaryKeyJoinColumn(name="id")
public class TurmaColetivaDO extends TurmaDO {

	@Column(name = "data_inicio")
	private Date dataInicio;
	
	@Column(name = "data_termino")
	private Date dataTermino;
	
	@Column(name = "horario_inicial")
	private String horarioInicial;
	
	@Column(name = "horario_final")
	private String horarioFinal;
	
	@Column
	private Double mensalidade;
	
	@Column
	private Integer vagas;
	
	@ManyToOne
	@JoinColumn (name = "id_sala")
	private SalaDO sala;
	
	@ManyToOne
	@JoinColumn (name = "id_nivel")
	private NivelTurmaDO nivel;
	
	@ManyToOne
	@JoinColumn(name="id_professor_2")
	private FuncionarioDO professor2;
	
	@Column
	private Double percentualProfessor2;

	@Column
	private boolean domingo;
	
	@Column
	private boolean segunda;
	
	@Column
	private boolean terca;
	
	
	@Column
	private boolean quarta;
	
	@Column
	private boolean quinta;
	
	@Column
	private boolean sexta;
	
	@Column
	private boolean sabado;

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
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

	public Double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(Double mensalidade) {
		this.mensalidade = mensalidade;
	}

	public Integer getVagas() {
		return vagas;
	}

	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}

	public SalaDO getSala() {
		return sala;
	}

	public void setSala(SalaDO sala) {
		this.sala = sala;
	}

	public NivelTurmaDO getNivel() {
		return nivel;
	}

	public void setNivel(NivelTurmaDO nivel) {
		this.nivel = nivel;
	}

	public FuncionarioDO getProfessor2() {
		return professor2;
	}

	public void setProfessor2(FuncionarioDO professor2) {
		this.professor2 = professor2;
	}

	public Double getPercentualProfessor2() {
		return percentualProfessor2;
	}

	public void setPercentualProfessor2(Double percentualProfessor2) {
		this.percentualProfessor2 = percentualProfessor2;
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

	
	
}
