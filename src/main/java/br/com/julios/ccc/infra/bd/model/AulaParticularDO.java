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
	private Integer qtdAulasContratadas;
	
	@Column
	private Integer qtdAulasRestantes;
	
	@Column
	private Date dataContratacao;
	
	@Column
	private Date dataUltimaAula;
	
	
	
}
