package br.com.julios.ccc.infra.bd.model;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;
import org.hibernate.annotations.Where;

@Table(name = "turma")
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
public class TurmaDO {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

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

	@OneToMany(mappedBy = "turma")
	@Where(clause = "data_exclusao is null or data_exclusao > CURRENT_DATE")
	private List<MatriculaDO> matriculas;

	@Formula("(select count(*) from matricula ta , aluno a where a.id = ta.aluno_id and a.sexo = 'M' and ta.turma_id = id and ta.data_exclusao is null)")
	private Integer qtdAlunos;

	@Formula("(select count(*) from matricula ta , aluno a where a.id = ta.aluno_id and a.sexo = 'F' and ta.turma_id = id and ta.data_exclusao is null	)")
	private Integer qtdAlunas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

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

	public void setProfessor1(FuncionarioDO professor1) {
		this.professor1 = professor1;
	}

	public Double getPercentualProfessor1() {
		return percentualProfessor1;
	}

	public void setPercentualProfessor1(Double percentualProfessor1) {
		this.percentualProfessor1 = percentualProfessor1;
	}

	public List<MatriculaDO> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<MatriculaDO> matriculas) {
		this.matriculas = matriculas;
	}

	public Integer getQtdAlunos() {
		return qtdAlunos;
	}

	public Integer getQtdAlunas() {
		return qtdAlunas;
	}

}