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

    public Restaurante(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Restaurante() {
        
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
   

}