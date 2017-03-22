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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
	
	
	@ManyToOne
	private Professor professor1;
	
	@Column
	private double percentualProfessor1;
	
	@ManyToOne
	private Professor professor2;
	
	@Column
	private double percentualProfessor2;
	
	
	@OneToMany(mappedBy = "turma")
		@JsonIgnoreProperties("turma")
	@Where(clause = "data_exclusao is null or data_exclusao > CURRENT_DATE")
	@JsonIgnore
	private List<Matricula> matriculas;
	
	@Formula("(select count(*) from matricula ta , aluno a where a.id = ta.aluno_id and a.sexo = 'M' and ta.turma_id = id and ta.data_exclusao is null)")
	private int qtdAlunos;
	
	@Formula("(select count(*) from matricula ta , aluno a where a.id = ta.aluno_id and a.sexo = 'F' and ta.turma_id = id and ta.data_exclusao is null	)")
	private int qtdAlunas;

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

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	public long getId() {
		return id;
	}
	
	public Professor getProfessor1() {
		return professor1;
	}

	public void setProfessor1(Professor professor1) {
		this.professor1 = professor1;
	}

	public Professor getProfessor2() {
		return professor2;
	}

	public void setProfessor2(Professor professor2) {
		this.professor2 = professor2;
	}

	public double getPercentualProfessor1() {
		return percentualProfessor1;
	}

	public void setPercentualProfessor1(double percentualProfessor1) {
		this.percentualProfessor1 = percentualProfessor1;
	}

	public double getPercentualProfessor2() {
		return percentualProfessor2;
	}

	public void setPercentualProfessor2(double percentualProfessor2) {
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

	public boolean temAula(int dayOfWeek) {
		if(dayOfWeek == 1)
			return isDomingo();
		if(dayOfWeek == 2)
			return isSegunda();
		if(dayOfWeek == 3)
			return isTerca();
		if(dayOfWeek == 4)
			return isQuarta();
		if(dayOfWeek == 5)
			return isQuinta();
		if(dayOfWeek == 6)
			return isSexta();
		if(dayOfWeek == 7)
			return isSabado();
		return false;
		
	}
	
	
}
