package no.priv.bang.spikes.testdatagenerator;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;
import static org.junit.Assert.*;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import org.junit.Test;

public class TestdataGeneratorTest {

	@Test
	public void generateFakeMeasurements() {
		TestdataGenerator generator = new TestdataGenerator();
		JSONArray measurements = generator.generateFakeMeasurements(6000);
		assertEquals(6000, measurements.size());
		JSONObject measurement = (JSONObject) measurements.get(0);
		assertNotNull(measurement.get("sensorID"));
	}

	@Test
	public void populateElasticsearch() {
		TestdataGenerator generator = new TestdataGenerator();
		JSONArray measurements = generator.generateFakeMeasurements(6000);

		// Node startup
		Node node = nodeBuilder().node();
		Client client = node.client();

		// Feed the data.
		for (Object rawObject : measurements) {
			JSONObject measurement = (JSONObject) rawObject;
			String measurementInJSON = measurement.toJSONString();
			IndexResponse response = client.prepareIndex("measurements", "measurement", "1").setSource(measurementInJSON).execute().actionGet();
			System.out.println(response.toString());
		}

		// Node shutdown
		node.close();
	}
}
