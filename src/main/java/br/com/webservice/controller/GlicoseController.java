package br.com.webservice.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.webservice.repository.GlicoseRepository;
import br.com.webservice.repository.entity.GlicoseEntity;

@Path("/service/glicose")
public class GlicoseController {

	private final  GlicoseRepository repository = new GlicoseRepository();

	
	
	@POST
	@Path( "/cadastrar.ws" )
	@Produces( "application/json" )
	@Consumes( "application/json" )
	public String cadastrar( String glicoseJason ) {
		Gson gson = new Gson();
		GlicoseEntity po = new GlicoseEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( glicoseJason ).getAsJsonObject();

		po = ( gson.fromJson( object, GlicoseEntity.class ) );
				
		try {
			
			repository.cadastrar(po);

			return "Registro cadastrado com sucesso!";

		} catch (Exception e) {

			return "Erro ao cadastrar um registro " + e.getMessage();
		}
	}
	
	@PUT
	@Path( "/editar.ws" )
	@Produces( "application/json" )
	public String editar( String glicoseJason ) {
		Gson gson = new Gson();
		GlicoseEntity po = new GlicoseEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( glicoseJason ).getAsJsonObject();

		po = ( gson.fromJson( object, GlicoseEntity.class ) );
				
		try {

			repository.alterar(po);

			return "Registro alterado com sucesso!";

		} catch (Exception e) {

			return "Erro ao alterar o registro " + e.getMessage();

		}
	}
	
	
	
	@DELETE
	@Path( "/excluir.ws" )
	@Produces( "application/json" )
	public String excluir( String glicoseJason ) {
		Gson gson = new Gson();
		GlicoseEntity po = new GlicoseEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( glicoseJason ).getAsJsonObject();

		po = ( gson.fromJson( object, GlicoseEntity.class ) );
				
		try {

			repository.excluir(po.getCodigo());

			return "Registro alterado com sucesso!";

		} catch (Exception e) {

			return "Erro ao alterar o registro " + e.getMessage();

		}
	}
	

	
	@GET
	@Path( "/listaTodos.ws" )
	@Produces( "application/json" )	
	public String listaTodos() {

		List<GlicoseEntity> listaEntityGlicose = repository.listaTodos();

		return new Gson().toJson( listaEntityGlicose );

	}
		
	
	@POST
	@Path( "/listaPorCodigo.ws" )
	@Produces( "application/json" )
	public String listaPorCodigo(String glicoseJason) {

		GlicoseEntity encontrado = null;

		 Gson gson = new Gson();
		try {
			GlicoseEntity po = new GlicoseEntity();
			JsonParser parse = new JsonParser();
			JsonObject object = parse.parse( glicoseJason ).getAsJsonObject();

			po = ( gson.fromJson( object, GlicoseEntity.class ) );
						
			encontrado = repository.listarPorCodigo(po.getCodigo()); 
					
						
		} catch ( Exception e ) {
			return "Erro no getCuidador " + e.getMessage();
		}

		return gson.toJson( encontrado );

	}
	
}//Fim da classe

