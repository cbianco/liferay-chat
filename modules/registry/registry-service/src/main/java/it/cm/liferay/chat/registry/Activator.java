package it.cm.liferay.chat.registry;

import it.cm.liferay.chat.registry.endpoint.ConversationRegistryEndpoint;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import javax.websocket.Endpoint;
import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;

/**
 * @author Mauro Celani
 */
public class Activator implements BundleActivator {

	@Override
	public void start(BundleContext context) throws Exception {
		Dictionary dictionary = new Hashtable();

		/*dictionary.put(
			"org.osgi.http.websocket.endpoint.encoders",
			Collections.singletonList(ClientMessageEncoder.class)
		);*/

		dictionary.put(
			"org.osgi.http.websocket.endpoint.decoders",
			Collections.emptyList()
		);

		dictionary.put(
			"org.osgi.http.websocket.endpoint.path",
			"/o/chat"
		);

		context.registerService(
			Endpoint.class, new ConversationRegistryEndpoint(), dictionary);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		// Do nothing because when the bundle stops all registered services
		// stops in the same way
	}

}
