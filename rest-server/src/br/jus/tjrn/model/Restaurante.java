package br.jus.tjrn.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = Restaurante.TB_NAME)
public class Restaurante implements Serializable  {
    
    private static final long serialVersionUID = 1L;
    
    public static final String TB_NAME = "tb_restaurante";

    private Integer id;
    private String nome;
    private String telefone;
    private String bairro;
    private String endereco;
    private String descricao;
    private String horario_funcionamento;
    private Integer quantidade_Pessoas;
    private String preco;
    private String cartoes;
    private String facebook;
    private String twitter;
    private String instagram;
    private String email;
    private String site;
    private String caminho_imagem_1;
    private String caminho_imagem_2;
    private String caminho_imagem_3;
    private String caminho_imagem_4;
    private String caminho_imagem_5;
    private String caminho_imagem_6;
    private String caminho_imagem_7;
    private String caminho_imagem_8;
    private String caminho_imagem_9;
    private String caminho_imagem_10;
    private String nome_prato_1;
    private String nome_prato_2;
    private String nome_prato_3;
    private String nome_prato_4;
    private String nome_prato_5;
	private String nome_prato_6;
    private String nome_prato_7;
    private String nome_prato_8;
    private String nome_prato_9;
    private String nome_prato_10;
    private String latitude;
    private String longitude;
    
    public Restaurante() {
        
    }    

    public Restaurante(Integer id, String nome, String caminho_imagem_1) {
        this.id = id;
        this.nome = nome;
        this.caminho_imagem_1 = caminho_imagem_1;
    }
    
    public Restaurante(Integer id, String nome, String bairro, String caminho_imagem_1) {
        this.id = id;
        this.nome = nome;
        this.bairro = bairro;
        this.caminho_imagem_1 = caminho_imagem_1;
    }    

    @Id
    @Column(name = "id")    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    @Column(name = "nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Column(name = "telefone")
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Column(name = "bairro")
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    @Column(name = "endereco")
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Column(name = "descricao")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Column(name = "horario_funcionamento")
    public String getHorario_funcionamento() {
        return horario_funcionamento;
    }

    public void setHorario_funcionamento(String horario_funcionamento) {
        this.horario_funcionamento = horario_funcionamento;
    }
    
    @Column(name = "quantidade_Pessoas")
    public Integer getQuantidade_Pessoas() {
        return quantidade_Pessoas;
    }

    public void setQuantidade_Pessoas(Integer quantidade_Pessoas) {
        this.quantidade_Pessoas = quantidade_Pessoas;
    }
    
    @Column(name = "preco")
    public String getPreco() {
        return preco;
    }
    
    public void setPreco(String preco) {
        this.preco = preco;
    }

    @Column(name = "cartoes")
    public String getCartoes() {
        return cartoes;
    }

    public void setCartoes(String cartoes) {
        this.cartoes = cartoes;
    }
    
    @Column(name = "facebook")
    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }
    
    @Column(name = "twitter")
    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }
    
    @Column(name = "instagram")
    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "site")
    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }
    
    @Column(name = "caminho_imagem_1")
    public String getCaminho_imagem_1() {
		return caminho_imagem_1;
	}

	public void setCaminho_imagem_1(String caminho_imagem_1) {
		this.caminho_imagem_1 = caminho_imagem_1;
	}

	@Column(name = "caminho_imagem_2")
	public String getCaminho_imagem_2() {
		return caminho_imagem_2;
	}

	public void setCaminho_imagem_2(String caminho_imagem_2) {
		this.caminho_imagem_2 = caminho_imagem_2;
	}

	@Column(name = "caminho_imagem_3")
	public String getCaminho_imagem_3() {
		return caminho_imagem_3;
	}

	public void setCaminho_imagem_3(String caminho_imagem_3) {
		this.caminho_imagem_3 = caminho_imagem_3;
	}

	@Column(name = "caminho_imagem_4")
	public String getCaminho_imagem_4() {
		return caminho_imagem_4;
	}

	public void setCaminho_imagem_4(String caminho_imagem_4) {
		this.caminho_imagem_4 = caminho_imagem_4;
	}

	@Column(name = "caminho_imagem_5")
	public String getCaminho_imagem_5() {
		return caminho_imagem_5;
	}

	public void setCaminho_imagem_5(String caminho_imagem_5) {
		this.caminho_imagem_5 = caminho_imagem_5;
	}

	@Column(name = "caminho_imagem_6")
	public String getCaminho_imagem_6() {
		return caminho_imagem_6;
	}

	public void setCaminho_imagem_6(String caminho_imagem_6) {
		this.caminho_imagem_6 = caminho_imagem_6;
	}

	@Column(name = "caminho_imagem_7")
	public String getCaminho_imagem_7() {
		return caminho_imagem_7;
	}

	public void setCaminho_imagem_7(String caminho_imagem_7) {
		this.caminho_imagem_7 = caminho_imagem_7;
	}

	@Column(name = "caminho_imagem_8")
	public String getCaminho_imagem_8() {
		return caminho_imagem_8;
	}

	public void setCaminho_imagem_8(String caminho_imagem_8) {
		this.caminho_imagem_8 = caminho_imagem_8;
	}

	@Column(name = "caminho_imagem_9")
	public String getCaminho_imagem_9() {
		return caminho_imagem_9;
	}

	public void setCaminho_imagem_9(String caminho_imagem_9) {
		this.caminho_imagem_9 = caminho_imagem_9;
	}
	
	@Column(name = "caminho_imagem_10")
	public String getCaminho_imagem_10() {
		return caminho_imagem_10;
	}
	
	public void setCaminho_imagem_10(String caminho_imagem_10) {
		this.caminho_imagem_10 = caminho_imagem_10;
	}

	@Column(name = "nome_prato_1")
	public String getNome_prato_1() {
		return nome_prato_1;
	}

	public void setNome_prato_1(String nome_prato_1) {
		this.nome_prato_1 = nome_prato_1;
	}

	@Column(name = "nome_prato_2")
	public String getNome_prato_2() {
		return nome_prato_2;
	}

	public void setNome_prato_2(String nome_prato_2) {
		this.nome_prato_2 = nome_prato_2;
	}

	@Column(name = "nome_prato_3")
	public String getNome_prato_3() {
		return nome_prato_3;
	}

	public void setNome_prato_3(String nome_prato_3) {
		this.nome_prato_3 = nome_prato_3;
	}

	@Column(name = "nome_prato_4")
	public String getNome_prato_4() {
		return nome_prato_4;
	}

	public void setNome_prato_4(String nome_prato_4) {
		this.nome_prato_4 = nome_prato_4;
	}

	@Column(name = "nome_prato_5")
	public String getNome_prato_5() {
		return nome_prato_5;
	}

	public void setNome_prato_5(String nome_prato_5) {
		this.nome_prato_5 = nome_prato_5;
	}

	@Column(name = "nome_prato_6")
	public String getNome_prato_6() {
		return nome_prato_6;
	}

	public void setNome_prato_6(String nome_prato_6) {
		this.nome_prato_6 = nome_prato_6;
	}

	@Column(name = "nome_prato_7")
	public String getNome_prato_7() {
		return nome_prato_7;
	}

	public void setNome_prato_7(String nome_prato_7) {
		this.nome_prato_7 = nome_prato_7;
	}

	@Column(name = "nome_prato_8")
	public String getNome_prato_8() {
		return nome_prato_8;
	}

	public void setNome_prato_8(String nome_prato_8) {
		this.nome_prato_8 = nome_prato_8;
	}

	@Column(name = "nome_prato_9")
	public String getNome_prato_9() {
		return nome_prato_9;
	}

	public void setNome_prato_9(String nome_prato_9) {
		this.nome_prato_9 = nome_prato_9;
	}

	@Column(name = "nome_prato_10")
	public String getNome_prato_10() {
		return nome_prato_10;
	}

	public void setNome_prato_10(String nome_prato_10) {
		this.nome_prato_10 = nome_prato_10;
	}

	@Column(name = "latitude")
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column(name = "longitude")
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}