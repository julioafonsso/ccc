package br.com.julios.ccc.infra.dto.aluno;

import java.util.List;

import br.com.julios.ccc.infra.dto.menslidade.ConsultaMensalidadeDTO;
import br.com.julios.ccc.infra.dto.turma.individual.CadastroAulaIndividualDTO;

public class CadastroPagamentosDTO {

	private List<ConsultaMensalidadeDTO> mensalidadesParaPagar;
	private List<CadastroAulaIndividualDTO> aulasParticulares;
	
	public List<ConsultaMensalidadeDTO> getMensalidadesParaPagar() {
		return mensalidadesParaPagar;
	}
	public void setMensalidadesParaPagar(List<ConsultaMensalidadeDTO> mensalidadesParaPagar) {
		this.mensalidadesParaPagar = mensalidadesParaPagar;
	}
	public List<CadastroAulaIndividualDTO> getAulasParticulares() {
		return aulasParticulares;
	}
	public void setAulasParticulares(List<CadastroAulaIndividualDTO> aulasParticulares) {
		this.aulasParticulares = aulasParticulares;
	}
	
	
	
}
