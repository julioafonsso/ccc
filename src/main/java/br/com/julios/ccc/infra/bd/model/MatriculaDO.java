package br.com.julios.ccc.infra.bd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "matricula")
public class MatriculaDO {

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

	public TurmaDO getTurma() {
		return turma;
	}

	public void setTurma(TurmaDO turma) {
		this.turma = turma;
	}

	public AlunoDO getAluno() {
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

}
