/*
 * Project: 
 * 	Cockpit Valuation Server
 *
 * Author:  
 *	Christian Zirpins
 *
 * Last Change: 
 *	by:   $$Author: $$
 *	date: $$Date:   $$
 *
 * Copyright (c):
 * 	2011 Karlsruhe Institute of Technology (KIT)
 * 
 * License:
 * 	Licensed under the Apache License, Version 2.0 (the "License"); you
 * 	may not use this file except in compliance with the License. You may
 * 	obtain a copy of the License at
 * 
 * 	http://www.apache.org/licenses/LICENSE-2.0
 * 
 * 	Unless required by applicable law or agreed to in writing, software
 * 	distributed under the License is distributed on an "AS IS" BASIS,
 * 	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * 	implied. See the License for the specific language governing
 * 	permissions and limitations under the License.
 */

package edu.kit.cockpit.valuationserver.dao;

import java.util.List;

import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import edu.kit.cockpit.valuationserver.servletfilter.JpaServletFilter;

/**
 * Superclass for all DAOs
 */
public abstract class AbstractDao {

	protected final EntityManager em;

	public AbstractDao() throws NamingException {

		em = JpaServletFilter.getEntityManager();

		// em = (EntityManager) (new InitialContext())
		// .lookup("java:comp/env/persistence/em");
	}

	/**
	 * Erstelle neuen Eintrag
	 * 
	 * @param <T>
	 * @param entity
	 */
	public <T> void createEntity(T entity) {
		em.persist(entity);
	}

	/**
	 * Aktualisiere existierenden Eintrag
	 * 
	 * @param <T>
	 * @param entity
	 */
	public <T> void mergeEntity(T entity) {
		em.merge(entity);
	}
	
	/**
	 * Lösche existierenden Eintrag
	 * 
	 * @param <T>
	 * @param entity
	 */
	public <T> void deleteEntity(T entity) {
		em.remove(entity);
	}

	/**
	 * Lese einen Eintrag
	 * 
	 * @param <T>
	 * @param clss
	 * @param id
	 * @return
	 */
	public <T> T readEntity(Class<T> clss, Object id) {
		return em.find(clss, id);
	}

	/**
	 * Erstelle neuen Eintrag und gebe ihn zurück
	 * 
	 * @param <T>
	 * @param entity
	 */
	public <T> T createAndReturnEntity(T entity) {
		em.persist(entity);
		return entity;
	}

	/**
	 * Lies bestimmte Eintraege zu einer Entity-Klasse
	 * 
	 * @param <T>
	 * @param namedQuery
	 * @param paramName
	 * @param paramValue
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> queryEntities(String namedQuery, String paramName,
			Object paramValue) {
		Query query = em.createNamedQuery(namedQuery);
		query.setParameter(paramName, paramValue);
		return query.getResultList();
	}

	/**
	 * Lies alle Eintraege zu einer Entity-Klasse
	 * 
	 * @param <T>
	 * @param clss
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> List<T> readAllEntities(Class<T> clss) {
		return em.createQuery("Select d from " + clss.getSimpleName() + " d")
				.getResultList();
	}

}
