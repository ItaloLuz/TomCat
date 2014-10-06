package br.jus.tjrn.controller;

import java.io.Serializable;
import java.util.Arrays;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.jus.tjrn.abstracts.AbstractBean;
import br.jus.tjrn.model.TipoCertidao;

@ManagedBean
@ViewScoped
public class TipoCertidaoBean extends AbstractBean<TipoCertidao> implements Serializable {
	
	/** */
	private static final long serialVersionUID = 1L;

	public TipoCertidaoBean() {
		TipoCertidao[] tipos = TipoCertidao.values();
		
		setLista(Arrays.asList(tipos));
	}

}
