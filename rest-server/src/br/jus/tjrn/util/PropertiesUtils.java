package br.jus.tjrn.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import properties.database.*;

public class PropertiesUtils {
    
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
		Properties props = new Properties();  
		FileInputStream file = new FileInputStream(
				//String.format( FacesUtil.getContext() + "%s%s", PATH_PROPERTIES, pathFile)
				"C:/Users/Italo/workspace/App/rest-server/src/properties/database/guia_cardapio.properties"
			);  
		props.load(file);
		return props;
	}

}
