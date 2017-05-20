package br.com.julios.ccc.negocio.turma.coletiva;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import br.com.julios.ccc.infra.dto.turma.coletiva.CadastroTurmaColetivaDTO;
import br.com.julios.ccc.negocio.mes.MesReferencia;
import br.com.julios.ccc.negocio.turma.Turma;

public class TurmaColetiva extends Turma {

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
	private Date dataInicio;
	private Date dataFim;
	private Long idNivel;
	private Long idSala;

	private TurmaColetivaRepositorio repositorio;

	public TurmaColetiva(CadastroTurmaColetivaDTO cadastro, TurmaColetivaRepositorio turmaColetivaRepositorio) {

		this.repositorio = turmaColetivaRepositorio;

		this.setId(cadastro.getId());
		this.setIdProfessor1(cadastro.getIdProfessor1());
		this.setPercentualProfessor1(cadastro.getPercentualProfessor1());
		this.setIdModalidade(cadastro.getIdModalidade());

		this.setDomingo(cadastro.isDomingo());
		this.setSegunda(cadastro.isSegunda());
		this.setTerca(cadastro.isTerca());
		this.setQuarta(cadastro.isQuarta());
		this.setQuinta(cadastro.isQuinta());
		this.setSexta(cadastro.isSexta());
		this.setSabado(cadastro.isSabado());
		this.setHorarioInicial(cadastro.getHorarioInicial());
		this.setHorarioFinal(cadastro.getHorarioInicial());
		this.setQtdVagas(cadastro.getQtdVagas());
		this.setDataInicio(cadastro.getDataInicio());
		this.setDataFim(cadastro.getDataFim());
		this.setIdProfessor2(cadastro.getIdProfessor2());
		this.setPercentualProfessor2(cadastro.getPercentualProfessor2());
		this.setIdNivel(cadastro.getIdNivel());
		this.setIdSala(cadastro.getIdSala());
		this.setValorMensalidade(cadastro.getValorMensalidade());
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

	protected void setSegunda(boolean segunda) {
		this.segunda = segunda;
	}

	protected void setTerca(boolean terca) {
		this.terca = terca;
	}

	protected void setQuarta(boolean quarta) {
		this.quarta = quarta;
	}

	protected void setQuinta(boolean quinta) {
		this.quinta = quinta;
	}

	protected void setSexta(boolean sexta) {
		this.sexta = sexta;
	}

	protected void setSabado(boolean sabado) {
		this.sabado = sabado;
	}

	protected void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	protected void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	protected void setIdNivel(Long idNivel) {
		this.idNivel = idNivel;
	}

	protected void setIdSala(Long idSala) {
		this.idSala = idSala;
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

	public boolean isSegunda() {
		return segunda;
	}

	public boolean isTerca() {
		return terca;
	}

	public boolean isQuarta() {
		return quarta;
	}

	public boolean isQuinta() {
		return quinta;
	}

	public boolean isSexta() {
		return sexta;
	}

	public boolean isSabado() {
		return sabado;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public Long getIdNivel() {
		return idNivel;
	}

	public Long getIdSala() {
		return idSala;
	}

	public void cadastrar() {
		this.validaProfessorIgual();
		this.validaHorarioProfessores();
		this.validaSala();
		this.repositorio.cadastrar(this);

	}

	private void validaProfessorIgual() {

	}

	private void validaHorarioProfessores() {

	}

	private void validaSala() {

	}

	public String getCodigo() {
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

		retorno.append(this.getIdSala());
		return retorno.toString();
	}

	public Double getPercentualMes(MesReferencia mes, Date dataInicial) throws ParseException {
		
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
						&& (this.getDataFim() == null || !c.getTime().after(this.getDataFim())))
					aulasMatriculado++;

			}
			c.add(Calendar.DATE, 1);

			idMesAtual = c.get(Calendar.MONTH);
		}

		return aulasTotais/ aulasMatriculado;
	


		
	}
	
	private boolean temAula(int dia)
	{
		if(dia == 1)
			return this.isDomingo();
		if(dia == 2)
			return this.isSegunda();
		if(dia == 3)
			return this.isTerca();
		if(dia == 4)
			return this.isQuarta();
		if(dia == 5)
			return this.isQuinta();
		if(dia == 6)
			return this.isSexta();
		if(dia == 7)
			return this.isSabado();
	
		return false;
	}

}
