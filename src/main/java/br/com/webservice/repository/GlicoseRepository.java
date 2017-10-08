package br.com.webservice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.webservice.repository.entity.GlicoseEntity;

public class GlicoseRepository {
	
	private final EntityManagerFactory entityManagerFactory;

	private final EntityManager entityManager;

	public GlicoseRepository(){

		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistenceAux");

		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	/**
	 * CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	 * */
	public void cadastrar(GlicoseEntity glicoseEntity){

		this.entityManager.getTransaction().begin();
		this.entityManager.persist(glicoseEntity);
		this.entityManager.getTransaction().commit();
	}

	/**
	 * ALTERA UM REGISTRO CADASTRADO
	 * */
	public void alterar(GlicoseEntity glicoseEntity){

		this.entityManager.getTransaction().begin();
		this.entityManager.merge(glicoseEntity);
		this.entityManager.getTransaction().commit();
	}

	/**
	 * RETORNA TODOSOS REGISTROS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<GlicoseEntity> listaTodos(){

		return this.entityManager.createQuery("SELECT * FROM GlicoseEntity ORDER BY codigo").getResultList();
	}

	/**
	 * CONSULTA UM REGISTRO CADASTRADO PELO CODIGO
	 * */
	public GlicoseEntity listarPorCodigo(Integer codigo){

		return this.entityManager.find(GlicoseEntity.class, codigo);
	}
	

	/**
	 * EXCLUINDO UM REGISTRO PELO CÓDIGO
	**/
	public void excluir(Integer codigo){

		GlicoseEntity glicose = this.listarPorCodigo(codigo);

		this.entityManager.getTransaction().begin();
		this.entityManager.remove(glicose);
		this.entityManager.getTransaction().commit();

	}

}
