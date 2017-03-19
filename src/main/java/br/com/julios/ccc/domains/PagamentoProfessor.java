package br.com.julios.ccc.domains;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "pagamento_professor")
public class PagamentoProfessor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Professor professor;

	@ManyToOne
	private Mensalidades mensalidade;

	@OneToOne
	private FluxoCaixa fluxoCaixa;

	private Date dataExclusao;

	@Transient
	private Double percentual;

	@Transient
	private Double valor;

	public Double getPercentual() {
		if (mensalidade.getMatricula().getTurma().getProfessor1() != null
				&& mensalidade.getMatricula().getTurma().getProfessor1().getId() == this.professor.getId())
			return mensalidade.getMatricula().getTurma().getPercentualProfessor1();

		if (mensalidade.getMatricula().getTurma().getProfessor2() != null
				&& mensalidade.getMatricula().getTurma().getProfessor2().getId() == this.professor.getId())
			return mensalidade.getMatricula().getTurma().getPercentualProfessor2();

		return 0.0;
	}

	public Double getValor() {
		return this.mensalidade.getFluxoCaixa().getValor() * this.getPercentual() / 100;
	}

	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Mensalidades getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(Mensalidades mensalidade) {
		this.mensalidade = mensalidade;
	}

	public FluxoCaixa getFluxoCaixa() {
		return fluxoCaixa;
	}

	public void setFluxoCaixa(FluxoCaixa fluxoCaixa) {
		this.fluxoCaixa = fluxoCaixa;
	}

}
