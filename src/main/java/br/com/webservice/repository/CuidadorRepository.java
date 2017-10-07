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
	public void alterar(CuidadorEntity cuidadorEntity){

		this.entityManager.getTransaction().begin();
		this.entityManager.merge(cuidadorEntity);
		this.entityManager.getTransaction().commit();
	}

	/**
	 * RETORNA TODAS AS PESSOAS CADASTRADAS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<CuidadorEntity> getCuidadores(){

		return this.entityManager.createQuery("SELECT * FROM CuidadorEntity ORDER BY nome").getResultList();
	}

	/**
	 * CONSULTA UMA PESSOA CADASTRA PELO CÓDIGO
	 * */
	public CuidadorEntity getCuidador(Integer codigo){

		return this.entityManager.find(CuidadorEntity.class, codigo);
	}
	

	/**
	 * EXCLUINDO UM REGISTRO PELO CÓDIGO
	**/
	public void excluir(Integer codigo){

		CuidadorEntity cuidador = this.getCuidador(codigo);

		this.entityManager.getTransaction().begin();
		this.entityManager.remove(cuidador);
		this.entityManager.getTransaction().commit();

	}
}//Fim da classe