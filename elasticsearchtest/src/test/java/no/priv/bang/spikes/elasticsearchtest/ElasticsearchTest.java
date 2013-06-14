package no.priv.bang.spikes.elasticsearchtest;

import static org.junit.Assert.*;

import org.elasticsearch.client.Client;
import org.elasticsearch.node.Node;
import org.junit.Test;
import static org.elasticsearch.node.NodeBuilder.*;

public class ElasticsearchTest {

	@Test
	public void test() {
		// on startup
		Node node = nodeBuilder().node();
		Client client = node.client();

		// on shutdown
		node.close();	
	}
	
	@Test
	public void testNodeWithClusterName() {
		// on startup
		Node node = nodeBuilder().clusterName("myownclustername").node();
		Client client = node.client();

		// on shutdown
		node.close();	
	}

	@Test
	public void testClientOnly() {
		// on startup
		Node node = nodeBuilder().client(true).node();
		Client client = node.client();

		// on shutdown
		node.close();	
	}
	
	@Test
	public void testStartLocalNode() {
		// on startup
		Node node = nodeBuilder().local(true).node();
		Client client = node.client();

		// on shutdown
		node.close();	
	}
}
