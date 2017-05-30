package br.com.julios.ccc.infra.bd.model;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import br.com.julios.ccc.infra.Contexto;
import br.com.julios.ccc.repositorios.AulaIndividualRepositorio;

@Entity
@Table(name = "aula_particular")
@PrimaryKeyJoinColumn(name = "id")
@Service
@Configurable(preConstruction = true)
public class AulaParticularDO extends TurmaDO {

	@Column
	private Long qtdAulasContratadas;

	@Column
	private Long qtdAulasRestantes;

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

	public Date getDataUltimaAula() {
		return dataUltimaAula;
	}

	public void setDataUltimaAula(Date dataUltimaAula) {
		this.dataUltimaAula = dataUltimaAula;
	}

	protected AulaIndividualRepositorio getRepositorio() {
		if (repositorio == null)
			repositorio = Contexto.bean(AulaIndividualRepositorio.class);
		return (AulaIndividualRepositorio) repositorio;
	}

	@Override
	protected void montaCodigo() {
		this.setCodigo("Particular");
	}

	@Override
	protected void salvar() {
		this.getRepositorio().cadastrar(this);
	}

	@Override
	public List<FuncionarioDO> getProfessores() {
		List<FuncionarioDO> professores = new ArrayList<FuncionarioDO>();
		if(this.getProfessor1() !=  null)
			professores.add(this.getProfessor1());
		
		return professores;
	}

	@Override
	public Double getPercentualDeAulasMes(MesReferenciaDO mesReferenciaDO, Date primeiroDia) throws ParseException {
		return new Double(1);
	}
}
