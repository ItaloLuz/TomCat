package br.jus.tjrn.report;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import br.jus.tjrn.util.FacesUtil;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;

/**
 * Transfroma um html em pdf.
 * As classes que geram os pdfs devem herdar o essa classe.
 * E devem implementar o getContents
 * 
 * @author luan
 *
 */
public abstract class Html2Pdf {
	
	public static final String PATH_PDF = "reports/report/pdf.pdf";
	
	/**
	 * Gera o pdf
	 * 
	 * @param pathHtml
	 * @throws DocumentException
	 * @throws IOException
	 */
	public void gerarPdf(String pathHtml) {
		VelocityEngineUtil velocity = new VelocityEngineUtil(getContent(), pathHtml);
		// gera o arquivo com os dados ja manipulados
		velocity.gerarArquivo();
		
		Document document = new Document();
		PdfWriter writer;
		try {
			writer = PdfWriter.getInstance(document,
					new FileOutputStream(FacesUtil.getContext() + PATH_PDF));
			document.open();
			XMLWorkerHelper.getInstance().parseXHtml(writer, document,
					new FileInputStream(VelocityEngineUtil.PATH_TEMPLATES + VelocityEngineUtil.ARQUIVO_GERADO));
			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo para colocar os atributos que seram manipulados no html
	 * 
	 * @return
	 */
	public abstract HashMap<String, Object> getContent();

}
