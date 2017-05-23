package br.com.julios.ccc.infra.dto.turma.individual;

import java.util.Date;

import br.com.julios.ccc.infra.dto.turma.ConsultaTurmaDTO;

public class ConsultaAulaIndividualDTO extends ConsultaTurmaDTO{
	
	public ConsultaAulaIndividualDTO(Long id,String codigo, Long idProfessor1, String nomeProfessor1, Double percentualProfessor1,
			Long idModalidade, String nomeModalidade, Long qtdAulasContratadas, Date dataContratacao, Double valor) {
		super(id, codigo, idProfessor1, nomeProfessor1, percentualProfessor1, idModalidade, nomeModalidade);
		this.setDataContratacao(dataContratacao);
		this.setQtdAulasContratadas(qtdAulasContratadas);
		this.setValorPago(valor);
	}
	private Long qtdAulasContratadas;
	private Long qtdAulasRestantes;
	private Date dataContratacao;
	private Date dataUltimaAula;
	private Double valorPago;
	
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
	public Date getDataContratacao() {
		return dataContratacao;
	}
	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}
	public Date getDataUltimaAula() {
		return dataUltimaAula;
	}
	public void setDataUltimaAula(Date dataUltimaAula) {
		this.dataUltimaAula = dataUltimaAula;
	}
	public Double getValorPago() {
		return valorPago;
	}
	public void setValorPago(Double valorPago) {
		this.valorPago = valorPago;
	}
	
	

}
