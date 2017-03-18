package br.com.julios.ccc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	
	public static String parametroVazio(String param){
		if(param == null || param.length() == 0)
			return null;
		return param;
	}
	
	
	public static Date parseDate(String valor) throws ParseException{
		if(valor == null)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(valor);
	}
}
