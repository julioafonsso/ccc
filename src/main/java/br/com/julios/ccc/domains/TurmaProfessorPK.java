package br.com.julios.ccc.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TurmaProfessorPK implements Serializable{
	
	@Column(name = "professor_id")
	private Long professor_id;
	
	@Column(name = "turma_id")
	private Long turma_id;

}
