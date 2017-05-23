package br.com.julios.ccc.negocio.turma.workshop;

import java.util.Date;

import br.com.julios.ccc.infra.dto.turma.workshop.CadastroWorkShopDTO;
import br.com.julios.ccc.negocio.funcionario.Funcionario;
import br.com.julios.ccc.negocio.turma.Turma;

public class WorkShop extends Turma {

	
	
	public WorkShop(CadastroWorkShopDTO cadastro, WorkShopRepositorio workShopRepositorio) {
		super.setTurmaRepositorio(workShopRepositorio);
		

		this.setId(cadastro.getId());
		this.setIdProfessor1(cadastro.getIdProfessor1());
		this.setPercentualProfessor1(cadastro.getPercentualProfessor1());
		this.setIdModalidade(cadastro.getIdModalidade());

		this.setHorarioInicial(cadastro.getHorarioInicial());
		this.setHorarioFinal(cadastro.getHorarioInicial());
		this.setQtdVagas(cadastro.getQtdVagas());
		this.setDataInicio(cadastro.getDataInicio());
		this.setDataFim(cadastro.getDataFim());
		this.setIdProfessor2(cadastro.getIdProfessor2());
		this.setPercentualProfessor2(cadastro.getPercentualProfessor2());
		this.setValorMensalidade(cadastro.getValorMensalidade());
	}
	
	private Long idProfessor2;
	private Double percentualProfessor2;
	private Integer qtdVagas;
	private Double valorMensalidade;
	private String horarioInicial;
	private String horarioFinal;
	private boolean domingo;
	private Date dataInicio;
	private Date dataFim;

	private Funcionario professor2;
	
	private WorkShopRepositorio getRepositorio() {
		return (WorkShopRepositorio) super.getTurmaRepositorio();
	}



	
	protected void setIdProfessor2(Long idProfessor2) {
		this.idProfessor2 = idProfessor2;
	}

	protected void setPercentualProfessor2(Double percentualProfessor2) {
		this.percentualProfessor2 = percentualProfessor2;
	}

	protected void setQtdVagas(Integer qtdVagas) {
		this.qtdVagas = qtdVagas;
	}

	protected void setValorMensalidade(Double valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}

	protected void setHorarioInicial(String horarioInicial) {
		this.horarioInicial = horarioInicial;
	}

	protected void setHorarioFinal(String horarioFinal) {
		this.horarioFinal = horarioFinal;
	}

	protected void setDomingo(boolean domingo) {
		this.domingo = domingo;
	}

	protected void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	protected void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Long getIdProfessor2() {
		return idProfessor2;
	}

	public Double getPercentualProfessor2() {
		return percentualProfessor2;
	}

	public Integer getQtdVagas() {
		return qtdVagas;
	}

	public Double getValorMensalidade() {
		return valorMensalidade;
	}

	public String getHorarioInicial() {
		return horarioInicial;
	}

	public String getHorarioFinal() {
		return horarioFinal;
	}

	public boolean isDomingo() {
		return domingo;
	}


	public Date getDataInicio() {
		return dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}


	public void cadastrar() {
		this.validaProfessorIgual();
		this.validaHorarioProfessores();
		this.validaSala();
		this.getRepositorio().cadastrar(this);
	}


	private void validaProfessorIgual() {

	}

	private void validaHorarioProfessores() {

	}

	private void validaSala() {

	}

	public String getCodigo() {
		return "workshop";
	}

	private void setProfessor2(Funcionario professor2)
	{
		this.professor2 = professor2;
	}

	public Funcionario getProfessor2() throws Exception {
		if(this.professor2 == null)
			this.setProfessor2(this.getRepositorio().getProfessor(this.getIdProfessor2()));
		return this.professor2;
	}



	public Double getPercentualProfessor(Funcionario funcionario) throws Exception {
		if(funcionario.getId().equals(this.getIdProfessor1()))
			return this.getPercentualProfessor1();
		if(funcionario.getId().equals(this.getIdProfessor2()))
			return this.getPercentualProfessor2();
		
		throw new Exception("Professor não está nessa turma");
		
		
	}
	
	
	
}
