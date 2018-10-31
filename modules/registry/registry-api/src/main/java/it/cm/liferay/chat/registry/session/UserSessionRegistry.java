package it.cm.liferay.chat.registry.session;

import it.cm.liferay.chat.registry.client.message.ClientMessage;
import it.cm.liferay.chat.registry.session.UserSession.UserStatus;

import javax.websocket.Session;
import java.util.Collection;

/**
 * @author Mauro Celani
 */
public interface UserSessionRegistry {

	public void addUserTopic(ClientMessage message);

	public void addUserSession(long userId, Session socketSession);

	public UserSession clearUserSession(long userId);

	public void clearSession(Session session);

	public Collection<Long> getOnlineUsers(long userId);

	public UserSession getUserSession(long userId);

	public UserStatus getUserStatus(long userId);

	public boolean isOnline(long userId);

	public void updateLastActivityTime(long userId);

}
