package br.jus.tjrn.service;

import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	@Path("/buscar-restaurantes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Restaurante> getRestaurantes() {		
		RestauranteBean restaurantes = new RestauranteBean();
		return restaurantes.getRestaurantes();
	}
	
	@BadgerFish
	@GET
	@Path("/buscar-restaurantes-por-id")
	@Produces(MediaType.APPLICATION_JSON)
	public Restaurante getRestaurantesPorId(@DefaultValue("0") @QueryParam("idRestaurante") Integer idRestaurante) {
		RestauranteBean restaurantes = new RestauranteBean();
		return restaurantes.getRestaurantesPorId(idRestaurante);
	}
	
	@BadgerFish
	@GET
	@Path("/buscar-restaurantes-por-nome")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Restaurante> getRestaurantesPorNome(@DefaultValue("0") @QueryParam("nomeRestaurante") String nomeRestaurante) {
		RestauranteBean restaurantes = new RestauranteBean();
		return restaurantes.getRestaurantesPorNome(nomeRestaurante);
	}	
	
	@BadgerFish
	@GET
	@Path("/buscar-restaurantes-por-bairro")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Restaurante> getRestaurantesPorBairro() {		
		RestauranteBean restaurantes = new RestauranteBean();
		return restaurantes.getRestaurantesPorBairro();
	}

}