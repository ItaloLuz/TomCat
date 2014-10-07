package br.jus.tjrn.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;

import br.jus.tjrn.controller.RestauranteBean;
import br.jus.tjrn.model.Restaurante;

@Path("/rest-service")
public class RestauranteService {
	
	@BadgerFish
	@GET
	@Path("/listar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Object[]> getRestaurantes() {		
		RestauranteBean restaurantes = new RestauranteBean();
		return restaurantes.getRestaurantes();
	}
	
	@BadgerFish
	@GET
	@Path("/pesquisar")
	@Produces(MediaType.APPLICATION_JSON)
	public Restaurante findByIdRestaurante( @QueryParam("parametro") Integer parametro) {
		RestauranteBean restaurantes = new RestauranteBean();
		return restaurantes.findByIdRestaurante(parametro);
	}		

}