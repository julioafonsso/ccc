package br.com.julios.ccc.infra.dto;

public class EmailDTO {


	private String assunto;
	private String texto;
	private String urlFoto;
	private String teste;
	
	public String getTeste() {
		if(teste == null || teste.length() == 0)
			return "S";
		return teste;
	}
	public void setTeste(String teste) {
		this.teste = teste;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getUrlFoto() {
		return urlFoto;
	}
	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}
	
	
}
