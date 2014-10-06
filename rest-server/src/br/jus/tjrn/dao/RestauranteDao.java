package br.jus.tjrn.dao;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.management.Query;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.ScrollableResults;

import com.mysql.jdbc.PreparedStatement;

import br.jus.tjrn.util.StringUtil;
import br.jus.tjrn.controller.RestauranteBean;	
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
    
    public List<Object[]> getRestaurantes() throws SQLException {
        String sql = " select id, nome from tb_restaurante ";
        SQLQuery query = getSession().createSQLQuery(sql);
        return query.list();
    }
    
    public Restaurante findByIdRestaurante(Integer id) throws SQLException {
    	Restaurante restaurante = new Restaurante();
        String sql = " select id, nome from tb_restaurante where id = ? "; 
        SQLQuery query = getSession().createSQLQuery(sql);
        query.setInteger(0,id);
        ScrollableResults resultSet=query.scroll();
        
        if (resultSet.first()) {
            	restaurante.setId((Integer) resultSet.get(0));
            	restaurante.setNome((String) resultSet.get(1));      
        }
    	
        return restaurante;
    }    
}