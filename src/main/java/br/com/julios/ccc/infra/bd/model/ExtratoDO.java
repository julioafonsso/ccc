package br.com.julios.ccc.infra.bd.model;

import java.util.ArrayList;
import java.util.List;

public class ExtratoDO {

	private String data;
	private double valor;
	private List<FluxoCaixaDO> fluxos;
	
	public ExtratoDO(){
		this.fluxos = new ArrayList<FluxoCaixaDO>();
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public void addValor(double valor){
		this.valor += valor;
	}
	
	public List<FluxoCaixaDO> getFluxos() {
		return fluxos;
	}
	
	public void addFluxoCaixa(FluxoCaixaDO fluxoCaixa) {
		this.fluxos.add(fluxoCaixa);
	}
	
	
	
	
	
}
