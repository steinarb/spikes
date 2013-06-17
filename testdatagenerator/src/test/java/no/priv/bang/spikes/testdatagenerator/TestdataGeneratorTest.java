package no.priv.bang.spikes.testdatagenerator;

import static org.junit.Assert.*;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

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

}
