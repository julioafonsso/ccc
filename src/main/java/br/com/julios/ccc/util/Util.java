package br.com.julios.ccc.util;

public class Util {

	
	public static String parametroVazio(String param){
		if(param == null || param.length() == 0)
			return null;
		return param;
	}
	
}
