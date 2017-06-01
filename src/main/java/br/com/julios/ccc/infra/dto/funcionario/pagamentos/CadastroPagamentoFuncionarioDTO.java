package br.com.julios.ccc.infra.dto.funcionario.pagamentos;

import br.com.julios.ccc.util.Util;

public class CadastroPagamentoFuncionarioDTO {
	
	private Double valor;

	public Double getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = Util.convertToDouble(valor);
	}
	
	

}
