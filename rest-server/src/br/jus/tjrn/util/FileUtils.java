package br.jus.tjrn.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileUtils {

	/**
	 * limpa um arquivo e coloca o conteudo passado por parametro
	 * 
	 * @param arquivo
	 * @param conteudo
	 */
	public static void escrever(String arquivo, String conteudo) {
		File file = new File(arquivo);

		try {
			Writer out = new FileWriter(arquivo);  
			//limpa  
			out.write("");  
			out.flush();  
			out.close();
			
			file.createNewFile();  
			
			// escreve no arquivo
			FileWriter fw = new FileWriter(file, true);

			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(conteudo);

			bw.newLine();

			bw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retorna o conteudo de um arquivo
	 * 
	 * @param arquivo
	 * @return
	 */
	public static String ler(String arquivo) {
		File file = new File(arquivo);

		String content = "";
		try {
			file.createNewFile();  
			
			FileReader fr = new FileReader(file);

			BufferedReader br = new BufferedReader(fr);

			// equanto houver mais linhas
			while (br.ready()) {
				// lê a proxima linha
				String linha = br.readLine();

				content += linha + "\n";
			}

			br.close();
			fr.close();

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		return content;
	}
	
}
