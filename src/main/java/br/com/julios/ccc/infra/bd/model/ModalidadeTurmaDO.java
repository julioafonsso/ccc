package br.com.julios.ccc.infra.bd.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.julios.ccc.infra.Contexto;
import br.com.julios.ccc.negocio.turma.modalidade.ModalidadeTurmaRepositorio;
import br.com.julios.ccc.negocio.turma.workshop.WorkShopRepositorio;

@Entity
@Table(name = "modalidade_turma")
public class ModalidadeTurmaDO {

	@Transient
	private ModalidadeTurmaRepositorio repositorio;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private Date dataExclusao;
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Exception {
		ModalidadeTurmaDO modalidade = this.getRepositorio().getModalidadePorNome(nome);
		if(modalidade != null)
		{
			if(!modalidade.getId().equals(id))
			{
				throw new Exception("Modalidade já cadastrada !");
			}
		}
		this.nome = nome;
	}

	public Date getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(Date dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	

	private ModalidadeTurmaRepositorio getRepositorio() {
		if(this.repositorio == null)
			this.repositorio = Contexto.bean(ModalidadeTurmaRepositorio.class);
		return repositorio;
	}

	public void cadastrar() {
		this.getRepositorio().cadastrar(this);
	}
	
	
	
	 
}
