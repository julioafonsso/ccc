package br.com.julios.ccc.infra.bd.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.julios.ccc.infra.Contexto;
import br.com.julios.ccc.infra.dto.turma.workshop.CadastroWorkShopDTO;
import br.com.julios.ccc.repositorios.WorkShopRepositorio;

@Entity
@Table(name = "workshop")
@PrimaryKeyJoinColumn(name = "id")
public class WorkShopDO extends TurmaDO {

	@ManyToOne
	@JoinColumn(name = "id_funcionario_2")
	private FuncionarioDO professor2;

	@Column
	private Double percentualProfessor2;

	@Column(name = "data_inicio")
	@Temporal(TemporalType.DATE)
	private Date dataInicio;

	@Column(name = "data_termino")
	@Temporal(TemporalType.DATE)
	private Date dataTermino;

	@Column(name = "horario_inicial")
	private String horarioInicial;

	@Column(name = "horario_final")
	private String horarioFinal;

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

	public Integer getVagas() {
		return vagas;
	}

	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}

	protected WorkShopRepositorio getRepositorio() {
		if (this.repositorio == null)
			this.repositorio = Contexto.bean(WorkShopRepositorio.class);
		return (WorkShopRepositorio) repositorio;
	}

	@Override
	protected void montaCodigo() {
		this.setCodigo("WorkShop");
	}

	@Override
	protected void salvar() {
		this.getRepositorio().cadastrar(this);
	}

	@Override
	public List<FuncionarioDO> getProfessores() {
		List<FuncionarioDO> professores = new ArrayList<FuncionarioDO>();
		if (this.getProfessor1() != null)
			professores.add(this.getProfessor1());
		if (this.getProfessor2() != null)
			professores.add(this.getProfessor2());

		return professores;
	}

	@Override
	public Double getPercentualDeAulasMes(MesReferenciaDO mesReferenciaDO, Date primeiroDia) throws ParseException {
		return new Double(1);
	}

	public boolean turmaEhWorkShop() {
		return true;
	}

	@Override
	public Double getPercentual(FuncionarioDO professor) {
		if (this.getProfessor1() != null && this.getProfessor1().getId().equals(professor.getId()))
			return this.getPercentualProfessor1();
		if (this.getProfessor2() != null && this.getProfessor2().getId().equals(professor.getId()))
			return this.getPercentualProfessor2();
		return new Double(0);
	}

	public void alterar(CadastroWorkShopDTO cadastro) throws Exception {
		if (cadastro.getIdProfessor1() != null)
			this.setProfessor1(this.getRepositorio().getProfessor(cadastro.getIdProfessor1()));
		else
			this.setProfessor1(null);
		
		this.setPercentualProfessor1(cadastro.getPercentualProfessor1());
		this.setModalidade(this.getRepositorio().getModalidade(cadastro.getIdModalidade()));

		this.setHorarioInicial(cadastro.getHorarioInicial());
		this.setHorarioFinal(cadastro.getHorarioInicial());
		this.setVagas(cadastro.getQtdVagas());
		this.setDataInicio(cadastro.getDataInicio());
		this.setDataTermino(cadastro.getDataFim());
		if (cadastro.getIdProfessor2() != null)
			this.setProfessor2(this.getRepositorio().getProfessor(cadastro.getIdProfessor2()));
		else
			this.setProfessor2(null);
		this.setPercentualProfessor2(cadastro.getPercentualProfessor2());
		this.setMensalidade(cadastro.getValorMensalidade());
		this.cadastrar();
		
	}

}
