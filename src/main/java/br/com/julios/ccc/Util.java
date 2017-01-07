package br.com.julios.ccc;

public class Util {

	
	public static String parametroVazio(String param){
		if(param == null || param.length() == 0)
			return null;
		return param;
	}
}
