package br.com.julios.ccc.infra.bd.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.julios.ccc.infra.Contexto;
import br.com.julios.ccc.infra.dto.matricula.ConsultaListaPresencaDTO;
import br.com.julios.ccc.infra.dto.turma.coletiva.CadastroTurmaColetivaDTO;
import br.com.julios.ccc.repositorios.TurmaColetivaRepositorio;

@Entity
@Table(name = "turma_coletiva")
@PrimaryKeyJoinColumn(name = "id")
public class TurmaColetivaDO extends TurmaDO {

	protected TurmaColetivaRepositorio getRepositorio() {
		if (this.repositorio == null)
			this.repositorio = Contexto.bean(TurmaColetivaRepositorio.class);
		return (TurmaColetivaRepositorio) repositorio;
	}

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

	public void setDataInicio(Date dataInicio) throws Exception {
		Calendar c = Calendar.getInstance();
		c.setTime(dataInicio);
		int diaInicio = c.get(Calendar.DAY_OF_WEEK);
		if (!this.temAula(diaInicio))
			throw new Exception("Data Inicio não é um dia com aula");
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) throws Exception {

		Calendar c = Calendar.getInstance();
		c.setTime(dataTermino);
		int dia = c.get(Calendar.DAY_OF_WEEK);
		if (!this.temAula(dia))
			throw new Exception("Data Termino não é um dia com aula");

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

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dataInicial = sdf.parse(sdf.format(dataInicial));
		
		double aulasMatriculado = 0;

		List<Date> aulasNoMes = getDiasAulaMes(mes);

		for (Date date : aulasNoMes) {
			if (!date.before(dataInicial) && (this.getDataTermino() == null || !date.after(this.getDataTermino())))
				aulasMatriculado++;

		}
		return aulasMatriculado / aulasNoMes.size();

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
		if (this.getProfessor1() != null)
			professores.add(this.getProfessor1());

		if (this.getProfessor2() != null)
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

	@Override
	public String getNomeNivel() {
		return this.getNivel().getNome();
	}

	@Override
	public String getHorarioTurma() {
		return this.getHorarioInicial() + " - " + this.getHorarioFinal();
	}

	@Override
	public String getDias() {
		StringBuilder sb = new StringBuilder();
		String separador = "";
		if (this.isDomingo()) {
			sb.append(separador).append("Domingo");
			separador = " - ";
		}

		if (this.isSegunda()) {
			sb.append(separador).append("Segunda");
			separador = " - ";
		}

		if (this.isTerca()) {
			sb.append(separador).append("Terça");
			separador = " - ";
		}

		if (this.isQuarta()) {
			sb.append(separador).append("Quarta");
			separador = " - ";
		}

		if (this.isQuinta()) {
			sb.append(separador).append("Quinta");
			separador = " - ";
		}

		if (this.isSexta()) {
			sb.append(separador).append("Sexta");
			separador = " - ";
		}

		if (this.isSabado()) {
			sb.append(separador).append("Sabado");
			separador = " - ";
		}

		return sb.toString();
	}

	@Override
	public Double getPercentual(FuncionarioDO professor) {
		if (this.getProfessor1() != null && this.getProfessor1().getId().equals(professor.getId()))
			return this.getPercentualProfessor1();
		if (this.getProfessor2() != null && this.getProfessor2().getId().equals(professor.getId()))
			return this.getPercentualProfessor2();
		return new Double(0);
	}

	public void alterar(CadastroTurmaColetivaDTO cadastro) throws Exception {
		if (cadastro.getIdProfessor1() != null)
			this.setProfessor1(this.getRepositorio().getProfessor(cadastro.getIdProfessor2()));

		this.setPercentualProfessor1(cadastro.getPercentualProfessor1());
		this.setModalidade(this.getRepositorio().getModalidade(cadastro.getIdModalidade()));

		this.setDomingo(cadastro.isDomingo());
		this.setSegunda(cadastro.isSegunda());
		this.setTerca(cadastro.isTerca());
		this.setQuarta(cadastro.isQuarta());
		this.setQuinta(cadastro.isQuinta());
		this.setSexta(cadastro.isSexta());
		this.setSabado(cadastro.isSabado());
		this.setHorarioInicial(cadastro.getHorarioInicial());
		this.setHorarioFinal(cadastro.getHorarioInicial());
		this.setVagas(cadastro.getQtdVagas());
		this.setDataInicio(cadastro.getDataInicio());
		this.setDataTermino(cadastro.getDataFim());
		if (cadastro.getIdProfessor2() != null)
			this.setProfessor2(this.getRepositorio().getProfessor(cadastro.getIdProfessor2()));
		this.setPercentualProfessor2(cadastro.getPercentualProfessor2());
		this.setNivel(this.getRepositorio().getNivel(cadastro.getIdNivel()));
		this.setSala(this.getRepositorio().getSala(cadastro.getIdSala()));
		this.setMensalidade(cadastro.getValorMensalidade());
		this.cadastrar();
	}

	public List<Date> getDiasAulaMes(MesReferenciaDO mesRef) throws ParseException {
		List<Date> retorno = new ArrayList<Date>();
		Calendar c = Calendar.getInstance();

		c.setTime(mesRef.getPrimeiroDia());

		int idMes = c.get(Calendar.MONTH);
		int idMesAtual = idMes;
		while (idMes == idMesAtual) {
			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
			if (this.temAula(dayOfWeek)) {
				retorno.add(c.getTime());
			}
			c.add(Calendar.DATE, 1);

			idMesAtual = c.get(Calendar.MONTH);
		}

		return retorno;

	}

	

}
