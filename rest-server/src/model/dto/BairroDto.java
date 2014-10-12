package model.dto;

public class BairroDto {
	
	private String nome;
	private String imagem;
	
	public BairroDto(String nome, String imagem) {
		super();
		this.nome = nome;
		this.imagem = imagem;
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
