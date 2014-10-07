package br.jus.tjrn.dao;

import java.sql.SQLException;
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
    
    public List<Object[]> getRestaurantes() throws SQLException {
        String sql = " select id, nome from tb_restaurante ";
        SQLQuery query = getSession().createSQLQuery(sql);
        return query.list();
    }
    
    public Restaurante findByIdRestaurante(Integer id) throws SQLException {
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
    	
        return restaurante;
    }    
}