package br.com.webservice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.webservice.repository.entity.SosEntity;

public class SosRepository {
	
	private final EntityManagerFactory entityManagerFactory;

	private final EntityManager entityManager;

	public SosRepository(){

		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistenceAux");

		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	/**
	 * CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	 * */
	public void cadastrar(SosEntity sosEntity){

		this.entityManager.getTransaction().begin();
		this.entityManager.persist(sosEntity);
		this.entityManager.getTransaction().commit();
	}

	/**
	 * ALTERA UM REGISTRO CADASTRADO
	 * */
	public void alterar(SosEntity sosEntity){

		this.entityManager.getTransaction().begin();
		this.entityManager.merge(sosEntity);
		this.entityManager.getTransaction().commit();
	}

	/**
	 * RETORNA TODOSOS REGISTROS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<SosEntity> listaTodos(){

		return this.entityManager.createQuery("SELECT * FROM SosEntity ORDER BY codigo").getResultList();
	}

	/**
	 * CONSULTA UM REGISTRO CADASTRADO PELO CODIGO
	 * */
	public SosEntity listaPorCodigo(Integer codigo){

		return this.entityManager.find(SosEntity.class, codigo);
	}
	

	/**
	 * EXCLUINDO UM REGISTRO PELO CÓDIGO
	**/
	public void excluir(Integer codigo){

		SosEntity sos = this.listaPorCodigo(codigo);

		this.entityManager.getTransaction().begin();
		this.entityManager.remove(sos);
		this.entityManager.getTransaction().commit();

	}

}
