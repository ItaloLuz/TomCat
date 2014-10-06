package br.jus.tjrn.abstracts;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.jus.tjrn.dao.CertidaoDao;
import br.jus.tjrn.dao.DataSource;
import br.jus.tjrn.model.Certidao;
import br.jus.tjrn.report.Html2Pdf;
import br.jus.tjrn.report.CertidaoPdf;
import br.jus.tjrn.util.FacesUtil;

/**
 * Classe Abstrata que guarda informacoes em comum para emissao de pdf's
 * 
 * @author luan
 *
 * @param <T>
 */
public abstract class AbstractEmissaoPdfBean<T> extends AbstractBean<T> {
	
	/**
	 * Monta e manda o download pra quem solicitou
	 * 
	 * @return
	 * @throws Exception 
	 */
	public StreamedContent getFile() throws Exception {
		if( !validate() ) 
			return null;
		
		CertidaoDao dao = new CertidaoDao(DataSource.PJE_CERTIDAO);
		try {
			BigInteger nextValSeq = dao.getNextValue(Certidao.SQ_NAME);
			
			CertidaoPdf pdf = new CertidaoPdf(nextValSeq, getObj(), getProcessos());
			pdf.gerarPdf( getNameTemplate() );
			
	        InputStream stream = FacesUtil.getServletContext().getResourceAsStream("/" + Html2Pdf.PATH_PDF);
			
			persistCertidao(dao, nextValSeq);
			
			return new DefaultStreamedContent(stream, "application/pdf", getNameDownload());
		} finally {
			dao.close();
		}
	}
	
	private void persistCertidao(CertidaoDao dao, BigInteger nextValSeq) throws Exception {
	    InputStream stream = FacesUtil.getServletContext().getResourceAsStream("/" + Html2Pdf.PATH_PDF);
	    
	    byte[] bs;
        try {
            bs = IOUtils.toByteArray(stream);
        } catch (IOException e) {
            throw new Exception();
        }
	    
	    Certidao certidao = new Certidao(nextValSeq.longValue(), bs);
	    certidao.setDataCriacao( new Date() );
	    
	    dao.persist(certidao);
	}
	
	/**
	 * Faz alguma validação antes de emitir o pdf
	 * 
	 * @return
	 */
	public abstract boolean validate();
	
	/**
	 * Nome do arquivo template do velocity
	 * 
	 * @return
	 */
	public abstract String getNameTemplate();
	
	/**
	 * Escolhe qual o nome que o arquivo baixado terá  
	 * 
	 * @return
	 */
	public abstract String getNameDownload();
	
	/**
	 * Retornar uma lista com os processos
	 * 
	 * @return
	 */
	public abstract List<Object[]> getProcessos();	
	
}