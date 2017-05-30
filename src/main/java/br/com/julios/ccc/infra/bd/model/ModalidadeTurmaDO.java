package br.com.julios.ccc.infra.bd.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.com.julios.ccc.infra.Contexto;
import br.com.julios.ccc.infra.dto.turma.ModalidadeDTO;
import br.com.julios.ccc.repositorios.ModalidadeTurmaRepositorio;

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

	public void atualizar(ModalidadeDTO cadastro) throws Exception {
		this.setNome(cadastro.getNome());
		this.cadastrar();
	}

	public void deletar() throws Exception {
		if(this.getRepositorio().getQtdTurmasAtivas(this).longValue() >0 )
			throw new Exception("Existe turma com essa modalidade !");
		
		this.setDataExclusao(new Date());
		this.cadastrar();
	}
	
	
	
	 
}
