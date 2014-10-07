package br.jus.tjrn.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtils {
    private static URL PATH;
    
    public PropertiesUtils(){  
        PATH = getClass().getClassLoader().getResource("properties/database/guia_cardapio.properties");
    }    
    
    public static final String[] properties = new String[]{"javax.persistence.jdbc.url", "javax.persistence.jdbc.user", "javax.persistence.jdbc.password"};
    
    public static final String PATH_PROPERTIES = "WEB-INF/classes/properties/database/";
	
	public static Map<String, String> getDados(String pathFile) throws IOException {
		Map<String, String> persistenceMap = new HashMap<String, String>();
		Properties prop = getProp(pathFile);
		
		for(String propertie : properties) {
			persistenceMap.put(propertie, prop.getProperty(propertie));
		}

		return persistenceMap;
	}

	private static Properties getProp(String pathFile) throws IOException {
	    new PropertiesUtils();
		Properties props = new Properties();					
		FileInputStream file = new FileInputStream(
		        PATH.toString().substring(6)
			);  
		props.load(file);
		return props;
	}

}