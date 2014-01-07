package edu.kit.sfm.utils;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;

import edu.kit.sfm.servicefeaturemodel.Configuration;
import edu.kit.sfm.servicefeaturemodel.Service;

public class SFMConfigurationsOperations {

	private static void deleteConfigurationFromModel(Service serviceModel,
			Configuration configurationToDelete) {

		// delete configuration from emf model
		serviceModel.getConfigurations().getConfigurations()
				.remove(configurationToDelete);

	}

	public static Integer deleteConfigurations(Service serviceModel,
			List<Configuration> configurationsNotMatchingReq) {

		/* initialize */
		Integer deletedConfigurations = 0;

		// get configurations from service model
		List<Configuration> serviceModelConfigurations = serviceModel
				.getConfigurations().getConfigurations();

		/* delete & modify model */
		// iterate through all configurations of service model and delete
		// configurations not matching req
		for (Configuration conf : configurationsNotMatchingReq) {

			boolean match = false;
			Iterator<Configuration> confListIterator = serviceModelConfigurations
					.iterator();

			while (!match && confListIterator.hasNext()) {
				Configuration selectedConf = confListIterator.next();

				if (conf.getId().equals(selectedConf.getId())) {

					deleteConfigurationFromModel(serviceModel, selectedConf);

					match = true;
					deletedConfigurations += 1;
				}

			}

		}

		/* save results */

		Resource resource = serviceModel.eResource();
		SFMPersistencyOperations.saveModel(resource);

		return deletedConfigurations;

	}

	public static Integer getNumberOfConfigurations(String modelName) {
		// local variable
		@SuppressWarnings("unused")
		Integer numberOfConfigurations;

		// Get service model:
		Service serviceModel = SFMPersistencyOperations.loadModel(modelName);

		// get number of configurations
		return numberOfConfigurations = serviceModel.getConfigurations()
				.getConfigurations().size();
	}

	public static boolean emptyConfigurations(String modelName) {

		Integer numberOfConfigurations = getNumberOfConfigurations(modelName);

		// not empty
		if (numberOfConfigurations != 0) {
			return false;
			// empty
		} else {
			return true;
		}

	}
}
