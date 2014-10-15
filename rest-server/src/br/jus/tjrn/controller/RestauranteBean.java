package br.jus.tjrn.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.jus.tjrn.abstracts.AbstractRestauranteBean;
import br.jus.tjrn.dao.RestauranteDao;
import br.jus.tjrn.model.Restaurante;

@ManagedBean
@ViewScoped
public class RestauranteBean extends AbstractRestauranteBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public RestauranteBean() {
        
    }
    
    @Override
    public List<Restaurante> getRestaurantes() {
        List<Restaurante> restaurantes = new ArrayList<Restaurante>();        
        try {
            restaurantes = listarRestaurantes();
        } catch (SQLException e) {
            e.printStackTrace();
        }            
        return restaurantes;
    }
    
    public List<Restaurante> listarRestaurantes() throws SQLException {
        RestauranteDao restaurante = new RestauranteDao();
        List<Restaurante> restaurantes = new ArrayList<Restaurante>();
        try {
            restaurantes = restaurante.getRestaurantes(); 
        } finally {
            restaurante.close();   
        }
        return restaurantes;
    }
    
    @Override
    public Restaurante getRestaurantesPorId(Integer id) {
    	Restaurante restaurante = new Restaurante();        
        try {
        	restaurante = listarRestaurantesPorId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }            
        return restaurante;
    }
    
	public Restaurante listarRestaurantesPorId(Integer id) throws SQLException {
		Restaurante restaurante = new Restaurante();
		RestauranteDao restaurantedao = new RestauranteDao();
		try {
			restaurante = restaurantedao.getRestaurantesPorId(id);
		} finally {
			restaurantedao.close();
		}
		return restaurante;
	}

	@Override
    public List<Restaurante> getRestaurantesPorBairro() {
        List<Restaurante> restaurantes = new ArrayList<Restaurante>();        
        try {
            restaurantes = listarRestaurantesPorBairro();
        } catch (SQLException e) {
            e.printStackTrace();
        }            
        return restaurantes;
    }
    
    public List<Restaurante> listarRestaurantesPorBairro() throws SQLException {
        RestauranteDao restaurante = new RestauranteDao();
        List<Restaurante> restaurantes = new ArrayList<Restaurante>();
        try {
            restaurantes = restaurante.getRestaurantesPorBairro(); 
        } finally {
            restaurante.close();
        }
        return restaurantes;
    }
    
	@Override
    public List<Restaurante> getRestaurantesPorNome(String nome) {
        List<Restaurante> restaurantes = new ArrayList<Restaurante>();        
        try {
            restaurantes = listarRestaurantesPorNome(nome);
        } catch (SQLException e) {
            e.printStackTrace();
        }            
        return restaurantes;
    }
    
    public List<Restaurante> listarRestaurantesPorNome(String nome) throws SQLException {
        RestauranteDao restaurante = new RestauranteDao();
        List<Restaurante> restaurantes = new ArrayList<Restaurante>();
        try {
            restaurantes = restaurante.getRestaurantesPorNome(nome); 
        } finally {
            restaurante.close();
        }
        return restaurantes;
    }        

}