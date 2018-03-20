package br.com.webservice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.webservice.repository.entity.CuidadorEntity;

public class CuidadorRepository {

	private final EntityManagerFactory entityManagerFactory;

	private final EntityManager entityManager;

	public CuidadorRepository(){

		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistenceAux");

		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	/**
	 * CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	 * */
	public void cadastrar(CuidadorEntity cuidadorEntity){

		this.entityManager.getTransaction().begin();
		this.entityManager.persist(cuidadorEntity);
		this.entityManager.getTransaction().commit();
	}

	/**
	 * ALTERA UM REGISTRO CADASTRADO
	 * */
	public void editar(CuidadorEntity cuidadorEntity){

		this.entityManager.getTransaction().begin();
		this.entityManager.merge(cuidadorEntity);
		this.entityManager.getTransaction().commit();
	}

	/**
	 * RETORNA TODOS OS REGISTROS CADASTRADOS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<CuidadorEntity> listaTodos(){

		return this.entityManager.createQuery("SELECT c FROM CuidadorEntity c ORDER BY c.nome").getResultList();
	}

	/**
	 * CONSULTA UM REGISTRO CADASTRADO PELO CÓDIGO
	 * */
	public CuidadorEntity listaPorCodigo(String token){

		return this.entityManager.find(CuidadorEntity.class, token);
	}
	

	/**
	 * EXCLUINDO UM REGISTRO PELO CÓDIGO
	**/
	public void excluir(String token){

		CuidadorEntity cuidador = this.listaPorCodigo(token);

		this.entityManager.getTransaction().begin();
		this.entityManager.remove(cuidador);
		this.entityManager.getTransaction().commit();

	}
}//Fim da classe