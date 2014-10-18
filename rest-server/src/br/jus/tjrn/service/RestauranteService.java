package br.jus.tjrn.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import br.jus.tjrn.controller.RestauranteBean;
import br.jus.tjrn.dao.RestauranteDao;
import br.jus.tjrn.model.BairroDto;
import br.jus.tjrn.model.InformacoesRestauranteDto;
import br.jus.tjrn.model.PratoDto;
import br.jus.tjrn.model.Restaurante;
import br.jus.tjrn.model.RestauranteDto;

@Path("/rest-service")
public class RestauranteService {
	
	@BadgerFish
	@GET
	@Path("/buscar-restaurantes")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RestauranteDto>  getRestaurantes() {		
		RestauranteBean restauranteBean = new RestauranteBean();
		
		List<Restaurante> restaurantes = restauranteBean.getRestaurantes();
		List<RestauranteDto> dtos = new ArrayList<RestauranteDto>();
		
		for( Restaurante restaurante : restaurantes ) {
			RestauranteDto dto = new RestauranteDto(
					restaurante.getId(), 
					restaurante.getNome(), 
					restaurante.getCaminho_imagem_1()
				);
			
			dtos.add(dto);
		}
		
		return dtos;
	}
	
	@BadgerFish
	@GET
	@Path("/buscar-restaurantes-por-id")
	@Produces(MediaType.APPLICATION_JSON)
	public InformacoesRestauranteDto getRestaurantesPorId(@DefaultValue("0") @QueryParam("idRestaurante") Integer idRestaurante) {
		RestauranteBean restaurantes = new RestauranteBean();
		Restaurante restaurante = restaurantes.getRestaurantesPorId(idRestaurante);
		
		RestauranteDto restDto = new RestauranteDto(restaurante.getId(), restaurante.getNome(), restaurante.getCaminho_imagem_1());
		
		List<PratoDto> pratos = getPratos(restaurante);
		
		InformacoesRestauranteDto dto = new InformacoesRestauranteDto(
				restDto, 
				pratos, 
				restaurante.getTelefone(), 
				restaurante.getEndereco(), 
				restaurante.getDescricao()
			);
		
		return dto;
	}
	
	private List<PratoDto> getPratos(Restaurante restaurante) {
		List<PratoDto> pratos = new ArrayList<PratoDto>();
		RestauranteDto restDto = new RestauranteDto(restaurante.getId(), restaurante.getNome(), restaurante.getCaminho_imagem_1());
		
		if( restaurante.getNome_prato_1() != null && !restaurante.getNome_prato_1().isEmpty() ) {
			pratos.add( new PratoDto(restDto, restaurante.getNome_prato_1(), restaurante.getCaminho_imagem_1()) );
		}
		if( restaurante.getNome_prato_2() != null && !restaurante.getNome_prato_2().isEmpty() ) {
			pratos.add( new PratoDto(restDto, restaurante.getNome_prato_1(), restaurante.getCaminho_imagem_2()) );
		}
		if( restaurante.getNome_prato_3() != null && !restaurante.getNome_prato_3().isEmpty() ) {
			pratos.add( new PratoDto(restDto, restaurante.getNome_prato_1(), restaurante.getCaminho_imagem_3()) );
		}
		if( restaurante.getNome_prato_4() != null && !restaurante.getNome_prato_4().isEmpty() ) {
			pratos.add( new PratoDto(restDto, restaurante.getNome_prato_1(), restaurante.getCaminho_imagem_4()) );
		}
		if( restaurante.getNome_prato_5() != null && !restaurante.getNome_prato_5().isEmpty() ) {
			pratos.add( new PratoDto(restDto, restaurante.getNome_prato_1(), restaurante.getCaminho_imagem_5()) );
		}
		if( restaurante.getNome_prato_6() != null && !restaurante.getNome_prato_6().isEmpty() ) {
			pratos.add( new PratoDto(restDto, restaurante.getNome_prato_1(), restaurante.getCaminho_imagem_6()) );
		}
		if( restaurante.getNome_prato_7() != null && !restaurante.getNome_prato_7().isEmpty() ) {
			pratos.add( new PratoDto(restDto, restaurante.getNome_prato_1(), restaurante.getCaminho_imagem_7()) );
		}
		if( restaurante.getNome_prato_8() != null && !restaurante.getNome_prato_8().isEmpty() ) {
			pratos.add( new PratoDto(restDto, restaurante.getNome_prato_1(), restaurante.getCaminho_imagem_8()) );
		}
		if( restaurante.getNome_prato_9() != null && !restaurante.getNome_prato_9().isEmpty() ) {
			pratos.add( new PratoDto(restDto, restaurante.getNome_prato_1(), restaurante.getCaminho_imagem_9()) );
		}
		if( restaurante.getNome_prato_10() != null && !restaurante.getNome_prato_10().isEmpty() ) {
			pratos.add( new PratoDto(restDto, restaurante.getNome_prato_1(), restaurante.getCaminho_imagem_10()) );
		}
		
		return pratos;
	}
	
	@BadgerFish
	@GET
	@Path("/buscar-restaurantes-por-nome")
	@Produces(MediaType.APPLICATION_JSON)
	public List<RestauranteDto> getRestaurantesPorNome(@DefaultValue("0") @QueryParam("nomeRestaurante") String nomeRestaurante) {
		RestauranteBean restauranteBean = new RestauranteBean();
		List<Restaurante> restaurantes = restauranteBean.getRestaurantesPorNome(nomeRestaurante);
		
		List<RestauranteDto> dtos = new ArrayList<RestauranteDto>();
		
		for(Restaurante restaurante : restaurantes) {
			dtos.add( new RestauranteDto(restaurante.getId(), restaurante.getNome(), restaurante.getCaminho_imagem_1()) );
		}
		
		return dtos;
	}	
	
	@BadgerFish
	@GET
	@Path("/buscar-restaurantes-por-bairro")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BairroDto> getRestaurantesPorBairro() {		
		RestauranteBean restaurantesBean = new RestauranteBean();
		
		List<Restaurante> restaurantes = restaurantesBean.getRestaurantesPorBairro();
		List<BairroDto> bairros = new ArrayList<BairroDto>();
		
		BairroDto dto = null;
		for(Restaurante restaurante : restaurantes) {
			RestauranteDto rDto = new RestauranteDto(restaurante.getId(), restaurante.getNome(), restaurante.getCaminho_imagem_1());
			
			if(dto == null || !dto.getNome().equals(restaurante.getBairro())) {
				dto = new BairroDto(restaurante.getBairro(), restaurante.getCaminho_imagem_1());
				bairros.add(dto);
			}
			
			dto.getRestaurantes().add(rDto);
		}
		
		return bairros;
	}

}