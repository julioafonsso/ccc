package br.com.julios.ccc.infra.bd.model;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.julios.ccc.infra.Contexto;
import br.com.julios.ccc.repositorios.MatriculaRepositorio;

@Entity
@Table(name = "matricula")
public class MatriculaDO {

	@Transient
	private MatriculaRepositorio repositorio;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "turma_id")
	private TurmaDO turma;

	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private AlunoDO aluno;

	@Column(name = "dia_vencimento")
	private Long diaVencimento;

	@Column(name = "data_matricula")
	private Date dataMatricula;
	
	@Column(name = "data_exclusao")
	private Date dataExclusao;
	
	@ManyToOne
	private DescontosDO desconto;
	
	@ManyToOne
	private FluxoCaixaDO pagamentroMatricula;
	
	public FluxoCaixaDO getPagamentroMatricula() {
		return pagamentroMatricula;
	}

	public void setPagamentroMatricula(FluxoCaixaDO pagamentroMatricula) {
		this.pagamentroMatricula = pagamentroMatricula;
	}

	public Date getDataExclusao() {
		return dataExclusao;
	}

	public DescontosDO getDesconto() {
		return desconto;
	}

	public void setDesconto(DescontosDO desconto) {
		this.desconto = desconto;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	TurmaDO getTurma() {
		return turma;
	}

	public void setTurma(TurmaDO turma) {
		this.turma = turma;
	}

	private AlunoDO getAluno() {
		return aluno;
	}

	public void setAluno(AlunoDO aluno) {
		this.aluno = aluno;
	}

	public Long getDiaVencimento() {
		return diaVencimento;
	}

	public void setDiaVencimento(Long diaVencimento) {
		this.diaVencimento = diaVencimento;
	}

	public Long getId() {
		return id;
	}

	public MatriculaRepositorio getRepositorio() {
		if(this.repositorio == null)
			this.repositorio = Contexto.bean(MatriculaRepositorio.class);
		return repositorio;
	}

	public void cadastrar(){
		this.getRepositorio().cadastrar(this);
	}

	public String getNomeAluno() {
		return this.getAluno().getNome();
	}

	public Double getValorMensalidade() {
		return this.getTurma().getMensalidade();
	}

	public Double getPercentualDeAulasMes(MesReferenciaDO mesReferenciaDO, Date primeiroDia) throws ParseException {
		
		return this.getTurma().getPercentualDeAulasMes(mesReferenciaDO, primeiroDia);
		
	}
	
	public Double getPercentualProfessor(FuncionarioDO professor) {
		return this.getTurma().getPercentual(professor);
	}


	public List<FuncionarioDO> getProfessores() {
		return this.getTurma().getProfessores();
	}

	public boolean turmaEhWorkShop() {
		return this.getTurma().turmaEhWorkShop();
	}
	
	public String getNomeNivel(){
		return this.getTurma().getNomeNivel();
	}

	
	public String getHorarioTurma(){
		return this.getTurma().getHorarioTurma();
	}

	public String getDiasTurmas() {
		return this.getTurma().getDias();
	}

	public String getEmailAluno() {
		return this.getAluno().getEmail();
	}

	public String getNomeModalidade() {
		return this.getTurma().getNomeModalidade();
	}

	public String getCodigoTurma() {
		return this.getTurma().getCodigo();
	}
}
