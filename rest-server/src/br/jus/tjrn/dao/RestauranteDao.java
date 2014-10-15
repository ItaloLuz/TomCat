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
        String sql = " select id, nome from tb_restaurante order by nome ";
        SQLQuery query = getSession().createSQLQuery(sql);
        ScrollableResults resultSet=query.scroll();
        
        if (resultSet.first()) {
        	do {
                restaurantes.add(new Restaurante((Integer) resultSet.get(0), (String) resultSet.get(1)));
            }
            while ( resultSet.next() );        	
        }
        
        resultSet.close();
        return restaurantes;
    }
    
    public List<Restaurante> getRestaurantesPorBairro() throws SQLException {
		List<Restaurante> restaurantes = new ArrayList<Restaurante>();		    	
        String sql = " select id, nome, bairro from tb_restaurante order by bairro, nome ";
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
    
    public List<Restaurante> getRestaurantesPorNome(String nome) throws SQLException {
		List<Restaurante> restaurantes = new ArrayList<Restaurante>();		    	
        String sql = " select id, nome from tb_restaurante where nome like '%"+nome+"%' order by nome ";
        SQLQuery query = getSession().createSQLQuery(sql);
        //query.setString(0,"'%"+nome+"%'");
        //query.setParameter("valor", "%'"+nome+"'%");
        ScrollableResults resultSet=query.scroll();
        
        if (resultSet.first()) {
        	do {
                restaurantes.add(new Restaurante((Integer) resultSet.get(0), (String) resultSet.get(1)));
            }
            while ( resultSet.next() );        	
        }
        
        resultSet.close();
        return restaurantes;
    }    
    
    public Restaurante getRestaurantesPorId(Integer id) throws SQLException {
    	Restaurante restaurante = new Restaurante();
        String sql =    " select id, nome, telefone, bairro, endereco, descricao, horario_funcionamento, " +
                        " quantidade_Pessoas, preco, cartoes, facebook, twitter, email, site " +
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
        }        
        resultSet.close();
        return restaurante;
    }    
}