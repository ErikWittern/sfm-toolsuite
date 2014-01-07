package edu.kit.sfm.configuration_set_determination.controller;

import java.util.List;

import choco.cp.model.CPModel;
import choco.cp.solver.CPSolver;
import choco.kernel.solver.Configuration;
import choco.kernel.solver.Solver;
import edu.kit.sfm.servicefeaturemodel.Service;
import edu.kit.sfm.utils.TimeTracker;

public class ConfigurationSetDeterminator {
	public int getConfigurations(Service service){
		
		System.out.println("");
		System.out.println("Java SFM Analyzer");
		System.out.println("-----------------");
		
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
		System.out.println("SFM to CSP completed.");
		
		/**
		 * 3. Solve
		 */
		s.read(m);
		s.solveAll();
		
		ttracker.markTime("CSP Solving");
		System.out.println("CSP solving completed.");
		
		System.out.println("Solving CSP:");
		System.out.println("	Processing time: " +s.getTimeCount());
		System.out.println("	Number of Variables: " +s.getNbIntVars());
		System.out.println("	Number of Solutions: " +s.getNbSolutions());
		
		
		/**
		 * 4. Create Configurations:
		 */
		ConfigurationBuilder confB = new ConfigurationBuilder();
		List<edu.kit.sfm.servicefeaturemodel.Configuration> confList = confB.getConfigurations(service, s);
		
		ttracker.markTime("Creating Configurations");
		System.out.println("Configurations completed.");
		
		
		/**
		 * 5. Add configurations and save:
		 */
		service.getConfigurations().getConfigurations().clear();
		service.getConfigurations().getConfigurations().addAll(confList);
		
		System.out.println(ttracker.toStringInterpreted());
		
		return s.getNbSolutions();
	}	
}
