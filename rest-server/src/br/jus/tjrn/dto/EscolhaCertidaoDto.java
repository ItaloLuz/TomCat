package br.jus.tjrn.dto;

import br.jus.tjrn.model.TipoCertidao;

/**
 * DTO que guarda os dados que o usuario digita na pagina de escolher certidão.
 * 
 * @author luan
 *
 */
public class EscolhaCertidaoDto {
	private TipoCertidao tipoCertidao;
	private String nome;
	private String cpfCnpj;
	/** atributo usado para pegar o TipoCertidao */
	private String nomeTipoCertidao;
	
	public EscolhaCertidaoDto(){
		tipoCertidao = null;		
		nome = "";
		cpfCnpj = "";
		nomeTipoCertidao = "";
	}
	
	/** get's and set's */
	public TipoCertidao getTipoCertidao() {
		return tipoCertidao;
	}
	public void setTipoCertidao(TipoCertidao tipoCertidao) {
		this.tipoCertidao = tipoCertidao;
	}
	public String getNomeTipoCertidao() {
		return nomeTipoCertidao;
	}
	public void setNomeTipoCertidao(String nomeTipoCertidao) {
		this.nomeTipoCertidao = nomeTipoCertidao;
		
		setTipoCertidao(TipoCertidao.valueOf(nomeTipoCertidao));
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
}
