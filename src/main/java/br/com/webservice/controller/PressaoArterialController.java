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

import br.com.webservice.repository.PressaoArterialRepository;
import br.com.webservice.repository.entity.PressaoArterialEntity;

@Path("/service/pressaoarterial")
public class PressaoArterialController {

private final  PressaoArterialRepository repository = new PressaoArterialRepository();

	
	
	@POST
	@Path( "/cadastrar.ws" )
	@Produces( "application/json" )
	@Consumes( "application/json" )
	public String cadastrar( String pressaoArterialJason ) {
		Gson gson = new Gson();
		PressaoArterialEntity po = new PressaoArterialEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( pressaoArterialJason ).getAsJsonObject();

		po = ( gson.fromJson( object, PressaoArterialEntity.class ) );
				
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
	public String editar( String pressaoArterialJason ) {
		Gson gson = new Gson();
		PressaoArterialEntity po = new PressaoArterialEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( pressaoArterialJason ).getAsJsonObject();

		po = ( gson.fromJson( object, PressaoArterialEntity.class ) );
				
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
	public String excluir( String pressaoArterialJason ) {
		Gson gson = new Gson();
		PressaoArterialEntity po = new PressaoArterialEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( pressaoArterialJason ).getAsJsonObject();

		po = ( gson.fromJson( object, PressaoArterialEntity.class ) );
				
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

		List<PressaoArterialEntity> listaEntitySos = repository.listaTodos();

		return new Gson().toJson( listaEntitySos );

	}
		
	
	@POST
	@Path( "/listaPorCodigo.ws" )
	@Produces( "application/json" )
	public String listaPorCodigo(String pressaoArterialJason) {

		 PressaoArterialEntity encontrado = null;

		 Gson gson = new Gson();
		try {
			PressaoArterialEntity po = new PressaoArterialEntity();
			JsonParser parse = new JsonParser();
			JsonObject object = parse.parse( pressaoArterialJason ).getAsJsonObject();

			po = ( gson.fromJson( object, PressaoArterialEntity.class ) );
						
			encontrado = repository.listarPorCodigo( po.getCodigo() );
					
						
		} catch ( Exception e ) {
			return "Erro no getCuidador " + e.getMessage();
		}

		return gson.toJson( encontrado );

	}
	
}//Fim da classe

