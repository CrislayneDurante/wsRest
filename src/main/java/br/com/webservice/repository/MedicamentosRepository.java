package br.com.webservice.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.webservice.repository.entity.MedicamentosEntity;

public class MedicamentosRepository {

	private final EntityManagerFactory entityManagerFactory;

	private final EntityManager entityManager;

	public MedicamentosRepository(){

		/*CRIANDO O NOSSO EntityManagerFactory COM AS PORPRIEDADOS DO ARQUIVO persistence.xml */
		this.entityManagerFactory = Persistence.createEntityManagerFactory("persistenceAux");

		this.entityManager = this.entityManagerFactory.createEntityManager();
	}

	/**
	 * CRIA UM NOVO REGISTRO NO BANCO DE DADOS
	 * */
	public void cadastrar(MedicamentosEntity medicamentosEntity){

		this.entityManager.getTransaction().begin();
		this.entityManager.persist(medicamentosEntity);
		this.entityManager.getTransaction().commit();
	}

	/**
	 * ALTERA UM REGISTRO CADASTRADO
	 * */
	public void alterar(MedicamentosEntity medicamentosEntity){

		this.entityManager.getTransaction().begin();
		this.entityManager.merge(medicamentosEntity);
		this.entityManager.getTransaction().commit();
	}

	/**
	 * RETORNA TODOS OS REGISTROS CADASTRADOS NO BANCO DE DADOS 
	 * */
	@SuppressWarnings("unchecked")
	public List<MedicamentosEntity> listaTodos(){

		return this.entityManager.createQuery("SELECT * FROM MedicamentosEntity ORDER BY nome").getResultList();
	}

	/**
	 * CONSULTA UM REGISTRO CADASTRADO PELO CÓDIGO
	 * */
	public MedicamentosEntity listarPorCodigo(Integer codigo){

		return this.entityManager.find(MedicamentosEntity.class, codigo);
	}
	

	/**
	 * EXCLUINDO UM REGISTRO PELO CÓDIGO
	**/
	public void excluir(Integer codigo){

		MedicamentosEntity medicamentos = this.listarPorCodigo(codigo);

		this.entityManager.getTransaction().begin();
		this.entityManager.remove(medicamentos);
		this.entityManager.getTransaction().commit();

	}
}//Fim da classe