package br.jus.tjrn.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.jus.tjrn.abstracts.AbstractEmissaoPdfBean;
import br.jus.tjrn.dao.CertidaoDao;
import br.jus.tjrn.dao.DataSource;
import br.jus.tjrn.dto.EscolhaCertidaoDto;
import br.jus.tjrn.model.Certidao;
import br.jus.tjrn.util.CertidaoUtil;

/**
 * Bean responsavel por gerenciar a selecao da certidao.
 * 
 * @author luan
 *
 */
@ManagedBean
@ViewScoped
public class CertidaoBean extends AbstractEmissaoPdfBean<EscolhaCertidaoDto> implements Serializable {
    
    /** */
	private static final long serialVersionUID = 1L;
	
	private Certidao certidao;
	private Integer count = null;
	
	public CertidaoBean() {
		limpar();
	}
	
	/**
	 * Limpa os dados preenchidos no formulario
	 */
	public void limpar() {
		setObj( new EscolhaCertidaoDto() );
		certidao = new Certidao();
	}

	@Override
	public String getNameTemplate() {
		// o template esta na certidao
		String nomeTemplate = getObj().getTipoCertidao().getTemplateVelocity();
		
		if (count == 1)
			nomeTemplate = CertidaoUtil.CERTIDAO_POSITIVA_HTML;
		
		return nomeTemplate;
	}

	@Override
	public String getNameDownload() {
		return "certidao.pdf";
	}
	
	@Override
	public List<Object[]> getProcessos() {
		List<Object[]> processos = new ArrayList<Object[]>();
		
		try {
			if (count == 1) processos = listarProcessos();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return processos;
	}

	@Override
	public boolean validate() {
		try {
			count = countCertidao();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
		if (count > 1) {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,null,"A pessoa informada possui ocorrências e não pode ser pesquisado pela Internet. Verifique se o nome está completo ou solicite a certidão no fórum da sua cidade."));
		}

		return count <= 1;
	}
	
	/**
	 * Confere se o id informado na tela é de uma certidão.
	 */
	public void conferirCertidao() {
		CertidaoDao dao = new CertidaoDao(DataSource.PJE_CERTIDAO);
		try {
			certidao = dao.findById( new Long(certidao.getId().toString()) );
		} finally {
			dao.close();
		}
		
		if( certidao.getId() == null ) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, null, "O código de validação não confere."));
			return;
		}
	}

	public Integer countCertidao() throws SQLException {
		CertidaoDao certidaoDao = new CertidaoDao();
		Integer count = 0;
		try {
			count = certidaoDao.countCertidao(getObj().getTipoCertidao(), getObj().getCpfCnpj().length() == 14 ? "CPF" : "CPJ", getObj().getNome(), getObj().getCpfCnpj()).intValue();
		} finally {
			certidaoDao.close();
		}
		return count;
	}
	
	/**
	 * Lista os Processos-Orgão Julgador para a certidão positiva.
	 */	
	public List<Object[]> listarProcessos() throws SQLException {
		CertidaoDao certidao = new CertidaoDao();
		List<Object[]> processos = new ArrayList<Object[]>();
		try {
			processos = certidao.getProcessos(getObj().getTipoCertidao(), getObj().getCpfCnpj().length() == 14 ? "CPF" : "CPJ", getObj().getNome(), getObj().getCpfCnpj());	
		} finally {
			certidao.close();	
		}
		return processos;
	}

	public Certidao getCertidao() {
		return certidao;
	}

	public void setCertidao(Certidao certidao) {
		this.certidao = certidao;
	}

}