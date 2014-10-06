package br.jus.tjrn.controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.jus.tjrn.abstracts.AbstractRestauranteBean;
import br.jus.tjrn.dao.CertidaoDao;
import br.jus.tjrn.dao.DataSource;
import br.jus.tjrn.dao.RestauranteDao;
import br.jus.tjrn.dto.EscolhaCertidaoDto;
import br.jus.tjrn.model.Restaurante;

@ManagedBean
@ViewScoped
public class RestauranteBean extends AbstractRestauranteBean<EscolhaCertidaoDto> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public RestauranteBean() {
        
    }
    
    @Override
    public List<Object[]> getRestaurantes() {
        List<Object[]> restaurantes = new ArrayList<Object[]>();        
        try {
            restaurantes = listarRestaurantes();
        } catch (SQLException e) {
            e.printStackTrace();
        }            
        return restaurantes;
    }
    
    public List<Object[]> listarRestaurantes() throws SQLException {
        RestauranteDao restaurante = new RestauranteDao();
        List<Object[]> restaurantes = new ArrayList<Object[]>();
        try {
            restaurantes = restaurante.getRestaurantes(); 
        } finally {
            restaurante.close();   
        }
        return restaurantes;
    }
    
    @Override
    public Restaurante findByIdRestaurante(Integer id) {
    	Restaurante restaurante = new Restaurante();        
        try {
        	restaurante = findRestaurante(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }            
        return restaurante;
    }
    
	public Restaurante findRestaurante(Integer id) throws SQLException {
		Restaurante restaurante = new Restaurante();
		RestauranteDao restaurantedao = new RestauranteDao();
		try {
			restaurante = restaurantedao.findByIdRestaurante(id);
		} finally {
			restaurantedao.close();
		}
		return restaurante;
	}    

}