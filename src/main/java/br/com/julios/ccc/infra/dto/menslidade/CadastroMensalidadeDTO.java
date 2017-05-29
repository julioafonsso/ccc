package br.com.julios.ccc.infra.dto.menslidade;

import java.util.Date;

public class CadastroMensalidadeDTO {


	private Long idMatricula;;
	private Long idMesReferecia;
	private Date dataVencimento;
	
	
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public Long getIdMatricula() {
		return idMatricula;
	}
	public void setIdMatricula(Long idMatricula) {
		this.idMatricula = idMatricula;
	}
	public Long getIdMesReferecia() {
		return idMesReferecia;
	}
	public void setIdMesReferecia(Long idMesReferecia) {
		this.idMesReferecia = idMesReferecia;
	}
	
	
}
