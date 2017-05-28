package br.com.julios.ccc.infra.bd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String nome;
	
	@Column
	private boolean indEntrada;
	
	@Column
	private Date dataExclusao;
	
	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	//Getters and Setters

	public long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isIndEntrada() {
		return indEntrada;
	}

	public void setIndEntrada(boolean indEntrada) {
		this.indEntrada = indEntrada;
	}


}

