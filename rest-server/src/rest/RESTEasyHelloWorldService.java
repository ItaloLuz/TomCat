package rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import model.dto.InformacoesRestauranteDto;
import model.dto.PratoDto;
import model.dto.RestauranteDto;

import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;

@Path("/rest-service")
public class RESTEasyHelloWorldService {

	@BadgerFish
	@GET
	@Path("/buscar-restaurantes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RestauranteDto> buscarRestaurantes() {
		List<RestauranteDto> restaurantes = new ArrayList<RestauranteDto>();
		
		restaurantes.add(new RestauranteDto(1, "Camaroes", "/images/chopp-brahma-express.png"));

		return restaurantes;
	}

	@BadgerFish
	@GET
	@Path("/buscar-infos/{idRestaurante}")
	@Produces(MediaType.APPLICATION_JSON)
	public InformacoesRestauranteDto findInfoByRetaurante( @DefaultValue("0")  @PathParam("idRestaurante") String idRestaurante) {
		
		System.out.println(idRestaurante);

		List<RestauranteDto> restaurantes = new ArrayList<RestauranteDto>();
		
		List<InformacoesRestauranteDto> infos = new ArrayList<InformacoesRestauranteDto>();
		
		RestauranteDto restaurante = new RestauranteDto(1, "Camaroes", "/images/chopp-brahma-express.png");
		
		List<PratoDto> pratos = new ArrayList<PratoDto>();
		pratos.add(new PratoDto(restaurante, "Hamburguer", "/images/chopp-brahma-express.png"));
		pratos.add(new PratoDto(restaurante, "Pastel", "/images/chopp-brahma-express.png"));
		
		return new InformacoesRestauranteDto(restaurante, pratos, "(84) 8888-9999", "Rua de teste", "Testando descricaoajas diufabsiuf asbduyfb asuidbf uasibdf ");
		
//		infos.add(info);
//
//		return infos;
	}

}
