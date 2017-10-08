package br.com.webservice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.webservice.repository.entity.ItemPressaoArterialEntity;

public class ItemPressaoArterialRepository {
	
	
	private final EntityManagerFactory entityManagerFactory;

	private final EntityManager entityManager;

	public ItemPressaoArterialRepository(){

		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistenceAux");

		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	/**
	 * CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	 * */
	public void cadastrar(ItemPressaoArterialEntity itemPressaoArterialEntity){

		this.entityManager.getTransaction().begin();
		this.entityManager.persist(itemPressaoArterialEntity);
		this.entityManager.getTransaction().commit();
	}

	/**
	 * ALTERA UM REGISTRO CADASTRADO
	 * */
	public void alterar(ItemPressaoArterialEntity itemPressaoArterialEntity){

		this.entityManager.getTransaction().begin();
		this.entityManager.merge(itemPressaoArterialEntity);
		this.entityManager.getTransaction().commit();
	}

	/**
	 * RETORNA TODOSOS REGISTROS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<ItemPressaoArterialEntity> listaTodos(){

		return this.entityManager.createQuery("SELECT * FROM ItemPressaoArterialEntity ORDER BY codigo").getResultList();
	}

	/**
	 * CONSULTA UM REGISTRO CADASTRADO PELO CODIGO
	 * */
	public ItemPressaoArterialEntity listarPorCodigo(Integer codigo){

		return this.entityManager.find(ItemPressaoArterialEntity.class, codigo);
	}
	

	/**
	 * EXCLUINDO UM REGISTRO PELO CÓDIGO
	**/
	public void excluir(Integer codigo){

		ItemPressaoArterialEntity itemPressaoArterialEntity = this.listarPorCodigo(codigo);

		this.entityManager.getTransaction().begin();
		this.entityManager.remove(itemPressaoArterialEntity);
		this.entityManager.getTransaction().commit();

	}

}
