package br.com.julios.ccc.infra.dto.funcionario.pagamentos;

import java.util.Date;

public class ConsultaSalarioDTO extends ConsultaPagamentoFuncionarioDTO {

	private Date dataPagamento;
	private String situacao;

	public ConsultaSalarioDTO(Long id, Long mes, Long ano, Double valor, Date dataPagamento, Double valorPago) {
		this.setId(id);
		this.setDataPagamento(dataPagamento);
		this.setMesReferencia(mes + "/" + ano);
		
		if(dataPagamento == null)
		{
			this.setSituacao("Pendente");
			this.setValor(valor);
		}
		else
		{
			this.setSituacao("Pago");
			this.setValor(valorPago);
		}
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
