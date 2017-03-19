package br.com.julios.ccc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Teste {

	public static void main(String[] args) throws ParseException {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		c.setTime(sdf.parse("18/03/2017"));
		
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(sdf.parse("18/03/2017"));
		
		System.out.println(dayOfWeek);
		System.out.println(Calendar.SUNDAY);
		System.out.println(Calendar.MONDAY);
		System.out.println(Calendar.TUESDAY);
		System.out.println(Calendar.WEDNESDAY);
		System.out.println(Calendar.THURSDAY);
		System.out.println(Calendar.FRIDAY);
		System.out.println(Calendar.SATURDAY);
		

	}

}
