package br.com.julios.ccc.negocio.turma.modalidade;

import br.com.julios.ccc.infra.dto.turma.ModalidadeDTO;

public class ModalidadeTurma {

	private ModalidadeTurmaRepositorio repositorio;
	
	public ModalidadeTurma(ModalidadeDTO modalidade, ModalidadeTurmaRepositorio modalidadeTurmaRepositorio) {
		this.repositorio = modalidadeTurmaRepositorio;	
		this.setId(modalidade.getId());
		this.setNome(modalidade.getNome());
		
	}
	
	private Long id;
	private String nome;
	
	public Long getId() {
		return id;
	}
	protected void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	protected void setNome(String nome) {
		this.nome = nome;
	}
	
	public void cadastrar() throws Exception{
		this.validaNome();
		this.repositorio.cadastrar(this);
	}
	
	private void validaNome() throws Exception{
		if(repositorio.qtdModalidadesPorNome(getNome()).intValue() > 0 )
		{
			throw new Exception ("Modalidade já cadastrada");
		}
	}

	

	
	
}
