package it.cm.liferay.chat.registry.session;

import com.liferay.osgi.util.ServiceTrackerFactory;
import it.cm.liferay.chat.registry.client.message.ClientMessage;
import org.osgi.util.tracker.ServiceTracker;

import javax.websocket.Session;

/**
 * @author Mauro Celani
 */
public class UserSessionRegistryUtil {

	private UserSessionRegistry _userSessionRegistry;

	public static void addUserTopicSession(
		ClientMessage message, Session session) {

		getService().addUserTopicSession(message, session);
	}

	protected static UserSessionRegistry getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserSessionRegistry, UserSessionRegistry>
		_serviceTracker = ServiceTrackerFactory.open(
			UserSessionRegistry.class);
}
