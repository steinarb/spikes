package no.priv.bang.spikes.testdatagenerator;

import java.sql.Timestamp;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

public class TestdataGenerator {

	public JSONArray generateFakeMeasurements(int arraySize) {
		JSONArray retval = new JSONArray();
		for (int i=0; i<arraySize; ++i) {
			JSONObject measurement = generateRandomMeasurement();
			retval.add(measurement);
		}
		return retval;
	}

	private JSONObject generateRandomMeasurement() {
		JSONObject measurement = new JSONObject();
		measurement.put("sensorID", 100);
		JSONObject registration = new JSONObject();
		registration.put("time", new Timestamp(System.currentTimeMillis()));
		registration.put("laneID", 4);
		registration.put("speed", 92);
		registration.put("length", 3.96);
		registration.put("gap", 434.44);
		measurement.put("registration", registration);
		return measurement;
	}

}
