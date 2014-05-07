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

package edu.kit.cockpit.valuationserver.sfmpersistency;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.Service;
import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.ServicefeaturemodelPackage;

/**
 * Some more generic EMF functionality
 * 
 */
public class EMFUtil {

	private static Log log = LogFactory.getLog(EMFUtil.class);
	
	/**
	 * Loads SFM Model and returns it as an EMF Resource
	 * 
	 * @param modelFilename
	 * @param packageNamespace
	 * @param packageName
	 * @return model EMF resource
	 */
	public static Resource loadSFMModelToResource(String modelFilename,
			String packageNamespace, String packageName) throws IOException {

		if (modelFilename == null || packageName == null
				|| packageNamespace == null)
			return null;

		FileUtil.checkFileForReading(new File(modelFilename));

		// Create emf ResourceSet
		ResourceSet resourceSet = new ResourceSetImpl();

		// Specify Resource file extension/content
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
				.put("sfm", new XMIResourceFactoryImpl());

		// Create ServiceFeatureModelPackage
		ServicefeaturemodelPackage spackage = ServicefeaturemodelPackage.eINSTANCE;

		// Define package's namespace (provided by model)
		spackage.setNsURI(packageNamespace);

		// Set package name
		spackage.setName(packageName);

		// Specify EMF Resource and load SFM model from specified URI on server
		// filesystem
		Resource resource = resourceSet.getResource(
				URI.createFileURI(modelFilename), true);
		return resource;
	}

	/**
	 * @param resource
	 * @return sfm service object
	 */
	public static Service getService(Resource resource) {
		return (Service) resource.getContents().get(0);
	}
	
	/**
	 * @param rs
	 * @param encoding
	 */
	@SuppressWarnings("unchecked")
	public static void logModelFromResource(Resource rs, String encoding){
		@SuppressWarnings("rawtypes")
		Map options = new HashMap();
		//change as needed according to the type of resource
		//you are using
		options.put(XMIResource.OPTION_ENCODING, encoding);
		StringWriter sw = new StringWriter();
		URIConverter.WriteableOutputStream uws = new URIConverter.WriteableOutputStream(sw, encoding);
		try{
			rs.save(uws, options);
		}catch(IOException e){
			//TODO handle exception
		}
		String resourceString = sw.toString();
		log.info(resourceString);
	}
}
