package br.com.julios.ccc.infra.dto.aluno;

import java.util.List;

import br.com.julios.ccc.infra.dto.menslidade.ConsultaMensalidadeDTO;
import br.com.julios.ccc.infra.dto.turma.individual.CadastroAulaIndividualDTO;
import br.com.julios.ccc.infra.dto.turma.workshop.ConsultaWorkShopDTO;

public class CadastroPagamentosDTO {

	private List<ConsultaMensalidadeDTO> mensalidadesParaPagar;
	private List<CadastroAulaIndividualDTO> aulasParticulares;
	private List<ConsultaWorkShopDTO> workShop;
	private List<CadastroPagamentoMaticulaDTO> matriculas;
	private List<CadastroPagamentoTaxaDTO> taxas;
	private List<CadastroPagamentoAulasAvulsaDTO> 	aulasAvulsa;
	
	
	public List<CadastroPagamentoAulasAvulsaDTO> getAulasAvulsa() {
		return aulasAvulsa;
	}
	public void setAulasAvulsa(List<CadastroPagamentoAulasAvulsaDTO> aulasAvulsa) {
		this.aulasAvulsa = aulasAvulsa;
	}
	public List<CadastroPagamentoTaxaDTO> getTaxas() {
		return taxas;
	}
	public void setTaxas(List<CadastroPagamentoTaxaDTO> taxas) {
		this.taxas = taxas;
	}
	public List<CadastroPagamentoMaticulaDTO> getMatriculas() {
		return matriculas;
	}
	public void setMatriculas(List<CadastroPagamentoMaticulaDTO> matriculas) {
		this.matriculas = matriculas;
	}
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
