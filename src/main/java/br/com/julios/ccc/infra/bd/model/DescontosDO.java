package br.com.julios.ccc.infra.bd.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "tipo_desconto")
public class DescontosDO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private Integer valor;
	
	@Column
	private Date dataExclusao;

	@OneToMany(mappedBy = "desconto")
	@Where(clause = "data_exclusao is null or data_exclusao > CURRENT_DATE")
	private List<MatriculaDO> matriculas;
	
	//Getters and Setters
	
	public List<MatriculaDO> getMatriculas() {
		return matriculas;
	}

	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

}
