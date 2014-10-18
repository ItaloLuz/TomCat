package br.jus.tjrn.model;

public class PratoDto {
	
	private RestauranteDto restaurante;
	private String nome;
	private String imagem;
	
	public PratoDto(RestauranteDto restaurante, String nome, String imagem) {
		super();
		this.restaurante = restaurante;
		this.nome = nome;
		this.imagem = imagem;
	}
	
	public RestauranteDto getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(RestauranteDto restaurante) {
		this.restaurante = restaurante;
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

}