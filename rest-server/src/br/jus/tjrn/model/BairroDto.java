package br.jus.tjrn.model;

import java.util.ArrayList;
import java.util.List;

public class BairroDto {
	
	private String nome;
	private String imagem;
	private List<RestauranteDto> restaurantes;
	
	public BairroDto(String nome, String imagem) {
		super();
		this.nome = nome;
		this.imagem = imagem;
		this.restaurantes = new ArrayList<RestauranteDto>();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getImagem() {
		return imagem;
	}
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public List<RestauranteDto> getRestaurantes() {
		return restaurantes;
	}

	public void setRestaurantes(List<RestauranteDto> restaurantes) {
		this.restaurantes = restaurantes;
	}

}