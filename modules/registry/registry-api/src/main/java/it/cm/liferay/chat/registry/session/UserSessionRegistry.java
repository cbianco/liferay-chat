package it.cm.liferay.chat.registry.session;

import it.cm.liferay.chat.registry.client.message.ClientMessage;

import javax.websocket.Session;

/**
 * @author Mauro Celani
 */
public interface UserSessionRegistry {

	public void addUserTopicSession(ClientMessage message, Session session);

}
