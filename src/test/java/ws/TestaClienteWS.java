package ws;


import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import br.com.webservice.repository.entity.PessoaEntity;

public class TestaClienteWS{

	private static final String URLWS = "http://localhost:8080/wsRest";

	public static void main( String[ ] args ) {

		//buscarDeficiencias();
		//inserirLocal();
		//inserirAvaliacao();
		cadastrar();
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri( URLWS ).build();
	}
	
	private static void cadastrar() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create( config );
		WebResource service = client.resource( getBaseURI() );

		PessoaEntity po = new PessoaEntity();
		po.setNome("Camila");
		po.setNumCelular("999999999");
		po.setCuidador(true);

		Gson gson = new Gson();
		String pessoaJason = gson.toJson( po );

		String response = "";
		
		//response = service.path( "service" ).path( "cadastrar2.ws" ).type( MediaType.APPLICATION_JSON ).post( String.class, pessoaJason );

		System.out.println( response );
		
		
		po = new PessoaEntity();
		po.setCodigo(5);
		gson = new Gson();
		pessoaJason = gson.toJson( po );
		
		response = service.path( "service" ).path( "getPessoa.ws" ).type( MediaType.APPLICATION_JSON ).post( String.class, pessoaJason );

		System.out.println( response );
		
	}

	/*private static void login() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create( config );
		WebResource service = client.resource( getBaseURI() );

		UsuarioPO po = new UsuarioPO();
		po.setLogin( "jorge" );
		po.setSenha( "jorge" );

		Gson gson = new Gson();
		String usuarioJason = gson.toJson( po );

		String response = service.path( "avaliacaosystem" ).path( "login.ws" ).type( MediaType.APPLICATION_JSON ).post( String.class, usuarioJason );

		System.out.println( response );
	}

	private static void buscarDeficiencias() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create( config );
		WebResource service = client.resource( getBaseURI() );

		String response = service.path( "avaliacaosystem" ).path( "buscardeficiencias.ws" ).type( MediaType.APPLICATION_JSON ).post( String.class );

		System.out.println( response );
	}

	private static void inserirUsuario() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create( config );
		WebResource service = client.resource( getBaseURI() );

		UsuarioPO po = new UsuarioPO();
		po.setLogin( "claudio" );
		po.setSenha( "claudio" );
		po.setDeficiencias( filtrarDeficiencias( 1L ) );

		Gson gson = new Gson();
		String usuarioJason = gson.toJson( po );

		String response = service.path( "avaliacaosystem" ).path( "inserirusuario.ws" ).type( MediaType.APPLICATION_JSON ).post( String.class, usuarioJason );

		System.out.println( response );
	}

	private static void inserirLocal() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create( config );
		WebResource service = client.resource( getBaseURI() );

		LocalPO po = new LocalPO();
		po.setLatitude( (double) 222222 );
		po.setLongitude( (double) 332322323 );
		po.setNome( "SRC Treinamento tecnologico" );
		po.setSegmento( "Aberto" );

		Gson gson = new Gson();
		String localJason = gson.toJson( po );

		String response = service.path( "avaliacaosystem" ).path( "inserirlocal.ws" ).type( MediaType.APPLICATION_JSON ).post( String.class, localJason );

		System.out.println( response );
	}

	private static void alterarLocal() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create( config );
		WebResource service = client.resource( getBaseURI() );

		LocalPO po = new LocalPO();
		po.setNome( "nada alterado 2" );

		ArrayList< LocalPO > encontrados;
		try {
			encontrados = LocalFacade.getInstance().filtrar( po );
			for ( LocalPO localPO : encontrados ) {
				System.out.println( localPO );
			}

			LocalPO poAlterar = encontrados.get( 0 );
			poAlterar.setNome( "nada alterado 3" );

			LocalFacade.getInstance().alterar( poAlterar );
		} catch ( ApplicationException e ) {
			e.printStackTrace();
		}

		Gson gson = new Gson();
		String localJason = gson.toJson( po );

		String response = service.path( "avaliacaosystem" ).path( "alterarlocal.ws" ).type( MediaType.APPLICATION_JSON ).post( String.class, localJason );

		System.out.println( response );
	}

	private static void inserirAvaliacao() {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create( config );
		WebResource service = client.resource( getBaseURI() );

		AvaliacaoPO po = new AvaliacaoPO();
		po.setUsuario( filtrarUsuarioPorCodigo( 4L ) );
		po.setLocal( filtrarLocalPorCodigo( 2L ) );

		AvaliacaoPerguntaPO perguntaPO = new AvaliacaoPerguntaPO();
		perguntaPO.setPergunta( filtrarPergunta( 1L ) );
		perguntaPO.setResposta( "sim" );

		AvaliacaoPerguntaPO perguntaPO2 = new AvaliacaoPerguntaPO();
		perguntaPO2.setPergunta( filtrarPergunta( 2L ) );
		perguntaPO2.setResposta( "sim" );
		
		AvaliacaoPerguntaPO perguntaPO3 = new AvaliacaoPerguntaPO();
		perguntaPO3.setPergunta( filtrarPergunta( 3L ) );
		perguntaPO3.setResposta( "nao" );
		
		AvaliacaoPerguntaPO perguntaPO4 = new AvaliacaoPerguntaPO();
		perguntaPO4.setPergunta( filtrarPergunta( 4L ) );
		perguntaPO4.setResposta( "nao" );
		
		AvaliacaoPerguntaPO perguntaPO5 = new AvaliacaoPerguntaPO();
		perguntaPO5.setPergunta( filtrarPergunta( 5L ) );
		perguntaPO5.setResposta( "sim" );

		po.setAvaliacaoPergunta( new HashSet< AvaliacaoPerguntaPO >() );
		po.getAvaliacaoPergunta().add( perguntaPO );
		po.getAvaliacaoPergunta().add( perguntaPO2 );
		po.getAvaliacaoPergunta().add( perguntaPO3 );
		po.getAvaliacaoPergunta().add( perguntaPO4 );
		po.getAvaliacaoPergunta().add( perguntaPO5 );

		po.setData( new Date() );

		Gson gson = new Gson();
		String avaliacaoJason = gson.toJson( po );

		String response = service.path( "avaliacaosystem" ).path( "inseriravaliacao.ws" ).type( MediaType.APPLICATION_JSON ).post( String.class, avaliacaoJason );

		System.out.println( response );
	}

	public List<ParadaWSModel> consultarTodasParadas() throws Exception {

		  String[] resposta = new WebService().get(URL_WS + "consultarTodasParadas");
		  
		  if (resposta[0].equals("200")) {
		   Gson gson = new Gson();
		   ArrayList<ParadaWSModel> listaParadas = new ArrayList<ParadaWSModel>();
		   JsonParser parser = new JsonParser();
		   JsonArray array = parser.parse(resposta[1]).getAsJsonArray();

		   for (int i = 0; i < array.size(); i++) {
		    listaParadas.add(gson.fromJson(array.get(i), ParadaWSModel.class));
		   }
		   return listaParadas;
		  } else {
		   throw new Exception(resposta[0]);
		  }
		 }

	*//**
	 * 
	 * Método responsável por filtra deficiências
	 * 
	 * @param codigo
	 * @return
	 * 
	 * @author Marcelo Davanço Freire<mardafre@gmail.com>
	 * @since 24/04/2015 19:21:03
	 * @version 1.0
	 *//*
	public static Set< DeficienciaPO > filtrarDeficiencias( Long codigo ) {

		DeficienciaPO po = new DeficienciaPO();

		po.setCodigo( codigo );

		ArrayList< DeficienciaPO > encontrados = null;
		Set< DeficienciaPO > set = null;
		try {
			encontrados = DeficienciaFacade.getInstance().filtrar( po );
			set = new HashSet< DeficienciaPO >( encontrados );
		} catch ( ApplicationException e ) {
			e.printStackTrace();
		}

		return set;
	}

	*//**
	 * 
	 * Método responsável por filtrar um usuario para inserir na avaliação
	 * 
	 * @param login
	 * @return
	 * 
	 * @author Marcelo Davanço Freire<mardafre@gmail.com>
	 * @author Frederico Carneiro Lessa<fred.lessa@gmail.com>
	 * @since 09/04/2015 18:38:40
	 * @version 1.0
	 *//*
	public static UsuarioPO filtrarUsuarioPorCodigo( Long codigo ) {

		UsuarioPO po = new UsuarioPO();

		po.setCodigo( codigo );

		ArrayList< UsuarioPO > encontrados = null;

		try {
			encontrados = UsuarioFacade.getInstance().filtrar( po );
		} catch ( ApplicationException e ) {
			e.printStackTrace();
		}

		return encontrados.get( 0 );
	}

	*//**
	 * 
	 * Método responsável por filtrar um local para inserir na avaliação
	 * 
	 * @param nome
	 * @return
	 * 
	 * @author Marcelo Davanço Freire<mardafre@gmail.com>
	 * @since 09/04/2015 18:39:18
	 * @version 1.0
	 *//*
	public static LocalPO filtrarLocalPorCodigo( Long codigo ) {

		LocalPO po = new LocalPO();

		po.setCodigo( codigo );

		ArrayList< LocalPO > encontrados = null;

		try {
			encontrados = LocalFacade.getInstance().filtrar( po );
		} catch ( ApplicationException e ) {
			e.printStackTrace();
		}

		return encontrados.get( 0 );
	}

	*//**
	 * 
	 * Método responsável por filtrar pergunta para inserir na avaliação
	 * 
	 * @param codigo
	 * @return
	 * 
	 * @author Marcelo Davanço Freire<mardafre@gmail.com>
	 * @since 09/04/2015 18:39:35
	 * @version 1.0
	 *//*
	public static PerguntaPO filtrarPergunta( Long codigo ) {

		PerguntaPO po = new PerguntaPO();

		po.setCodigo( codigo );

		ArrayList< PerguntaPO > encontrados = null;

		try {
			encontrados = PerguntaFacade.getInstance().filtrar( po );
		} catch ( ApplicationException e ) {
			e.printStackTrace();
		}

		return encontrados.get( 0 );
	}*/

}


