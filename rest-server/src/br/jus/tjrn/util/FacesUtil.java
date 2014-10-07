package br.jus.tjrn.util;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

public class FacesUtil {

	public static String getContext() {
		ServletContext servletContext = getServletContext();
		
		return servletContext.getRealPath("/");
	}

	public static ServletContext getServletContext() {
		System.out.println(FacesContext.getCurrentInstance().getExternalContext());
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		return (ServletContext) externalContext.getContext();
	}
	
}
