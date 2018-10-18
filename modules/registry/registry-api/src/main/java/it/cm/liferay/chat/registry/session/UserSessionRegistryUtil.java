package it.cm.liferay.chat.registry.session;

import com.liferay.osgi.util.ServiceTrackerFactory;
import it.cm.liferay.chat.registry.client.message.ClientMessage;
import org.osgi.util.tracker.ServiceTracker;

import javax.websocket.Session;
import java.util.Collection;

/**
 * @author Mauro Celani
 */
public class UserSessionRegistryUtil {

	private UserSessionRegistry _userSessionRegistry;

	public static void addUserSession(
		long userId, boolean online, Session session) {

		getService().addUserSession(userId, online, session);
	}

	public static void addUserTopicSession(
		ClientMessage message) {

		getService().addUserTopic(message);
	}


	public static Collection<Long> getOnlineUsers(long userId) {

		return getService().getOnlineUsers(userId);
	}

	public static UserSession clearUserSession(long userId) {
		return getService().clearUserSession(userId);
	}

	public static void notifyOthers(long userId) {
		getService().notifyOthers(userId);
	}

	protected static UserSessionRegistry getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserSessionRegistry, UserSessionRegistry>
		_serviceTracker = ServiceTrackerFactory.open(
			UserSessionRegistry.class);

}
