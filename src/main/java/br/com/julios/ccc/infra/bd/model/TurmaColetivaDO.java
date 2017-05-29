package br.com.julios.ccc.infra.bd.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import br.com.julios.ccc.infra.Contexto;
import br.com.julios.ccc.negocio.turma.coletiva.TurmaColetivaRepositorio;

@Entity
@Table(name = "turma_coletiva")
@PrimaryKeyJoinColumn(name = "id")
public class TurmaColetivaDO extends TurmaDO {

	
	
	protected TurmaColetivaRepositorio getRepositorio() {
		if(this.repositorio == null)
			this.repositorio = Contexto.bean(TurmaColetivaRepositorio.class);
		return (TurmaColetivaRepositorio) repositorio;
	}

	@Column(name = "data_inicio")
	private Date dataInicio;

	@Column(name = "data_termino")
	private Date dataTermino;

	@Column(name = "horario_inicial")
	private String horarioInicial;

	@Column(name = "horario_final")
	private String horarioFinal;

	@Column
	private Integer vagas;

	@ManyToOne
	@JoinColumn(name = "id_sala")
	private SalaDO sala;

	@ManyToOne
	@JoinColumn(name = "id_nivel")
	private NivelTurmaDO nivel;

	@ManyToOne
	@JoinColumn(name = "id_professor_2")
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

	public Double getPercentualDeAulasMes(MesReferenciaDO mes, Date dataInicial) throws ParseException {

		double aulasTotais = 0;
		double aulasMatriculado = 0;

		Calendar c = Calendar.getInstance();

		c.setTime(mes.getPrimeiroDia());

		int idMes = c.get(Calendar.MONTH);
		int idMesAtual = idMes;

		while (idMes == idMesAtual) {
			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
			if (this.temAula(dayOfWeek)) {
				aulasTotais++;
				if (!c.getTime().before(dataInicial)
						&& (this.getDataTermino() == null || !c.getTime().after(this.getDataTermino())))
					aulasMatriculado++;

			}
			c.add(Calendar.DATE, 1);

			idMesAtual = c.get(Calendar.MONTH);
		}

		return aulasMatriculado / aulasTotais;

	}

	private boolean temAula(int dia) {
		if (dia == 1)
			return this.isDomingo();
		if (dia == 2)
			return this.isSegunda();
		if (dia == 3)
			return this.isTerca();
		if (dia == 4)
			return this.isQuarta();
		if (dia == 5)
			return this.isQuinta();
		if (dia == 6)
			return this.isSexta();
		if (dia == 7)
			return this.isSabado();

		return false;
	}

	public List<FuncionarioDO> getProfessores() {
		List<FuncionarioDO> professores = new ArrayList<FuncionarioDO>();
		if(this.getProfessor1() != null)
			professores.add(this.getProfessor1());
		
		if(this.getProfessor2() != null )
			professores.add(this.getProfessor2());
		
		return professores;
	}

	
	
	protected void montaCodigo() {
		StringBuffer retorno = new StringBuffer();

		if (this.isDomingo())
			retorno.append("1");
		if (this.isSegunda())
			retorno.append("2");
		if (this.isTerca())
			retorno.append("3");
		if (this.isQuarta())
			retorno.append("4");
		if (this.isQuinta())
			retorno.append("5");
		if (this.isSexta())
			retorno.append("6");
		if (this.isSabado())
			retorno.append("7");

		retorno.append(this.getHorarioInicial().substring(0, this.getHorarioInicial().indexOf(":")));

		retorno.append(this.getSala().getId());
		this.setCodigo(retorno.toString());
	}

	@Override
	protected void salvar() {
		this.getRepositorio().cadastrar(this);
		
	}

	

}
