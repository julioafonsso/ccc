package br.com.julios.ccc.infra.bd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.julios.ccc.infra.Contexto;
import br.com.julios.ccc.negocio.ComissaoRepositorio;

@Entity
@Table(name = "pagamento_professor")
@PrimaryKeyJoinColumn(name="id")
public class ComissaoProfessorDO extends PagamentoFuncionariosDO{

	@Autowired
	@Transient
	ComissaoRepositorio repositorio;
	
	@ManyToOne
	@JoinColumn(name="id_mensalidade")
	private MensalidadeDO mensalidade;

	@Column
	private Double percentual;


	public MensalidadeDO getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(MensalidadeDO mensalidade) {
		this.mensalidade = mensalidade;
		this.setPercentual(mensalidade.getPercentualFuncionario(this.getFuncionario()));
	}

	public Double getPercentual() {
		return percentual;
	}

	private void setPercentual(Double percentual) {
		this.percentual = percentual;
	}

	private void calcular() {
		this.setValor(this.getMensalidade().getValorPago() * this.getPercentual() / 100);
		
	}

	public ComissaoRepositorio getComissaoRepositorio(){
		if(this.repositorio == null)
			this.repositorio = Contexto.bean(ComissaoRepositorio.class);
		return this.repositorio;
	}
	
	public void cadastrar() {
		this.calcular();
		this.getComissaoRepositorio().cadastrar(this);
	}

	public String getNomeFuncionario() {
		return this.getFuncionario().getNome();
	}

	public String getNomeMes() {
		return this.getMesReferencia().getNomeMes();
	}

	public void efetuarPagamento(FluxoCaixaDO pagamento) {
		this.setFluxoCaixa(pagamento);
		this.getComissaoRepositorio().cadastrar(this);
	}

	
	
	
}
