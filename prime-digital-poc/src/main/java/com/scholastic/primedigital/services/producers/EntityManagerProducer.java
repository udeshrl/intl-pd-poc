package com.scholastic.primedigital.services.producers;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;



@ApplicationScoped
public class EntityManagerProducer {

	/**
	 * EntityManager context
	 */
	@PersistenceContext(name="primedigital",type=PersistenceContextType.EXTENDED)
	private transient EntityManager entityManager;

	/**
	 * create EntityManager
	 * 
	 * @return
	 */
	@Produces
	protected EntityManager createEntityManager() {
		return this.entityManager;
	}

	/**
	 * close EntityManager
	 * 
	 * @param entityManager
	 * 
	 */

	protected void closeEntityManager(
			@Disposes final EntityManager entityManager) {
		// Do nothing
	}

}