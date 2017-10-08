package br.com.webservice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.webservice.repository.entity.ItemMedicamentoEntity;
import br.com.webservice.repository.entity.SosEntity;

public class ItemMedicamentoRepository {
	
	private final EntityManagerFactory entityManagerFactory;

	private final EntityManager entityManager;

	public ItemMedicamentoRepository(){

		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistenceAux");

		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	/**
	 * CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	 * */
	public void cadastrar(ItemMedicamentoEntity itemmedicamentoEntity){

		this.entityManager.getTransaction().begin();
		this.entityManager.persist(itemmedicamentoEntity);
		this.entityManager.getTransaction().commit();
	}

	/**
	 * ALTERA UM REGISTRO CADASTRADO
	 * */
	public void alterar(ItemMedicamentoEntity itemmedicamentoEntity){

		this.entityManager.getTransaction().begin();
		this.entityManager.merge(itemmedicamentoEntity);
		this.entityManager.getTransaction().commit();
	}

	/**
	 * RETORNA TODOSOS REGISTROS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<ItemMedicamentoEntity> listaTodos(){

		return this.entityManager.createQuery("SELECT * FROM ItemMedicamentoEntity ORDER BY codigo").getResultList();
	}

	/**
	 * CONSULTA UM REGISTRO CADASTRADO PELO CODIGO
	 * */
	public ItemMedicamentoEntity listaPorCodigo(Integer codigo){

		return this.entityManager.find(ItemMedicamentoEntity.class, codigo);
	}
	

	/**
	 * EXCLUINDO UM REGISTRO PELO CÓDIGO
	**/
	public void excluir(Integer codigo){

		ItemMedicamentoEntity itemMedicamento = this.listaPorCodigo(codigo);

		this.entityManager.getTransaction().begin();
		this.entityManager.remove(itemMedicamento);
		this.entityManager.getTransaction().commit();

	}

}
