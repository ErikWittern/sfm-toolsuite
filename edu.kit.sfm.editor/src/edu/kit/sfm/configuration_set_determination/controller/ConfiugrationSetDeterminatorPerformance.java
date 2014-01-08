package edu.kit.sfm.configuration_set_determination.controller;

import java.util.List;

import choco.cp.model.CPModel;
import choco.cp.solver.CPSolver;
import choco.kernel.solver.Configuration;
import choco.kernel.solver.Solver;
import edu.kit.sfm.servicefeaturemodel.Service;
import edu.kit.sfm.utils.TimeTracker;


public class ConfiugrationSetDeterminatorPerformance {
		
	public TimeTracker getConfigurations(Service service){

		
		TimeTracker ttracker = new TimeTracker();
		ttracker.start();
		
		/**
		 * 1. Set up the solver
		 */
		Solver s = new CPSolver();
		int size = Integer.MAX_VALUE;
		s.getConfiguration().putInt(Configuration.SOLUTION_POOL_CAPACITY, size); // otherwise, not all solutions will be stored
		
		/**
		 * 2. Get the model
		 */
		SFMToCSPMapper mapper = new SFMToCSPMapper();
		CPModel m = mapper.getCSPforSFM(service);
		ttracker.markTime("SFM to CSP");
		
		/**
		 * 3. Solve
		 */
		s.read(m);
		s.solveAll();
		
		ttracker.markTime("CSP Solving");
		
		
		/**
		 * 4. Create Configurations:
		 */
		ConfigurationBuilder confB = new ConfigurationBuilder();
//		ThreadedConfigurationBuilder confB = new ThreadedConfigurationBuilder();
		List<edu.kit.sfm.servicefeaturemodel.Configuration> confList = confB.getConfigurations(service, s);
		
		ttracker.markTime("Creating Configurations");
		
		
		/**
		 * 5. Add configurations and save:
		 */
		service.getConfigurations().getConfigurations().clear();
		service.getConfigurations().getConfigurations().addAll(confList);
				
		return ttracker;
	}	

}
