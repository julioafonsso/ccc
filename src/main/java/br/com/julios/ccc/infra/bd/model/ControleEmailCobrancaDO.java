package br.com.julios.ccc.infra.bd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import br.com.julios.ccc.repositorios.AlunoRepositorio;

@Entity
@Table(name = "controle_email_cobranca")
public class ControleEmailCobrancaDO {

	@Transient
	AlunoRepositorio repositorio;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "data_fluxo")
	@Temporal(TemporalType.DATE)
	private Date dataEnvio;
	
	
	@ManyToOne
	private MatriculaDO matricula;

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public MatriculaDO getMatricula() {
		return matricula;
	}

	public void setMatricula(MatriculaDO matricula) {
		this.matricula = matricula;
	}
	
	
}
