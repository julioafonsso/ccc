package br.com.julios.ccc.domains;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.julios.ccc.util.Util;

@Entity
@Table(name = "TURMA")
public class Turma {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String codigo;
	
	@ManyToOne
	@JoinColumn (name = "modalidade_id")
	private ModalidadeTurma modalidade;
	
	@ManyToMany
	@JoinTable(name = "turma_dias", joinColumns = @JoinColumn(name = "turma_id"), inverseJoinColumns = @JoinColumn(name = "dias_semana_id"))
	@JsonIgnoreProperties("turmas")
	private List<DiasSemana> diasSemana;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "data_inicio")
	private Date dataInicio;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "data_termino")
	private Date dataTermino;
	
	@Column(name = "horario_inicial")
	private String horarioInicial;
	
	@Column(name = "horario_final")
	private String horarioFinal;
	
	@Column
	private Double mensalidade;
	
	@Column
	private int vagas;
	
	@ManyToOne
	@JoinColumn (name = "sala_id")
	private Salas sala;
	
	@ManyToOne
	@JoinColumn (name = "nivel_turma_id")
	private NivelTurma nivel;
	
	@OneToMany(mappedBy = "turma")
	@JsonIgnoreProperties("turma")
	private List<TurmaProfessor> professores;
	
	@OneToMany(mappedBy = "turma")
		@JsonIgnoreProperties("turma")
	@Where(clause = "data_exclusao is null")
	private List<Matricula> matriculas;
	
	@Formula("(select count(*) from matricula ta , aluno a where a.id = ta.aluno_id and a.sexo = 'M' and ta.turma_id = id and ta.data_exclusao is null)")
	private int qtdAlunos;
	
	@Formula("(select count(*) from matricula ta , aluno a where a.id = ta.aluno_id and a.sexo = 'F' and ta.turma_id = id and ta.data_exclusao is null	)")
	private int qtdAlunas;

	//Getters and Setters

	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	public int getQtdAlunos() {
		return qtdAlunos;
	}

	public int getQtdAlunas() {
		return qtdAlunas;
	}

	public ModalidadeTurma getModalidade() {
		return modalidade;
	}

	public void setModalidade(ModalidadeTurma modalidade) {
		this.modalidade = modalidade;
	}

	public List<DiasSemana> getDiasSemana() {
		return diasSemana;
	}

	public void setDiasSemana(List<DiasSemana> diasSemana) {
		this.diasSemana = diasSemana;
	}
	
	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) throws ParseException {
		this.dataInicio = Util.parseDate(dataInicio);
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
	
	public void setDataTermino(String dataTermino) throws ParseException {
		this.dataTermino = Util.parseDate(dataTermino);
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

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public Salas getSala() {
		return sala;
	}

	public void setSala(Salas sala) {
		this.sala = sala;
	}

	public NivelTurma getNivel() {
		return nivel;
	}

	public void setNivel(NivelTurma nivel) {
		this.nivel = nivel;
	}

	public List<TurmaProfessor> getProfessores() {
		return professores;
	}

	public void setProfessores(List<TurmaProfessor> professores) {
		this.professores = professores;
	}


	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public long getId() {
		return id;
	}
	
	
}
