package edu.kit.cockpit.valuationserver.test.performance;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.resource.Resource;
import org.junit.Test;

import edu.kit.cockpit.sfmdesigner.servicefeaturemodel.Service;
import edu.kit.cockpit.valuationserver.CVSrvContext;
import edu.kit.cockpit.valuationserver.entities.PreferenceE;
import edu.kit.cockpit.valuationserver.entities.SingleVoteE;
import edu.kit.cockpit.valuationserver.entities.VoteE;
import edu.kit.cockpit.valuationserver.sfmpersistency.EMFUtil;
import edu.kit.cockpit.valuationserver.valuation.AotearoaAdapter;
import edu.kit.cockpit.valuationserver.valuation.AotearoaAdapterNew;
import edu.kit.cockpit.valuationserver.valuation.SimpleAHPAdapter;

public class AHPPerformanceTest {

	static Log log = LogFactory.getLog(AHPPerformanceTest.class);
	
	@Test
	public void testComputeConfigurationPreferenceVector() {
		
		String folder = "performance/";
		ArrayList<String> modelList = new ArrayList<String>();
		
		// Define models:

//		modelList.add("Model3");		
		
//		modelList.add("GR01");
//		modelList.add("IRIS01");
//		modelList.add("Amazon_EC2");
		modelList.add("Rackspace");
		
//		modelList.add("Model1_20_Attributes");
//		modelList.add("Model2_20_Attributes");
//		modelList.add("Model3_20_Attributes");
//		modelList.add("Model4_20_Attributes");

//		modelList.add("Model3_2_Attribute_Types");
//		modelList.add("Model3_4_Attribute_Types");
//		modelList.add("Model3_6_Attribute_Types");
//		modelList.add("Model3_8_Attribute_Types");
//		modelList.add("Model3_10_Attribute_Types");
//		modelList.add("Model3_12_Attribute_Types");

//		modelList.add("Model2_2_Attribute_Types");
//		modelList.add("Model2_4_Attribute_Types");
//		modelList.add("Model2_6_Attribute_Types");
//		modelList.add("Model2_8_Attribute_Types");
//		modelList.add("Model2_10_Attribute_Types");
//		modelList.add("Model2_12_Attribute_Types");

		
		// Run evaluation:
		for(String modelName : modelList){
			// Get model:
			URL url = getClass().getClassLoader().getResource(folder + modelName + ".sfm");
			log.info("Loading test model file: " + url.getFile());
			
			Resource resource = null;
			try {
				resource = EMFUtil.loadSFMModelToResource(url.getFile(),
						CVSrvContext.SFM_NAMESPACE, CVSrvContext.SFM_PACKAGE);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Service service = EMFUtil.getService(resource);
			log.info("SFM service loaded: " + service.getName() + " : "
					+ service.getDescription());

			// Construct vote:
			VoteE vote = constructVote(service);
			log.info("Vote constructed with " + vote.getPreferences().size() + " preferences.");

			// Perform calculation:
			String result = performSimpleAHPCalculation(service, vote, modelName);

			// Write to log
			writeToLog(modelName, result);
		}
	}


	/**
	 * Performs the actual test using SimpleAHPAdapter
	 * 
	 * @param service
	 * @param vote
	 * @return
	 */
	protected String performSimpleAHPCalculation(Service service, VoteE vote, String modelName){
		String result = "";
		for(int i = 0; i < 1; i++){
			long startDate = System.currentTimeMillis();
			
			//AotearoaAdapter.computeConfigurationPreferenceVector(service, vote);
			//SimpleAHPAdapter.computeConfigurationPreferenceVector(service, vote);
			String tmpResult = AotearoaAdapterNew.getConfigurationRanking(service, vote);
			
			long duration = (System.currentTimeMillis() - startDate);
			result += tmpResult;
			System.out.print("Completed model \"" + modelName + "\", iteration: " + i 
					+ " in with result: " + tmpResult);
		}
		return result;
	}


	/**
	 * Construct a single vote with preferences matching the test model.
	 * The preference is randomly applied.
	 * 
	 * @return the vote
	 */
	protected static VoteE constructVote(Service service) {
		// Create vote:
		VoteE vote = new SingleVoteE();
		vote.setId((long) 123);
		vote.setLastUpdate(new Timestamp(new Date().getTime()));
		vote.setStakeholderGroup("Citizens");

		// Add preferences:
		for(int i = 0; i < service.getAttributeTypes().getAttributeTypes().size(); i++){
			for(int j = i+1; j < service.getAttributeTypes().getAttributeTypes().size(); j++){
				PreferenceE p = new PreferenceE();
				p.setId((long) 1);
				p.setLastUpdate(new Timestamp(new Date().getTime()));
				p.setAttributeTypeA(service.getAttributeTypes().getAttributeTypes().get(i).getName());
				p.setAttributeTypeB(service.getAttributeTypes().getAttributeTypes().get(j).getName());
				int pref = (int)(Math.random() * 9);
				log.info("Prefernce between " + p.getAttributeTypeA() + " and " + p.getAttributeTypeB() + " randomly set to: " + pref);
				p.setPreferenceAoverB(pref);
				vote.getPreferences().add(p);
			}
		}
		return vote;
	}


	/**
	 * Writes the given results to file in performance folder.
	 * 
	 * @param fileName
	 * @param result
	 */
	protected void writeToLog(String fileName, String result){
		try {

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
			Date date = new Date();
			
			File file = new File("target/test-classes/performance/" + dateFormat.format(date) + "_" + fileName + ".txt");
			log.info("Try to create file: " + file.getAbsolutePath());
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(result);
			bw.close();

			log.info("Results written to file: " + file.getAbsolutePath());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
