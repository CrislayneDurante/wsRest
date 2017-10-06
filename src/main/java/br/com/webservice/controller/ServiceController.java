package br.com.webservice.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import br.com.webservice.repository.PessoaRepository;
import br.com.webservice.repository.entity.PessoaEntity;


/**
 * Essa classe vai expor os nossos métodos para serem acessasdos via http
 * 
 * @Path - Caminho para a chamada da classe que vai representar o nosso serviço
 * */
@Path("/service")
public class ServiceController {

	private final  PessoaRepository repository = new PessoaRepository();

	
	
	@POST
	@Path( "/cadastrar2.ws" )
	@Produces( "application/json" )
	@Consumes( "application/json" )
	public String cadastrar2( String pessoaJason ) {
		Gson gson = new Gson();
		PessoaEntity po = new PessoaEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( pessoaJason ).getAsJsonObject();

		po = ( gson.fromJson( object, PessoaEntity.class ) );
				
		try {
			
			repository.Salvar(po);

			return "Registro cadastrado com sucesso!";

		} catch (Exception e) {

			return "Erro ao cadastrar um registro " + e.getMessage();
		}
	}
	
	@POST
	@Path( "/editar2.ws" )
	@Produces( "application/json" )
	@Consumes( "application/json" )
	public String editar2( String pessoaJason ) {
		Gson gson = new Gson();
		PessoaEntity po = new PessoaEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( pessoaJason ).getAsJsonObject();

		po = ( gson.fromJson( object, PessoaEntity.class ) );
				
		try {

			repository.alterar(po);

			return "Registro alterado com sucesso!";

		} catch (Exception e) {

			return "Erro ao alterar o registro " + e.getMessage();

		}
	}
	
	
	
	@POST
	@Path( "/excluir2.ws" )
	@Produces( "application/json" )
	@Consumes( "application/json" )
	public String excluir2( String pessoaJason ) {
		Gson gson = new Gson();
		PessoaEntity po = new PessoaEntity();
		JsonParser parse = new JsonParser();
		JsonObject object = parse.parse( pessoaJason ).getAsJsonObject();

		po = ( gson.fromJson( object, PessoaEntity.class ) );
				
		try {

			repository.Excluir(po.getCodigo());

			return "Registro alterado com sucesso!";

		} catch (Exception e) {

			return "Erro ao alterar o registro " + e.getMessage();

		}
	}
	

	
	@POST
	@Path( "/buscarPessoas.ws" )
	@Produces( "application/json" )	
	public String buscarPessoa() {

		List<PessoaEntity> listaEntityPessoas = repository.TodasPessoas();

		return new Gson().toJson( listaEntityPessoas );

	}
		
	
	@POST
	@Path( "/getPessoa.ws" )
	@Produces( "application/json" )
	@Consumes( "application/json" )
	public String GetPessoa(String pessoaJason) {

		 PessoaEntity encontrado = null;

		 Gson gson = new Gson();
		try {
			PessoaEntity po = new PessoaEntity();
			JsonParser parse = new JsonParser();
			JsonObject object = parse.parse( pessoaJason ).getAsJsonObject();

			po = ( gson.fromJson( object, PessoaEntity.class ) );
						
			encontrado = repository.GetPessoa( po.getCodigo() );
					
						
		} catch ( Exception e ) {
			return "Errono GetPessoa " + e.getMessage();
		}

		return gson.toJson( encontrado );

	}

}//Fim da classe
