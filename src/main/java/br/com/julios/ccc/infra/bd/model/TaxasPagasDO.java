package br.com.julios.ccc.infra.bd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.julios.ccc.infra.Contexto;
import br.com.julios.ccc.repositorios.TaxasPagasRepositorio;

@Entity
@Table(name = "taxas_pagas")
public class TaxasPagasDO {


	@Transient
	private TaxasPagasRepositorio repositorio;
	
	public TaxasPagasRepositorio getRepositorio() {
		if(this.repositorio == null)
			this.repositorio = Contexto.bean(TaxasPagasRepositorio.class);
		return repositorio;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "aluno_id")
	private AlunoDO aluno;
		
	@ManyToOne
	private FluxoCaixaDO pagamento;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AlunoDO getAluno() {
		return aluno;
	}

	public void setAluno(AlunoDO aluno) {
		this.aluno = aluno;
	}

	public FluxoCaixaDO getPagamento() {
		return pagamento;
	}

	public void setPagamento(FluxoCaixaDO pagamento) {
		this.pagamento = pagamento;
	}

	public void cadastrar() {
		this.getRepositorio().cadastrar(this);
		
	}

}
