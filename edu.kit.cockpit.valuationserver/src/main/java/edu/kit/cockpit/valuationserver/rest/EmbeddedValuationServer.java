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

package edu.kit.cockpit.valuationserver.rest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sun.grizzly.http.embed.GrizzlyWebServer;
import com.sun.grizzly.http.servlet.ServletAdapter;
import com.sun.jersey.spi.container.servlet.ServletContainer;

import edu.kit.cockpit.valuationserver.CVSrvContext;
import edu.kit.cockpit.valuationserver.servletfilter.JpaServletFilter;

public class EmbeddedValuationServer {

	private Log log = LogFactory.getLog(EmbeddedValuationServer.class);

	private GrizzlyWebServer ws;

	private EmbeddedValuationServer() {
	}

	private static class SingletonInstanceHolder {
		static final EmbeddedValuationServer INSTANCE = new EmbeddedValuationServer();
	}

	public static EmbeddedValuationServer getInstance() {
		return SingletonInstanceHolder.INSTANCE;
	}

	public void start() throws Exception {

		// grizzly easy way
		// srv = GrizzlyServerFactory.create(url);

		// grizzly with jpa servlet filter
		ws = new GrizzlyWebServer(8080);
		ServletAdapter jerseyServletAdapter = new ServletAdapter();
		jerseyServletAdapter.setServletInstance(new ServletContainer());
		jerseyServletAdapter.addInitParameter(
				"com.sun.jersey.config.property.packages",
				"edu.kit.cockpit.valuationserver.rest.services");
		jerseyServletAdapter.setServletPath("/" + CVSrvContext.VALUATION_SERVER_CONTEXT);
		jerseyServletAdapter.addFilter(new JpaServletFilter(),
				"JpaServletFilter", null);
		ws.addGrizzlyAdapter(jerseyServletAdapter, null);
		ws.start();

		log.info("Enbedded valuation server started");
	}

	public void stop() {
		ws.stop();
		log.info("Enbedded valuation server stopped");
	}
}
