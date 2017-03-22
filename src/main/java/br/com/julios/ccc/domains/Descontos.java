package br.com.julios.ccc.domains;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tipo_desconto")
public class Descontos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column
	private String nome;
	
	@Column
	private int valor;
	
	@Column
	private Date dataExclusao;

	@OneToMany(mappedBy = "desconto")
	@JsonIgnore
	@Where(clause = "data_exclusao is null or data_exclusao > CURRENT_DATE")
	private List<Matricula> matriculas;
	
	//Getters and Setters
	
	public List<Matricula> getMatriculas() {
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

	public void setValor(int valor) {
		this.valor = valor;
	}

	public long getId() {
		return id;
	}

}
