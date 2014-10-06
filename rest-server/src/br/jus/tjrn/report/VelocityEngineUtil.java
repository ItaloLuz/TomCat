package br.jus.tjrn.report;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import br.jus.tjrn.util.FacesUtil;
import br.jus.tjrn.util.FileUtils;

public class VelocityEngineUtil {
	
	public static final String PATH_VELOCITY = "reports/velocity/";
	
	public static final String PATH_TEMPLATES = FacesUtil.getContext() + PATH_VELOCITY;
	public static final String PATH_REPORT = FacesUtil.getContext() + "reports/report";
	public static final String ARQUIVO_MONTADO = "arquivoMontado.html";
	public static final String ARQUIVO_GERADO = "arquivoGerado.html";
	
	private VelocityEngine ve = new VelocityEngine();
	
	private VelocityContext context;
	
	private String pathHtml;

	private HashMap<String, Object> contents;
	
	/**
	 * Inicia os atributos
	 * 
	 * @param contents dados que irao para o template
	 * @param pathHtml path do template
	 */
	public VelocityEngineUtil(HashMap<String, Object> contents, String pathHtml) {
		context = new VelocityContext();
		this.pathHtml = pathHtml;
		this.contents = contents;
		
		addParans();
	}
	
	/**
	 * Add parametros para serem usados no tempalte
	 */
	private void addParans() {
		addParansPadroes();
		
		addParansEscecificos();
	}
	
	/**
	 * Add parametros que sao padroes para todos os templates
	 */
	private void addParansPadroes() {
		context.put("path", PATH_REPORT);
	}

	/**
	 * Add parametros passados pela classe
	 */
	private void addParansEscecificos() {
		for( String key : contents.keySet() )  {
			context.put(key, contents.get(key));
		}
	}

	/**
	 * Seta as propriedades do Velocity
	 */
	private void init() {
        Properties p = new Properties();  
        p.put("file.resource.loader.path",FacesUtil.getContext() + PATH_VELOCITY);  
        p.put("file.resource.loader.cache ","true");  
        p.put("file.resource.loader.modificationCheckInterval ","10000");  
  
        ve.init( p );  
	}
	
	public void gerarArquivo() {
		// cria o arquivo montado
		String content = FileUtils.ler(PATH_REPORT + "/" + pathHtml);
		FileUtils.escrever(PATH_TEMPLATES + ARQUIVO_MONTADO, content);
		
		// inicia o velocitu
		init();
		
		// pega os dados do arquivo que foi montado
		Template t = ve.getTemplate(ARQUIVO_MONTADO);
		/* now render the template into a Writer */
		StringWriter writer = new StringWriter();
		t.merge(context, writer);
		
		// passar conteudo para o html
		FileUtils.escrever(PATH_TEMPLATES+ARQUIVO_GERADO, writer.toString());
	}

}
