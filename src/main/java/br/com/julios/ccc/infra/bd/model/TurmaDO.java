package br.com.julios.ccc.infra.bd.model;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

import br.com.julios.ccc.infra.Contexto;
import br.com.julios.ccc.repositorios.TurmaRepositorio;

@Table(name = "turma")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public abstract class TurmaDO {
	
	@Transient
	protected TurmaRepositorio repositorio;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Double mensalidade;
	
	@Column
	private String codigo;

	@ManyToOne
	@JoinColumn(name = "id_modalidade")
	private ModalidadeTurmaDO modalidade;

	@ManyToOne
	@JoinColumn(name = "id_professor_1")
	private FuncionarioDO professor1;

	@Column(name = "percentual_professor1")
	private Double percentualProfessor1;

	@Formula("(select count(*) from matricula ta , aluno a where a.id = ta.aluno_id and a.sexo = 'M' and ta.turma_id = id and ta.data_exclusao is null)")
	private Integer qtdAlunos;

	@Formula("(select count(*) from matricula ta , aluno a where a.id = ta.aluno_id and a.sexo = 'F' and ta.turma_id = id and ta.data_exclusao is null	)")
	private Integer qtdAlunas;

	public Long getId() {
		return id;
	}

	public String getCodigo() {
		return this.codigo;
	}
	
	protected abstract void montaCodigo();

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public ModalidadeTurmaDO getModalidade() {
		return modalidade;
	}

	public void setModalidade(ModalidadeTurmaDO modalidade) {
		this.modalidade = modalidade;
	}

	public FuncionarioDO getProfessor1() {
		return professor1;
	}

	public void setProfessor1(FuncionarioDO professor1) throws Exception {
		this.professor1 = professor1;
	}

	public Double getPercentualProfessor1() {
		return percentualProfessor1;
	}

	public void setPercentualProfessor1(Double percentualProfessor1) {
		this.percentualProfessor1 = percentualProfessor1;
	}


	public Integer getQtdAlunos() {
		return qtdAlunos;
	}

	public Integer getQtdAlunas() {
		return qtdAlunas;
	}

	public Double getPercentual(FuncionarioDO professor) {
		
		if(this.getProfessor1() != null && this.getProfessor1().getId().equals(professor.getId()))
			return this.getPercentualProfessor1();
		return new Double(0);
	}
	
	public void cadastrar() throws Exception{
		this.validarPercentualProfessor();
		this.montaCodigo();
		this.salvar();
	}
	
	
	protected void validarPercentualProfessor() throws Exception{
		if(this.getProfessor1() != null && this.getPercentualProfessor1() == null){
			throw new Exception("Favor preencher o Percentual do professor");
		}
		
		if(this.getProfessor1() == null && this.getPercentualProfessor1() != null){
			throw new Exception("Não preencher o percentual do professor");
		}
	}
	protected abstract void salvar();

	protected TurmaRepositorio getRepositorio() {
		if(this.repositorio == null)
			this.repositorio = Contexto.bean(TurmaRepositorio.class);
		return repositorio;
	}
	
	public abstract List<FuncionarioDO> getProfessores();
		
	public Double getMensalidade() {
		return this.mensalidade;
	}

	public void setMensalidade(Double mensalidade) {
		this.mensalidade = mensalidade;
	}

	public abstract Double getPercentualDeAulasMes(MesReferenciaDO mesReferenciaDO, Date primeiroDia) throws ParseException ;

	public boolean turmaEhWorkShop() {
		return false;
	}

	public String getNomeNivel() {
		return "";	
	}

	public String getHorarioTurma() {
		return "";
	}
	
	public String getDias(){
		return "";
	}

	public String getNomeModalidade() {
		return this.getModalidade().getNome();
	}
		
	
	public String getNomeProfessor1() {
		if(this.getProfessor1() == null)
			return "";
		return this.getProfessor1().getNome();
	}

	public Date getDataInicio() {
		return null;
	}
}
