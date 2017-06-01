package br.com.julios.ccc.infra.bd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.julios.ccc.infra.Contexto;
import br.com.julios.ccc.repositorios.PagamentoFuncionarioRepositorio;

@Entity
@Table(name = "pagamento_funcionarios")
@Inheritance(strategy = InheritanceType.JOINED)
public class PagamentoFuncionariosDO {

	@Autowired
	@Transient
	PagamentoFuncionarioRepositorio repositorio;
	
	
	
	public PagamentoFuncionarioRepositorio getRepositorio() {
		if(this.repositorio == null)
		{
			this.repositorio = Contexto.bean(PagamentoFuncionarioRepositorio.class);
		}
		return repositorio;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_funcionario")
	private FuncionarioDO funcionario;

	@Column(name = "valor")
	private Double valor;

	@ManyToOne
	@JoinColumn(name = "id_mes_referencia")
	private MesReferenciaDO mesReferencia;

	@ManyToOne
	@JoinColumn(name = "id_fluxo_caixa")
	private FluxoCaixaDO fluxoCaixa;

	@Column
	private Date dataExclusao;

	public Long getId() {
		return id;
	}

	public FuncionarioDO getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioDO funcionario) {
		this.funcionario = funcionario;
	}

	public Double getValor() {
		return valor;
	}

	protected void setValor(Double valor) {
		this.valor = valor;
	}

	public MesReferenciaDO getMesReferencia() {
		return mesReferencia;
	}
	
	public void setMesReferencia(MesReferenciaDO mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public void setFluxoCaixa(FluxoCaixaDO fluxoCaixa) {
		this.fluxoCaixa = fluxoCaixa;
	}

	public FluxoCaixaDO getFluxoCaixa() {
		return fluxoCaixa;
	}

	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}
	
	public String getNomeFuncionario() {
		return this.getFuncionario().getNome();
	}

	public String getMes() {
		return this.getMesReferencia().getNomeMes();
	}

	
	public void efetuarPagamento(FluxoCaixaDO pagamento) throws Exception {
		if(this.getFluxoCaixa() != null )
		{
			throw new Exception("Salario já esta pago!");
		}
				
		if(pagamento.getValor() > this.getValor())
			throw new Exception ("Valor maior que o esperado !");
		this.setFluxoCaixa(pagamento);
		this.getRepositorio().cadastrar(this);
	}

}
