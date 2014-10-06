package br.jus.tjrn.dao;

import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;
import org.hibernate.SQLQuery;
import br.jus.tjrn.model.Certidao;
import br.jus.tjrn.model.TipoCertidao;
import br.jus.tjrn.util.StringUtil;

public class CertidaoDao extends GenericDao<Certidao>{
    
    public CertidaoDao() { }
    
    public CertidaoDao(DataSource dataSource) {
        super.dataSource = dataSource;
    }

    @Override
    public Class<Certidao> getTypeClasse() {
        return Certidao.class;
    }
    
    public BigInteger countCertidao(TipoCertidao tipoCertidao, String tipoPessoa, String nome, String cpfCnpj) throws SQLException {
    	nome = StringUtil.retirarEspacos(nome);
        String sql =    " select count(distinct coalesce(pdoc.ds_nome_pessoa, palt.ds_pessoa_nome_alternativo)) " +
                        " from tb_processo proc " +
                        // join dados processo  
                        " inner join tb_processo_trf proc_trf on proc.id_processo = proc_trf.id_processo_trf " +
                        " inner join tb_processo_parte pp on pp.id_processo_trf = proc_trf.id_processo_trf " +
                        " inner join tb_orgao_julgador oj on oj.id_orgao_julgador = proc_trf.id_orgao_julgador " +
                        " inner join tb_classe_judicial cj on cj.id_classe_judicial = proc_trf.id_classe_judicial " +
                        // join dados pessoa
                        " inner join tb_usuario_login ul on ul.id_usuario = pp.id_pessoa " +
                        " left join tb_pess_doc_identificacao pdoc on pdoc.id_pessoa = pp.id_pessoa and cd_tp_documento_identificacao = '" + tipoPessoa +"' " +
                        " left join tb_pessoa_nome_alternativo palt on palt.id_pessoa = pp.id_pessoa " +                        
                        " where 1=1 " +
                        " and proc.nr_processo is not null " +
                        " and pp.in_participacao = 'P' " +
                        " and proc_trf.id_processo_trf not in ( select id_processo_trf from vs_situacao_processo_new where nm_tarefa ilike '%Arquivo definitivo%' ) " +
                        " and proc_trf.id_classe_judicial in ("+tipoCertidao.getClassesJudiciais()+") " +
                        " and ( to_ascii(ul.ds_nome) ilike to_ascii('%"+nome+"%') or to_ascii(nr_documento_identificacao) ilike to_ascii('%"+cpfCnpj+"%') or to_ascii(nr_documento_identificacao) ilike to_ascii(replace(replace('%"+cpfCnpj+"%', '.',''), '-', '') ) ) " +
                        " and coalesce(pdoc.ds_nome_pessoa, palt.ds_pessoa_nome_alternativo) is not null ";

        SQLQuery query = getSession().createSQLQuery(sql);
        return (BigInteger) query.uniqueResult();
    }
    
    public List<Object[]> getProcessos(TipoCertidao tipoCertidao, String tipoPessoa, String nome, String cpfCnpj) throws SQLException {
    	nome = StringUtil.retirarEspacos(nome);
        String sql =    " select distinct proc.nr_processo, oj.ds_orgao_julgador, ds_classe_judicial " +
                        " from tb_processo proc " +
                        // join dados processo
                        " inner join tb_processo_trf proc_trf on proc.id_processo = proc_trf.id_processo_trf " +
                        " inner join tb_processo_parte pp on pp.id_processo_trf = proc_trf.id_processo_trf " +
                        " inner join tb_orgao_julgador oj on oj.id_orgao_julgador = proc_trf.id_orgao_julgador " +
                        " inner join tb_classe_judicial cj on cj.id_classe_judicial = proc_trf.id_classe_judicial " +
                        // join dados pessoa
                        " inner join tb_usuario_login ul on ul.id_usuario = pp.id_pessoa " +
                        " left join tb_pess_doc_identificacao pdoc on pdoc.id_pessoa = pp.id_pessoa and cd_tp_documento_identificacao = '" + tipoPessoa +"' " +
                        " left join tb_pessoa_nome_alternativo palt on palt.id_pessoa = pp.id_pessoa " +                        
                        " where 1=1 " +
                        " and proc.nr_processo is not null " +
                        " and pp.in_participacao = 'P' " +
                        " and proc_trf.id_processo_trf not in ( select id_processo_trf from vs_situacao_processo_new where nm_tarefa ilike '%Arquivo definitivo%' ) " +
                        " and proc_trf.id_classe_judicial in ("+tipoCertidao.getClassesJudiciais()+") " +
                        " and ( to_ascii(ul.ds_nome) ilike to_ascii('%"+nome+"%') or to_ascii(nr_documento_identificacao) ilike to_ascii('%"+cpfCnpj+"%') or to_ascii(nr_documento_identificacao) ilike to_ascii(replace(replace('%"+cpfCnpj+"%', '.',''), '-', '') ) ) " +
                        " and coalesce(pdoc.ds_nome_pessoa, palt.ds_pessoa_nome_alternativo) is not null ";

        SQLQuery query = getSession().createSQLQuery(sql);
        return query.list();
    }
}