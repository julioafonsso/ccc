package br.com.julios.ccc.domains;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "TURMA")
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn (name = "modalidade_id")
	@JsonIgnoreProperties("turma")
	private ModalidadeTurma modalidade;
	
	@ManyToMany
	@JoinTable(name = "turma_dias", joinColumns = @JoinColumn(name = "turma_id"), inverseJoinColumns = @JoinColumn(name = "dias_semana_id"))
	@JsonIgnoreProperties("turmas")
	private List<DiasSemana> diasSemana;
	
	@Column(name = "horario_inicial")
	@Temporal(TemporalType.TIME)
	private Date horarioInicial;
	
	@Column(name = "horario_final")
	@Temporal(TemporalType.TIME)
	private Date horarioFinal;
	
	@Column
	private double mensalidade;
	
	@Column
	private int vagas;
	
	@ManyToOne
	@JoinColumn (name = "sala_id")
	@JsonIgnoreProperties("turma")
	private Salas sala;
	
	@ManyToOne
	@JoinColumn (name = "nivel_turma_id")
	@JsonIgnoreProperties("turma")
	private NivelTurma nivel;
	
	@OneToMany(mappedBy = "turma")
	@JsonIgnoreProperties("turma")
	private List<TurmaProfessor> professores;
	
	@ManyToMany
	@JoinTable (name ="turma_aluno", joinColumns = @JoinColumn (name = "turma_id"), inverseJoinColumns = @JoinColumn (name = "aluno_id"))
	@JsonIgnoreProperties("turmas")
	private List<Aluno> alunos;
	
	@Formula("(select count(*) from turma_aluno ta , aluno a where a.id = ta.aluno_id and a.sexo = 'M' and ta.turma_id = id)")
	private int qtdAlunos;

	//Getters and Setters
	
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

	public Date getHorarioInicial() {
		return horarioInicial;
	}

	public void setHorarioInicial(Date horarioInicial) {
		this.horarioInicial = horarioInicial;
	}

	public Date getHorarioFinal() {
		return horarioFinal;
	}

	public void setHorarioFinal(Date horarioFinal) {
		this.horarioFinal = horarioFinal;
	}

	public double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(double mensalidade) {
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

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public long getId() {
		return id;
	}
	
	
	
	
	
}
