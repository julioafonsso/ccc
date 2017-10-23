package br.com.julios.ccc.infra.dto.aluno;

import java.util.List;

import br.com.julios.ccc.infra.dto.menslidade.ConsultaMensalidadeDTO;
import br.com.julios.ccc.infra.dto.turma.individual.CadastroAulaIndividualDTO;
import br.com.julios.ccc.infra.dto.turma.workshop.ConsultaWorkShopDTO;

public class CadastroPagamentosDTO {

	private List<ConsultaMensalidadeDTO> mensalidadesParaPagar;
	private List<CadastroAulaIndividualDTO> aulasParticulares;
	private List<ConsultaWorkShopDTO> workShop;
	 
	
	
	public List<ConsultaWorkShopDTO> getWorkShop() {
		return workShop;
	}
	public void setWorkShop(List<ConsultaWorkShopDTO> workShop) {
		this.workShop = workShop;
	}
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
