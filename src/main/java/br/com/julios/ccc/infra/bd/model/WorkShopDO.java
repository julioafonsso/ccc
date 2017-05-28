package br.com.julios.ccc.infra.bd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.julios.ccc.infra.Contexto;
import br.com.julios.ccc.negocio.turma.workshop.WorkShopRepositorio;

@Entity
@Table(name="workshop")
@PrimaryKeyJoinColumn(name="id")
public class WorkShopDO extends TurmaDO{
	
	@ManyToOne
	@JoinColumn(name="id_funcionario_2")
	private FuncionarioDO professor2;
	
	@Column
	private Double percentualProfessor2;
	

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

	@Transient
	private WorkShopRepositorio repositorio;
	
	private WorkShopRepositorio getRepositorio() {
		if(this.repositorio == null)
			this.repositorio = Contexto.bean(WorkShopRepositorio.class);
		return repositorio;
	}

	@Override
	protected void montaCodigo() {
		this.setCodigo("WorkShop");
	}

	@Override
	protected void salvar() {
		this.getRepositorio().cadastrar(this);
	}
	
	

	
	
	
}
