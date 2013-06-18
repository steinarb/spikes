/**
 *
 */
package no.priv.bang.spikes.testdatagenerator;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONStyle;

/**
 * @author sbang
 *
 * Main entry point for a command line utility to generate test data to
 * pump into elasticsearch.
 *
 */
public class TestdataGeneratorMain {

	/**
	 * @param args the arguments given on the command line
	 */
	public static void main(String[] args) {
		TestdataGenerator generator = new TestdataGenerator();
		JSONArray measurements = generator.generateFakeMeasurements(6000);
		System.out.println(measurements.toJSONString(JSONStyle.NO_COMPRESS));
	}

}
