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

import br.com.webservice.repository.MedicamentosRepository;
import br.com.webservice.repository.SosRepository;
import br.com.webservice.repository.entity.MedicamentosEntity;
import br.com.webservice.repository.entity.SosEntity;

@Path("/service/medicamentos")
public class MedicamentosController {

private final  MedicamentosRepository repository = new MedicamentosRepository();

	
	
	@POST
	@Path( "/cadastrar.ws" )
	@Produces( "application/json" )
	@Consumes( "application/json" )
	public String cadastrar( String medicamentosJason ) {
		Gson gson = new Gson();
		MedicamentosEntity po = new MedicamentosEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( medicamentosJason ).getAsJsonObject();

		po = ( gson.fromJson( object, SosEntity.class ) );
				
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
	public String editar( String medicamentosJason ) {
		Gson gson = new Gson();
		MedicamentosEntity po = new MedicamentosEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( medicamentosJason ).getAsJsonObject();

		po = ( gson.fromJson( object, MedicamentosEntity.class ) );
				
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
	public String excluir( String medicamentosJason ) {
		Gson gson = new Gson();
		MedicamentosEntity po = new MedicamentosEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( medicamentosJason ).getAsJsonObject();

		po = ( gson.fromJson( object, MedicamentosEntity.class ) );
				
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

		List<MedicamentosEntity> listaEntityMedicamentos = repository.listaTodos();

		return new Gson().toJson( listaEntityMedicamentos );

	}
		
	
	@POST
	@Path( "/listaPorCodigo.ws" )
	@Produces( "application/json" )
	public String listaPorCodigo(String medicamentosJason) {

		 MedicamentosEntity encontrado = null;

		 Gson gson = new Gson();
		try {
			MedicamentosEntity po = new MedicamentosEntity();
			JsonParser parse = new JsonParser();
			JsonObject object = parse.parse( medicamentosJason ).getAsJsonObject();

			po = ( gson.fromJson( object, MedicamentosEntity.class ) );
						
			encontrado = repository.listarPorCodigo( po.getCodigo() );
					
						
		} catch ( Exception e ) {
			return "Erro no getMedicamentos " + e.getMessage();
		}

		return gson.toJson( encontrado );

	}
	
}//Fim da classe
