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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "mensalidades")
public class Mensalidades {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private MesReferencia mesReferencia;

	@OneToOne
	private FluxoCaixa fluxoCaixa;

	@ManyToOne
	private Matricula matricula;
	
	private Double valorMensalidade;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date dataVencimento;

	@Transient
	private Double valorCalculado;
	
	@Transient
	private Double valorParaPagar;
	
	public Double getValorParaPagar() {
		return valorParaPagar;
	}

	public void setValorParaPagar(Double valorParaPagar) {
		this.valorParaPagar = valorParaPagar;
	}

	@Transient
	private Double desconto;
	
	private Date dataExclusao;

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	public Double getValorMensalidade() {
		return valorMensalidade;
	}

	public void setValorMensalidade(Double valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}
	
	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	public Double getDesconto(){
		if (matricula.getDesconto() != null)
			return getValorMensalidade() * matricula.getDesconto().getValor()/100;
		return 0.0;
	}
	
	public Double getValorCalculado() throws Exception {
		
		Date hoje = new Date();
		

		if (getDataVencimento().before(hoje)) {
			return getValorMensalidade() * 1.1;
		} else {
			return getValorMensalidade() - getDesconto();
		}
	}

	public void setValorCalculado(Double valorCalculado) {
		this.valorCalculado = valorCalculado;
	}

	public MesReferencia getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(MesReferencia mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Long getId() {
		return id;
	}

	public FluxoCaixa getFluxoCaixa() {
		return fluxoCaixa;
	}

	public void setFluxoCaixa(FluxoCaixa fluxoCaixa) {
		this.fluxoCaixa = fluxoCaixa;
	}

	
}
