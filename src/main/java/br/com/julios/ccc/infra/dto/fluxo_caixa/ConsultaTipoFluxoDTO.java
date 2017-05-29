package br.com.julios.ccc.infra.dto.fluxo_caixa;

public class ConsultaTipoFluxoDTO {

	public ConsultaTipoFluxoDTO(Long id, String nome, boolean indEntrada) {
		this.setId(id);
		this.setIndEntrada(indEntrada);
		this.setNome(nome);
	}

	private Long id;
	private String nome;
	private boolean indEntrada;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isIndEntrada() {
		return indEntrada;
	}

	public void setIndEntrada(boolean indEntrada) {
		this.indEntrada = indEntrada;
	}

}
