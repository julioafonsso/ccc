package br.com.julios.ccc.infra.dto.funcionario.pagamentos;

import java.util.Date;

public class ConsultaComissaoConsolidadaDTO {

	
	private Long id;
	private Date data;
	private Double valor; 
	
	public ConsultaComissaoConsolidadaDTO(
			Long id,
			Double valor,
			Date data ) {
		
		this.setId(id);
		this.setValor(valor);
		this.setData(data);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
}
