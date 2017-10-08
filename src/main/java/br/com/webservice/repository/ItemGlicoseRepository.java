package br.com.webservice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.webservice.repository.entity.ItemGlicoseEntity;

public class ItemGlicoseRepository {
	
	private final EntityManagerFactory entityManagerFactory;

	private final EntityManager entityManager;

	public ItemGlicoseRepository(){

		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistenceAux");

		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	/**
	 * CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	 * */
	public void cadastrar(ItemGlicoseEntity itemGlicoseEntity){

		this.entityManager.getTransaction().begin();
		this.entityManager.persist(itemGlicoseEntity);
		this.entityManager.getTransaction().commit();
	}

	/**
	 * ALTERA UM REGISTRO CADASTRADO
	 * */
	public void alterar(ItemGlicoseEntity itemGlicoseEntity){

		this.entityManager.getTransaction().begin();
		this.entityManager.merge(itemGlicoseEntity);
		this.entityManager.getTransaction().commit();
	}

	/**
	 * RETORNA TODOSOS REGISTROS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<ItemGlicoseEntity> listaTodos(){

		return this.entityManager.createQuery("SELECT * FROM ItemGlicoseEntity ORDER BY codigo").getResultList();
	}

	/**
	 * CONSULTA UM REGISTRO CADASTRADO PELO CODIGO
	 * */
	public ItemGlicoseEntity listarPorCodigo(Integer codigo){

		return this.entityManager.find(ItemGlicoseEntity.class, codigo);
	}
	

	/**
	 * EXCLUINDO UM REGISTRO PELO CÓDIGO
	**/
	public void excluir(Integer codigo){

		ItemGlicoseEntity itemGlicose = this.listarPorCodigo(codigo);

		this.entityManager.getTransaction().begin();
		this.entityManager.remove(itemGlicose);
		this.entityManager.getTransaction().commit();

	}

}
