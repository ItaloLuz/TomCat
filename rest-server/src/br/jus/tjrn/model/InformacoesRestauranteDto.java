package br.jus.tjrn.model;

import java.util.List;

public class InformacoesRestauranteDto {
	
	private RestauranteDto restaurante;
	private List<PratoDto> pratos;
	private String telefone;
	private String endereco;
	private String descricao;
	
	public InformacoesRestauranteDto(RestauranteDto restaurante,
			List<PratoDto> pratos, String telefone, String endereco,
			String descricao) {
		super();
		this.restaurante = restaurante;
		this.pratos = pratos;
		this.telefone = telefone;
		this.endereco = endereco;
		this.descricao = descricao;
	}

	public RestauranteDto getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(RestauranteDto restaurante) {
		this.restaurante = restaurante;
	}

	public List<PratoDto> getPratos() {
		return pratos;
	}

	public void setPratos(List<PratoDto> pratos) {
		this.pratos = pratos;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
