package br.jus.tjrn.abstracts;

import java.util.List;

/**
 * Classe Abstrata que guarda informacoes em comum para os bean
 * 
 * @author luan
 *
 * @param <T>
 */
public class AbstractBean<T> {
	
	/** Objeto que o bean manipula */
	private T obj;
	
	/** Lista de objecto que o bean manipula */
	private List<T> lista;
	
	/** get's and set's */
	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public List<T> getLista() {
		return lista;
	}

	public void setLista(List<T> lista) {
		this.lista = lista;
	}

}
