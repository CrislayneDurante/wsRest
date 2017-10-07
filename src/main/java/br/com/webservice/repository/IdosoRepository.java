package br.com.webservice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.webservice.repository.entity.IdosoEntity;

public class IdosoRepository {
	
	private final EntityManagerFactory entityManagerFactory;

	private final EntityManager entityManager;

	public IdosoRepository(){

		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistenceAux");

		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	/**
	 * CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	 * */
	public void cadastrar(IdosoEntity idosoEntity){

		this.entityManager.getTransaction().begin();
		this.entityManager.persist(idosoEntity);
		this.entityManager.getTransaction().commit();
	}

	/**
	 * ALTERA UM REGISTRO CADASTRADO
	 * */
	public void alterar(IdosoEntity idosoEntity){

		this.entityManager.getTransaction().begin();
		this.entityManager.merge(idosoEntity);
		this.entityManager.getTransaction().commit();
	}

	/**
	 * RETORNA TODOSOS REGISTROS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<IdosoEntity> listaTodos(){

		return this.entityManager.createQuery("SELECT * FROM IdosoEntity ORDER BY nome").getResultList();
	}

	/**
	 * CONSULTA UM REGISTRO CADASTRADO PELO CODIGO
	 * */
	public IdosoEntity listaPorCodigo(Integer codigo){

		return this.entityManager.find(IdosoEntity.class, codigo);
	}
	

	/**
	 * EXCLUINDO UM REGISTRO PELO CÓDIGO
	**/
	public void excluir(Integer codigo){

		IdosoEntity idoso = this.listaPorCodigo(codigo);

		this.entityManager.getTransaction().begin();
		this.entityManager.remove(idoso);
		this.entityManager.getTransaction().commit();

	}

}//Fim da classe
