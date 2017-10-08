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

import br.com.webservice.repository.ItemMedicamentoRepository;
import br.com.webservice.repository.entity.ItemMedicamentoEntity;

@Path("/service/itemMedicamento")
public class ItemMedicamentoController {

private final  ItemMedicamentoRepository repository = new ItemMedicamentoRepository();

	
	
	@POST
	@Path( "/cadastrar.ws" )
	@Produces( "application/json" )
	@Consumes( "application/json" )
	public String cadastrar( String itemmedicamentoJason ) {
		Gson gson = new Gson();
		ItemMedicamentoEntity po = new ItemMedicamentoEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( itemmedicamentoJason ).getAsJsonObject();

		po = ( gson.fromJson( object, ItemMedicamentoEntity.class ) );
				
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
	public String editar( String itemmedicamentoJason ) {
		Gson gson = new Gson();
		ItemMedicamentoEntity po = new ItemMedicamentoEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( itemmedicamentoJason ).getAsJsonObject();

		po = ( gson.fromJson( object, ItemMedicamentoEntity.class ) );
				
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
	public String excluir( String itemmedicamentoJason ) {
		Gson gson = new Gson();
		ItemMedicamentoEntity po = new ItemMedicamentoEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( itemmedicamentoJason ).getAsJsonObject();

		po = ( gson.fromJson( object, ItemMedicamentoEntity.class ) );
				
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

		List<ItemMedicamentoEntity> listaEntityItemMedicamento = repository.listaTodos();

		return new Gson().toJson( listaEntityItemMedicamento );

	}
		
	
	@POST
	@Path( "/listaPorCodigo.ws" )
	@Produces( "application/json" )
	public String listaPorCodigo(String itemmedicamentoJason) {

		ItemMedicamentoEntity encontrado = null;

		 Gson gson = new Gson();
		try {
			ItemMedicamentoEntity po = new ItemMedicamentoEntity();
			JsonParser parse = new JsonParser();
			JsonObject object = parse.parse( itemmedicamentoJason ).getAsJsonObject();

			po = ( gson.fromJson( object, ItemMedicamentoEntity.class ) );
						
			encontrado = repository.listaPorCodigo( po.getCodigo() );
					
						
		} catch ( Exception e ) {
			return "Erro no getCuidador " + e.getMessage();
		}

		return gson.toJson( encontrado );

	}
	
}//Fim da classe

