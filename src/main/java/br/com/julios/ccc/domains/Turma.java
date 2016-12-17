package br.com.julios.ccc.domains;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TURMA")
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	
	@Column /*OneToMany ou ManyToMany */
	private ModalidadeTurma modalidade;
	
	@Column /*OneToMany ou ManyToMany */
	private DiasSemana diassemana;
	
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
	
	@Column /*Verificar o tipo*/
	private int mensalidade;
	
	@Column
	private int vagas;
	
	@Column /*OneToMany ou ManyToMany */
	private Salas salaaula;
	
	@Column /*OneToMany ou ManyToMany */
	private NivelTurma nivel;
	

}
