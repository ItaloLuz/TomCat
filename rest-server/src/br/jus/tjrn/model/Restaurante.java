package br.jus.tjrn.model;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.jus.tjrn.dao.CertidaoDao;
import br.jus.tjrn.dao.DataSource;
import br.jus.tjrn.util.CalendarUtil;

@Entity
@Table(name = Certidao.TB_NAME)
public class Restaurante implements Serializable  {
    
    private static final long serialVersionUID = 1L;
    
    public static final String TB_NAME = "tb_restaurante";

    private Integer id;
    private String nome;

    public Restaurante(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Restaurante() {
        // TODO Auto-generated constructor stub
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
   

}
