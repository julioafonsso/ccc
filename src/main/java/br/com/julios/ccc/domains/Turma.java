package br.com.julios.ccc.domains;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "TURMA")
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@ManyToOne
	@JoinColumn (name = "modalidade_id")
	private ModalidadeTurma modalidade;
	
	@ManyToMany
	@JoinTable(name = "turma_dias", joinColumns = @JoinColumn(name = "turma_id"), inverseJoinColumns = @JoinColumn(name = "dias_semana_id"))
	private List<DiasSemana> diassemana;
	
	@Column(name = "horario_inicial")
	@Temporal(TemporalType.TIME)
	private Calendar horarioinicial;
	
	@Column /*OneToMany ou ManyToMany */
	private Professor professor1;
	
	@Column
	private int percetual1;
	
	@Column /*OneToMany ou ManyToMany */
	private Professor professor2;
	
	@Column
	private int percentual2;
	
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
	
	@ManyToMany
	@JoinTable (name = "turma_professor", joinColumns = @JoinColumn (name = "turma_id"), inverseJoinColumns = @JoinColumn (name = "professor_id"))
	private List<Professor> professores;
	
	@ManyToMany
	@JoinTable (name ="turma_aluno", joinColumns = @JoinColumn (name = "turma_id"), inverseJoinColumns = @JoinColumn (name = "aluno_id"))
	private List<Aluno> alunos;
}
