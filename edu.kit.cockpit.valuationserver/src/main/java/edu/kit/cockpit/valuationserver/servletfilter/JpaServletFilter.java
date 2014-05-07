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

package edu.kit.cockpit.valuationserver.servletfilter;

import java.io.IOException;
import javax.persistence.*;
import javax.servlet.*;

/**
 * Utility class providing EntityManagers & EntityTransactions for concurrent
 * servlet requests. Called by the container automatically in case of a request.
 * EntityManager available for servlet impl via static method.
 */
public class JpaServletFilter implements Filter {

	private static final ThreadLocal<EntityManager> entityManagerHolder = new ThreadLocal<EntityManager>();

	private EntityManagerFactory emf;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String meinJpaPuName = filterConfig.getServletContext()
				.getInitParameter("ValuationServerJpaPU");
		emf = Persistence.createEntityManagerFactory(meinJpaPuName);
	}

	@Override
	public void destroy() {
		emf.close();
		emf = null;
	}

	@Override
	public void doFilter(ServletRequest requ, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		entityManagerHolder.set(em);

		try {
			tx.begin();
			chain.doFilter(requ, resp);
			tx.commit();
		} finally {
			if (tx != null && tx.isActive())
				tx.rollback();
			em.close();
			entityManagerHolder.remove();
		}
	}

	public static EntityManager getEntityManager() {
		return entityManagerHolder.get();
	}
}