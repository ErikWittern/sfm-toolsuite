package edu.kit.cockpit.valuationserver.test.integration;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse.Status;

import edu.kit.cockpit.valuationserver.CVSrvContext;
import edu.kit.cockpit.valuationserver.rest.messages.Evaluation;
import edu.kit.cockpit.valuationserver.sfmpersistency.FileUtil;
import edu.kit.cockpit.valuationserver.test.ServiceTestBase;

public class DPIntegrationTest extends ServiceTestBase {

	private static final String DP_INTEGRATION_TEST_SKIPPED = "DPIntegrationTest skipped";
	private String model1;
	boolean skipIntegrationTest = true;

	@Before
	public void setUp() throws Exception {
		File testModelFile1 = new File(getClass().getClassLoader()
				.getResource(CVSrvContext.GR01_SFM_FILENAME).getFile());
		model1 = FileUtil.readFile(testModelFile1);
		CVSrvContext context = CVSrvContext.getInstance();
		skipIntegrationTest = context.getServerProps()
				.getProperty("skip.dp.interaction").equals("true");
	}

	@Test
	public void testPostPoll() throws IOException {
		Evaluation eval1 = postEvaluation(getEvalMsgDPI1());
		postModel(eval1.getEvaluationUrl(), model1);
		if (!skipIntegrationTest) {
			putEvaluation(eval1.getEvaluationUrl(), getEvalMsgDPI2());
		} else
			log.info(DP_INTEGRATION_TEST_SKIPPED);
		Status delState = deleteEvaluation(eval1.getEvaluationUrl());
		assertEquals(delState, Status.OK);
	}

	@Test
	public void testPutPoll() throws IOException {
		Evaluation eval1 = postEvaluation(getEvalMsgDPI1());
		postModel(eval1.getEvaluationUrl(), model1);
		if (!skipIntegrationTest) {
			putEvaluation(eval1.getEvaluationUrl(), getEvalMsgDPI2());
			putEvaluation(eval1.getEvaluationUrl(), getEvalMsgDPI3());
		} else
			log.info(DP_INTEGRATION_TEST_SKIPPED);
		Status delState = deleteEvaluation(eval1.getEvaluationUrl());
		assertEquals(delState, Status.OK);
	}

}
