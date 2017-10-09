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

import br.com.webservice.repository.CuidadorRepository;
import br.com.webservice.repository.entity.CuidadorEntity;


/**
 * Essa classe vai expor os nossos métodos para serem acessasdos via http
 * 
 * @Path - Caminho para a chamada da classe que vai representar o nosso serviço
 * */
@Path("/service/cuidador")
public class CuidadorController {

	private final  CuidadorRepository repository = new CuidadorRepository();

	
	
	@POST
	@Path( "/cadastrar.ws" )
	@Produces( "application/json" )
	@Consumes( "application/json" )
	public String cadastrar( String cuidadorJason ) {
		Gson gson = new Gson();
		CuidadorEntity po = new CuidadorEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( cuidadorJason ).getAsJsonObject();

		po = ( gson.fromJson( object, CuidadorEntity.class ) );
				
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
	public String editar( String cuidadorJason ) {
		Gson gson = new Gson();
		CuidadorEntity po = new CuidadorEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( cuidadorJason ).getAsJsonObject();

		po = ( gson.fromJson( object, CuidadorEntity.class ) );
				
		try {

			repository.editar(po);

			return "Registro alterado com sucesso!";

		} catch (Exception e) {

			return "Erro ao alterar o registro " + e.getMessage();

		}
	}
	
	
	
	@POST
	@Path( "/excluir.ws" )
	@Produces( "application/json" )
	public String excluir( String cuidadorJason ) {
		Gson gson = new Gson();
		CuidadorEntity po = new CuidadorEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( cuidadorJason ).getAsJsonObject();

		po = ( gson.fromJson( object, CuidadorEntity.class ) );
				
		try {

			repository.excluir(po.getCodigo());

			return "Registro alterado com sucesso!";

		} catch (Exception e) {

			return "Erro ao alterar o registro " + e.getMessage();

		}
	}
	

	
	@POST
	@Path( "/listaTodos.ws" )
	@Produces( "application/json" )	
	public String listaTodos() {

		List<CuidadorEntity> listaEntityCuidadores = repository.listaTodos();

		return new Gson().toJson( listaEntityCuidadores );

	}
		
	
	@POST
	@Path( "/listaPorCodigo.ws" )
	@Produces( "application/json" )
	public String listaPorCodigo(String cuidadorJason) {

		 CuidadorEntity encontrado = null;

		 Gson gson = new Gson();
		try {
			CuidadorEntity po = new CuidadorEntity();
			JsonParser parse = new JsonParser();
			JsonObject object = parse.parse( cuidadorJason ).getAsJsonObject();

			po = ( gson.fromJson( object, CuidadorEntity.class ) );
						
			encontrado = repository.listaPorCodigo( po.getCodigo() );
					
						
		} catch ( Exception e ) {
			return "Erro no getCuidador " + e.getMessage();
		}

		return gson.toJson( encontrado );

	}

}//Fim da classe
