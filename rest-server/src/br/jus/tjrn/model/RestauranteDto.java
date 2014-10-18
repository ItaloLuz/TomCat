package br.jus.tjrn.model;

public class RestauranteDto {
	
	private int idRestaurante;
	private String nome;
	private String imagem;
	
	public RestauranteDto(int id, String nome, String imagem) {
		this.idRestaurante = id;
		this.nome = nome;
		this.imagem = imagem;
	}
	
	public int getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
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