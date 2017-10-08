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

import br.com.webservice.repository.ItemPressaoArterialRepository;
import br.com.webservice.repository.SosRepository;
import br.com.webservice.repository.entity.ItemPressaoArterialEntity;
import br.com.webservice.repository.entity.SosEntity;

@Path("/service/itempressaoarterial")
public class ItemPressaoArterialController {

private final  ItemPressaoArterialRepository repository = new ItemPressaoArterialRepository();

	
	
	@POST
	@Path( "/cadastrar.ws" )
	@Produces( "application/json" )
	@Consumes( "application/json" )
	public String cadastrar( String itemPressaoArterialJason ) {
		Gson gson = new Gson();
		ItemPressaoArterialEntity po = new ItemPressaoArterialEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( itemPressaoArterialJason ).getAsJsonObject();

		po = ( gson.fromJson( object, ItemPressaoArterialEntity.class ) );
				
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
	public String editar( String itemPressaoArterialJason ) {
		Gson gson = new Gson();
		ItemPressaoArterialEntity po = new ItemPressaoArterialEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( itemPressaoArterialJason ).getAsJsonObject();

		po = ( gson.fromJson( object, ItemPressaoArterialEntity.class ) );
				
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
	public String excluir( String itemPressaoArterialJason ) {
		Gson gson = new Gson();
		ItemPressaoArterialEntity po = new ItemPressaoArterialEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( itemPressaoArterialJason ).getAsJsonObject();

		po = ( gson.fromJson( object, ItemPressaoArterialEntity.class ) );
				
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

		List<ItemPressaoArterialEntity> listaEntityItemPressaoArterial = repository.listaTodos();

		return new Gson().toJson( listaEntityItemPressaoArterial );

	}
		
	
	@POST
	@Path( "/listaPorCodigo.ws" )
	@Produces( "application/json" )
	public String listaPorCodigo(String itemPressaoArterialJason) {

		 ItemPressaoArterialEntity encontrado = null;

		 Gson gson = new Gson();
		try {
			ItemPressaoArterialEntity po = new ItemPressaoArterialEntity();
			JsonParser parse = new JsonParser();
			JsonObject object = parse.parse( itemPressaoArterialJason ).getAsJsonObject();

			po = ( gson.fromJson( object, ItemPressaoArterialEntity.class ) );
						
			encontrado = repository.listarPorCodigo( po.getCodigo() );
					
						
		} catch ( Exception e ) {
			return "Erro no getCuidador " + e.getMessage();
		}

		return gson.toJson( encontrado );

	}
	
}//Fim da classe

