package br.com.julios.ccc.domains;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "TURMA")
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	@JoinColumn (name = "modalidade_id")
	private ModalidadeTurma modalidade;
	
	@ManyToMany
	@JoinTable(name = "turma_dias", joinColumns = @JoinColumn(name = "turma_id"), inverseJoinColumns = @JoinColumn(name = "dias_semana_id"))
	private List<DiasSemana> diassemana;
	
	@Column(name = "horario_inicial")
	@Temporal(TemporalType.TIME)
	private Date horarioinicial;
	
	@Column(name = "horario_final")
	@Temporal(TemporalType.TIME)
	private Date horariofinal;
	
	@Column
	private double mensalidade;
	
	@Column
	private int vagas;
	
	@ManyToOne
	@JoinColumn (name = "sala_id")
	private Salas salaaula;
	
	@ManyToOne
	@JoinColumn (name = "nivel_turma_id")
	private NivelTurma nivel;
	
	@OneToMany(mappedBy = "turma")
	private List<TurmaProfessor> professores;
	
	@ManyToMany
	@JoinTable (name ="turma_aluno", joinColumns = @JoinColumn (name = "turma_id"), inverseJoinColumns = @JoinColumn (name = "aluno_id"))
	private List<Aluno> alunos;
	
	//Getters and Setters

	public long getId() {
		return id;
	}

	public ModalidadeTurma getModalidade() {
		return modalidade;
	}

	public void setModalidade(ModalidadeTurma modalidade) {
		this.modalidade = modalidade;
	}

	public List<DiasSemana> getDiassemana() {
		return diassemana;
	}

	public void setDiassemana(List<DiasSemana> diassemana) {
		this.diassemana = diassemana;
	}

	public Date getHorarioinicial() {
		return horarioinicial;
	}

	public void setHorarioinicial(Date horarioinicial) {
		this.horarioinicial = horarioinicial;
	}
	
	public Date getHorariofinal() {
		return horariofinal;
	}

	public void setHorariofinal(Date horariofinal) {
		this.horariofinal = horariofinal;
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

	public Salas getSalaaula() {
		return salaaula;
	}

	public void setSalaaula(Salas salaaula) {
		this.salaaula = salaaula;
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
	
	
	
}
