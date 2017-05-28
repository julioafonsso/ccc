package br.com.julios.ccc.componentes;

public class Telefone {

	public static String getSemFormato(String telefone)
	{
		if(telefone == null)
			return "";
		return telefone.replaceAll("[^0-9]", "");
	}
	
}
