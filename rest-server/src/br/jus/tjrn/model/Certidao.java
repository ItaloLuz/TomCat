package br.jus.tjrn.model;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
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
public class Certidao implements Serializable {
    
    /**  */
	private static final long serialVersionUID = 1L;
	
	public static final String TB_NAME = "tb_certidao";
    public static final String SQ_NAME = "sq_certidao";

    private Long id;
    private byte[] arquivo;
    private Date dataCriacao;

    public Certidao(Long id, byte[] bs) {
        this.id = id;
        this.arquivo = bs;
    }

    public Certidao() {
        // TODO Auto-generated constructor stub
    }

    @Id
    @Column(name = "id_certidao")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Transient
    public Long getArquivoById() {
        return id;
    }
    
    public void setArquivoById(Long id) {
    	this.id = id;
		if( id == null ) {
			arquivo = null;
			return;
		}
		
		CertidaoDao dao = new CertidaoDao(DataSource.PJE_CERTIDAO);
		try {
			Certidao certidao = dao.findById( id );
			
			if( certidao == null ) {
				arquivo = null;
				return;
			}
			
			arquivo = certidao.getArquivo();
			dataCriacao = certidao.getDataCriacao();
		} finally {
			dao.close();
		}
    }

    @Column(name = "arquivo")
    public byte[] getArquivo() {
        return arquivo;
    }

    public void setArquivo(byte[] arquivo) {
        this.arquivo = arquivo;
    }
    
    @Column(name="data_criacao")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Transient
    public String getIdFormatado() {
        return String.format("%010d", id);
    }
    
    @Transient
    public StreamedContent getPdf() {
    	if( !validar() ) 
    		return null;
    	
        ByteArrayInputStream bis = new ByteArrayInputStream(this.arquivo);
        
        return new DefaultStreamedContent(bis, "application/pdf", "certidao.pdf");
    }
    
    @Transient
    public StreamedContent getPdfLimpandoArquivo() {
    	StreamedContent stream = getPdf();
    	// limpa o arquivo para nao armazenar memoria
        this.arquivo = null;
        
        return stream;
    }
    
    private boolean validar() {
		if( id == null ) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Informe o 'Número da Certidão'.", ""));
			return false;
		}
		if( arquivo == null ) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "O código de validação não confere.", ""));
			return false;
		}
		// verifica se esta dentro do periodo de valido da certidao
		if( CalendarUtil.diferencaEmDias(dataCriacao, new Date()) > 30 ) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "A certidão não é mais válida.", "A certidão já foi expirada"));
			return false;
		}
		return true;
    }

}
