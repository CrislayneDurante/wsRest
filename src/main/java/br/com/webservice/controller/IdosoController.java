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

import br.com.webservice.repository.IdosoRepository;
import br.com.webservice.repository.entity.IdosoEntity;

@Path("/service/idoso")
public class IdosoController {


	private final  IdosoRepository repository = new IdosoRepository();

	
	@POST
	@Path( "/cadastrar.ws" )
	@Produces( "application/json" )
	@Consumes( "application/json" )
	public String cadastrar( String idosoJason ) {
		Gson gson = new Gson();
		IdosoEntity po = new IdosoEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( idosoJason ).getAsJsonObject();

		po = ( gson.fromJson( object, IdosoEntity.class ) );
				
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
	public String editar( String idosoJason ) {
		Gson gson = new Gson();
		IdosoEntity po = new IdosoEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( idosoJason ).getAsJsonObject();

		po = ( gson.fromJson( object, IdosoEntity.class ) );
				
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
	public String excluir( String idosoJason ) {
		Gson gson = new Gson();
		IdosoEntity po = new IdosoEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( idosoJason ).getAsJsonObject();

		po = ( gson.fromJson( object, IdosoEntity.class ) );
				
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

		List<IdosoEntity> listaEntityIdosos = repository.listaTodos();

		return new Gson().toJson( listaEntityIdosos );

	}
		
	
	@POST
	@Path( "/listaPorCodigo.ws" )
	@Produces( "application/json" )
	public String listaPorCodigo(String idosoJason) {

		 IdosoEntity encontrado = null;

		 Gson gson = new Gson();
		try {
			IdosoEntity po = new IdosoEntity();
			JsonParser parse = new JsonParser();
			JsonObject object = parse.parse( idosoJason ).getAsJsonObject();

			po = ( gson.fromJson( object, IdosoEntity.class ) );
						
			encontrado = repository.listaPorCodigo( po.getCodigo() );
					
						
		} catch ( Exception e ) {
			return "Erro no getCuidador " + e.getMessage();
		}

		return gson.toJson( encontrado );

	}

}
