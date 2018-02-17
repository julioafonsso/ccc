
package br.com.julios.ccc.infra.bd.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.julios.ccc.infra.Contexto;
import br.com.julios.ccc.infra.dto.fluxo_caixa.CadastroFluxoCaixaDTO;
import br.com.julios.ccc.repositorios.FluxoCaixaRepositorio;

@Entity
@Table(name = "fluxo_caixa")
public class FluxoCaixaDO {
	
	@Transient
	private FluxoCaixaRepositorio repositorio;
	
	public FluxoCaixaRepositorio getRepositorio() {
		if(this.repositorio == null)
			this.repositorio = Contexto.bean(FluxoCaixaRepositorio.class);
		return repositorio;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private Double valor;
	
	@Column
	private Long quantidade;
	
	@Column
	private String descricao;
	
	@Column
	private String observacao;
	
	
	@Column(name = "data_fluxo")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@ManyToOne
	@JoinColumn(name = "id_tipo_fluxo")
	private TipoFluxoCaixaDO tipoFluxo;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private UsuarioDO userLancamento;

	
	
	//Getters and Setters

	public void setData(Date data) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		this.data = sdf.parse(sdf.format(data));
	}

	public Long getId() {
		return id;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public TipoFluxoCaixaDO getTipoFluxo() {
		return tipoFluxo;
	}
	
	


	public void setTipoFluxo(TipoFluxoCaixaDO tipoFluxo) {
		this.tipoFluxo = tipoFluxo;
	}

	public UsuarioDO getUserLancamento() {
		return userLancamento;
	}

	public Date getData() {
		return data;
	}

	public void cadastrar() {
		this.getRepositorio().cadastrar(this);
		
	}

	public void alterar(CadastroFluxoCaixaDTO fluxoCaixa) throws ParseException {
		this.setObservacao(fluxoCaixa.getObservacao());
		this.setDescricao(fluxoCaixa.getDescricao());
		this.setData(fluxoCaixa.getData());
		this.setQuantidade(fluxoCaixa.getQtd());
		this.setValor(fluxoCaixa.getValor());
		this.setTipoFluxo(this.getRepositorio().getTipo(fluxoCaixa.getIdTipo()));
		this.getRepositorio().cadastrar(this);
	}

}
