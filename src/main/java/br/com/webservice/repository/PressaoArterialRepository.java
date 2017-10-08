package br.com.webservice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.webservice.repository.entity.PressaoArterialEntity;

public class PressaoArterialRepository {
	
	private final EntityManagerFactory entityManagerFactory;

	private final EntityManager entityManager;

	public PressaoArterialRepository(){

		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistenceAux");

		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	/**
	 * CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	 * */
	public void cadastrar(PressaoArterialEntity pressaoArterialEntity){

		this.entityManager.getTransaction().begin();
		this.entityManager.persist(pressaoArterialEntity);
		this.entityManager.getTransaction().commit();
	}

	/**
	 * ALTERA UM REGISTRO CADASTRADO
	 * */
	public void alterar(PressaoArterialEntity pressaoArterialEntity){

		this.entityManager.getTransaction().begin();
		this.entityManager.merge(pressaoArterialEntity);
		this.entityManager.getTransaction().commit();
	}

	/**
	 * RETORNA TODOSOS REGISTROS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<PressaoArterialEntity> listaTodos(){

		return this.entityManager.createQuery("SELECT * FROM PressaoArterialEntity ORDER BY codigo").getResultList();
	}

	/**
	 * CONSULTA UM REGISTRO CADASTRADO PELO CODIGO
	 * */
	public PressaoArterialEntity listarPorCodigo(Integer codigo){

		return this.entityManager.find(PressaoArterialEntity.class, codigo);
	}
	

	/**
	 * EXCLUINDO UM REGISTRO PELO CÓDIGO
	**/
	public void excluir(Integer codigo){

		PressaoArterialEntity pressaoArterial = this.listarPorCodigo(codigo);

		this.entityManager.getTransaction().begin();
		this.entityManager.remove(pressaoArterial);
		this.entityManager.getTransaction().commit();

	}

}
