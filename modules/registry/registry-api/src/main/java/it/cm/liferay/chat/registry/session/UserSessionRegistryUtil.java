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
		long userId, Session socketSession) {

		getService().addUserSession(userId, socketSession);
	}

	public static void addUserTopicSession(
		ClientMessage message) {

		getService().addUserTopic(message);
	}

	public static UserSession clearUserSession(long userId) {
		return getService().clearUserSession(userId);
	}
	public static void clearSession(Session session) {
		getService().clearSession(session);
	}

	public static Collection<Long> getOnlineUsers(long userId) {
		return getService().getOnlineUsers(userId);
	}

	public static void updateLastActivityTime(long userId) {
		getService().updateLastActivityTime(userId);
	}

	protected static UserSessionRegistry getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<UserSessionRegistry, UserSessionRegistry>
		_serviceTracker = ServiceTrackerFactory.open(
			UserSessionRegistry.class);

}
