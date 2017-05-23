package br.com.julios.ccc.infra.bd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "aula_particular")
@PrimaryKeyJoinColumn(name="id")
public class AulaParticularDO extends TurmaDO{

	
	
	@Column
	private Long qtdAulasContratadas;
	
	@Column
	private Long qtdAulasRestantes;
	
	@Column
	private Date dataContratacao;
	
	@Column
	private Date dataUltimaAula;

	public Long getQtdAulasContratadas() {
		return qtdAulasContratadas;
	}

	public void setQtdAulasContratadas(Long qtdAulasContratadas) {
		this.qtdAulasContratadas = qtdAulasContratadas;
	}

	public Long getQtdAulasRestantes() {
		return qtdAulasRestantes;
	}

	public void setQtdAulasRestantes(Long qtdAulasRestantes) {
		this.qtdAulasRestantes = qtdAulasRestantes;
	}

	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public Date getDataUltimaAula() {
		return dataUltimaAula;
	}

	public void setDataUltimaAula(Date dataUltimaAula) {
		this.dataUltimaAula = dataUltimaAula;
	}
	
	
	
	
}
