package br.jus.tjrn.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.ScrollableResults;

import br.jus.tjrn.model.Restaurante;

public class RestauranteDao extends GenericDao<Restaurante> {
    
    public RestauranteDao() { }
    
    public RestauranteDao(DataSource dataSource) {
        super.dataSource = dataSource;
    }
    
    @Override
    public Class<Restaurante> getTypeClasse() {
        return Restaurante.class;
    }
    
    public List<Restaurante> getRestaurantes() throws SQLException {
		List<Restaurante> restaurantes = new ArrayList<Restaurante>();		    	
        String sql = " select id, nome, caminho_imagem_1 from tb_restaurante order by nome ";
        SQLQuery query = getSession().createSQLQuery(sql);
        ScrollableResults resultSet=query.scroll();
        
        if (resultSet.first()) {
        	do {
                restaurantes.add(new Restaurante((Integer) resultSet.get(0), (String) resultSet.get(1), (String) resultSet.get(2)));
            }
            while ( resultSet.next() );        	
        }
        
        resultSet.close();
        return restaurantes;
    }
    
    public List<Restaurante> getRestaurantesPorBairro() throws SQLException {
		List<Restaurante> restaurantes = new ArrayList<Restaurante>();		    	
        String sql = " select id, nome, bairro, caminho_imagem_1 from tb_restaurante order by bairro, nome ";
        SQLQuery query = getSession().createSQLQuery(sql);
        ScrollableResults resultSet=query.scroll();
        
        if (resultSet.first()) {
        	do {
                restaurantes.add(new Restaurante((Integer) resultSet.get(0), (String) resultSet.get(1), (String) resultSet.get(2), (String) resultSet.get(3)));
            }
            while ( resultSet.next() );        	
        }
        
        resultSet.close();
        return restaurantes;
    }
    
    public List<Restaurante> getRestaurantesPorNome(String nome) throws SQLException {
		List<Restaurante> restaurantes = new ArrayList<Restaurante>();		    	
        String sql = " select id, nome, caminho_imagem_1 from tb_restaurante where nome like '%"+nome+"%' order by nome ";
        SQLQuery query = getSession().createSQLQuery(sql);
        //query.setString(0,"'%"+nome+"%'");
        //query.setParameter("valor", "%'"+nome+"'%");
        ScrollableResults resultSet=query.scroll();
        
        if (resultSet.first()) {
        	do {
                restaurantes.add(new Restaurante((Integer) resultSet.get(0), (String) resultSet.get(1), (String) resultSet.get(2)));
            }
            while ( resultSet.next() );        	
        }
        
        resultSet.close();
        return restaurantes;
    }    
    
    public Restaurante getRestaurantesPorId(Integer id) throws SQLException {
    	Restaurante restaurante = new Restaurante();
        String sql =    " select id, nome, telefone, bairro, endereco, descricao, horario_funcionamento, " +
                        " quantidade_Pessoas, preco, cartoes, facebook, twitter, email, site, " +
                        " caminho_imagem_1, caminho_imagem_2, caminho_imagem_3, caminho_imagem_4, caminho_imagem_5, caminho_imagem_6, caminho_imagem_7, caminho_imagem_8, caminho_imagem_9, caminho_imagem_10, " + 
                        " nome_prato_1, nome_prato_2, nome_prato_3, nome_prato_4, nome_prato_5, nome_prato_6, nome_prato_7, nome_prato_8, nome_prato_9, nome_prato_10 " +
                        " from tb_restaurante " +
                        " where id = ? " +
                        " order by nome; ";
        SQLQuery query = getSession().createSQLQuery(sql);
        query.setInteger(0,id);
        ScrollableResults resultSet=query.scroll();
        
        if (resultSet.first()) {
            	restaurante.setId((Integer) resultSet.get(0));
            	restaurante.setNome((String) resultSet.get(1));
            	restaurante.setTelefone((String) resultSet.get(2));
            	restaurante.setBairro((String) resultSet.get(3));
            	restaurante.setEndereco((String) resultSet.get(4));
            	restaurante.setDescricao((String) resultSet.get(5));
            	restaurante.setHorario_funcionamento((String) resultSet.get(6));
            	restaurante.setQuantidade_Pessoas((Integer) resultSet.get(7));
            	restaurante.setPreco((String) resultSet.get(8));
            	restaurante.setCartoes((String) resultSet.get(9));
            	restaurante.setFacebook((String) resultSet.get(10));
            	restaurante.setTwitter((String) resultSet.get(11));
            	restaurante.setEmail((String) resultSet.get(12));
            	restaurante.setSite((String) resultSet.get(13));
            	
            	restaurante.setCaminho_imagem_1((String) resultSet.get(14));
            	restaurante.setCaminho_imagem_2((String) resultSet.get(15));
            	restaurante.setCaminho_imagem_3((String) resultSet.get(16));
            	restaurante.setCaminho_imagem_4((String) resultSet.get(17));
            	restaurante.setCaminho_imagem_5((String) resultSet.get(18));
            	restaurante.setCaminho_imagem_6((String) resultSet.get(19));
            	restaurante.setCaminho_imagem_7((String) resultSet.get(20));
            	restaurante.setCaminho_imagem_8((String) resultSet.get(21));
            	restaurante.setCaminho_imagem_9((String) resultSet.get(22));
            	restaurante.setCaminho_imagem_10((String) resultSet.get(23));
            	
            	restaurante.setNome_prato_1((String) resultSet.get(24));
            	restaurante.setNome_prato_2((String) resultSet.get(25));
            	restaurante.setNome_prato_3((String) resultSet.get(26));
            	restaurante.setNome_prato_4((String) resultSet.get(27));
            	restaurante.setNome_prato_5((String) resultSet.get(28));
            	restaurante.setNome_prato_6((String) resultSet.get(29));
            	restaurante.setNome_prato_7((String) resultSet.get(30));
            	restaurante.setNome_prato_8((String) resultSet.get(31));
            	restaurante.setNome_prato_9((String) resultSet.get(32));
            	restaurante.setNome_prato_10((String) resultSet.get(33));
            	
        }        
        resultSet.close();
        return restaurante;
    }    
}