package br.com.julios.ccc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public static Double convertToDouble(String valor) {
		if(valor == null)
			return null;
		String tmp = valor;
		if (valor.contains(".") || valor.contains(",")) {
			tmp = valor.replaceAll("\\.", "").replaceAll(",", "");

			tmp = tmp.substring(0, tmp.length() - 2) + "." + tmp.substring(tmp.length() - 2);
		}

		return new Double(tmp);

	}

	public static String parametroVazio(String param) {
		if (param == null || param.length() == 0)
			return null;
		return param;
	}

	public static Date parseDate(String valor) throws ParseException {
		if (valor == null || valor.length() == 0)
			return null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(valor);
	}
}
