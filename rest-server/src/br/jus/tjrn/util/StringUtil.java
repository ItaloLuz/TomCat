package br.jus.tjrn.util;

public class StringUtil {

	public static String retirarEspacos(String texto){
		texto = texto.trim();
		texto = texto.replaceAll("\\s+", " ");
		return texto;
	}
}
