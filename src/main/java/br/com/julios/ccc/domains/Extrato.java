package br.com.julios.ccc.domains;

import java.util.ArrayList;
import java.util.List;

public class Extrato {

	private String data;
	private double valor;
	private List<FluxoCaixa> fluxos;
	
	public Extrato(){
		this.fluxos = new ArrayList<FluxoCaixa>();
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
	
	public List<FluxoCaixa> getFluxos() {
		return fluxos;
	}
	
	public void addFluxoCaixa(FluxoCaixa fluxoCaixa) {
		this.fluxos.add(fluxoCaixa);
	}
	
	
	
	
	
}
