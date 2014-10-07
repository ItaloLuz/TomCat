package br.jus.tjrn.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarUtil {
	
	private static Long DAY = 24L * 60L * 60L * 1000L;
	
	public static final String DATA_HORA_EXTENSO = "EEEE', 'd' de 'MMMM' de 'yyyy' às 'HH'h'mm'm'.";

	public static String getDiaExtenso(Date data) {
		Calendar calendar = new GregorianCalendar();
		Date hoje = new Date();
		calendar.setTime(hoje);

		int dia = calendar.get(Calendar.DAY_OF_WEEK);

		switch (dia) {
			case 1:	return "Domingo";
			case 2:	return "Segunda";
			case 3:	return "Terça";
			case 4:	return "Quarta";
			case 5:	return "Quinta";
			case 6:	return "Sexta";
			case 7:	return "Sábado";
		}
		return "";
	}

	public static String getMesExtenso(Date data) {
		Calendar calendar = new GregorianCalendar();
		Date hoje = new Date();
		calendar.setTime(hoje);

		int mes = calendar.get(Calendar.MONTH);

		switch(mes) {  
			case 1:  return "Janeiro";  
			case 2:  return "Fevereiro";  
			case 3:  return "Março";  
			case 4:  return "Abril";  
			case 5:  return "Maio";  
			case 6:  return "Junho";  
			case 7:  return "Julho";  
			case 8:  return "Agosto";  
			case 9:  return "Setembro";  
			case 10: return "Outubro";  
			case 11: return "Novembro";  
			case 12: return "Dezembro";  
	    }  
		return "";
	}
	
	public static int diferencaEmDias(Date dataInicial, Date dataFinal) {
		long diferenca = dataInicial.getTime() - dataFinal.getTime();
		
		return (int) (Math.abs(diferenca) / DAY);
	}
	
}
