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

import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;

@Path("/rest-service")
public class RESTEasyHelloWorldService {

	@BadgerFish
	@GET
	@Path("/rest-path")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Teste> responseMsg( @DefaultValue("pathParameter")  @PathParam("pathParameter") String pathParameter,
			@DefaultValue("Nothing to say") @QueryParam("queryParameter") String queryParameter) {

		List<String> list = new ArrayList<String>();
		list.add(pathParameter);
		list.add(queryParameter);
		
		List<Teste> listTeste = new ArrayList<Teste>();
		
		listTeste.add(new Teste(pathParameter, queryParameter));
		listTeste.add(new Teste(pathParameter+"1", queryParameter+"1"));
		listTeste.add(new Teste(pathParameter+"2", queryParameter+"2"));

		return listTeste;//Response.status(200).entity(list).build();
	}

}
