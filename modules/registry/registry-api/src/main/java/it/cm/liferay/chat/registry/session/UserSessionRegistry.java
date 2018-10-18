package it.cm.liferay.chat.registry.session;

import it.cm.liferay.chat.registry.client.message.ClientMessage;

import javax.websocket.Session;
import java.util.Collection;

/**
 * @author Mauro Celani
 */
public interface UserSessionRegistry {

	public void addUserTopic(ClientMessage message);

	public void addUserSession(long userId, boolean online, Session session);

	public UserSession clearUserSession(long userId);

	public Collection<Long> getOnlineUsers(long userId);

	public void notifyOthers(long userId);

	public UserSession getUserSession(long userId);
}
