package it.cm.liferay.chat.registry.session;

import it.cm.liferay.chat.registry.client.message.AddMessageMessage;
import it.cm.liferay.chat.registry.session.UserSession.UserStatus;
import it.cm.liferay.chat.topic.model.Message;
import it.cm.liferay.chat.topic.model.Topic;

import javax.websocket.Session;
import java.util.Collection;

/**
 * @author Mauro Celani
 */
public interface UserSessionRegistry {

	public void addUserTopic(AddMessageMessage message);

	public void addUserSession(long userId, Session socketSession);

	public UserSession clearUserSession(long userId);

	public void clearSession(Session session);

	public Collection<Long> getOnlineUsers(long userId);

	public UserSession getUserSession(long userId);

	public UserStatus getUserStatus(long userId);

	public boolean isOnline(long userId);

	public void notifyMessage(Message message);

	public void updateLastActivityTime(long userId);

	public void notifyTopic(Topic topic);

}
