package br.com.julios.ccc.infra.bd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.julios.ccc.infra.Contexto;
import br.com.julios.ccc.infra.dto.fluxo_caixa.CadastroTipoFluxoDTO;
import br.com.julios.ccc.repositorios.TipoFluxoRepositorio;

@Entity
@Table(name = "TIPO_FLUXO_CAIXA")
public class TipoFluxoCaixaDO {

	public static final Long MENSALIDADE = new Long(1);
	public static final Long PAGAMENTO_PROFESSOR = new Long(2);
	public static final Long MATRICULA = new Long(3);
	public static final Long AULA_PARTICULAR = new Long(4);
	public static final Long WORKSHOP = new Long(5);
	public static final Long PAGAMENTO_SALARIO = new Long(6);
	public static final Long PAGAMENTO_VALE_TRANSPORTE = new Long(7);
	public static final Long PAGAMENTO_TAXA_ARMARIO = new Long(8);
	public static final Long PAGAMENTO_AULA_AVULSA = new Long(9);
	public static final Long PAGAMENTO_TAXA_FERIAS = new Long(10);

	@Transient
	private TipoFluxoRepositorio repositorio;

	private TipoFluxoRepositorio getRepositorio() {
		if(this.repositorio == null)
			this.repositorio = Contexto.bean(TipoFluxoRepositorio.class);
		return this.repositorio;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String nome;

	@Column
	private boolean indEntrada;
	
	@Column(name = "data_exclusao")
	@Temporal(TemporalType.DATE)
	private Date dataExclusao;

	

	// Getters and Setters

	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) throws Exception {
		TipoFluxoCaixaDO tipo = this.getRepositorio().get(nome, this.isIndEntrada());
		if (tipo != null) {
			if (!tipo.getId().equals(this.getId())) {
				throw new Exception("Tipo já cadastrado !");
			}
		}
		this.nome = nome;
	}

	public boolean isIndEntrada() {
		return indEntrada;
	}

	public void setIndEntrada(boolean indEntrada) {
		this.indEntrada = indEntrada;
	}
	
	public void cadastrar(){
		this.getRepositorio().cadastrar(this);
	}

	public void atualizar(CadastroTipoFluxoDTO cadastro) throws Exception {
		this.setIndEntrada(cadastro.isIndEntrada());
		this.setNome(cadastro.getNome());
		this.cadastrar();
	}

	public void deletar() throws Exception {
		
		if(this.getRepositorio().getQtdFluxoCadastrados(this).longValue() > 0)
			throw new Exception("Não pode ser excluido, existe lançamentos com esse tipo !");
		
		this.setDataExclusao(new Date());
		this.getRepositorio().cadastrar(this);
	}

}
