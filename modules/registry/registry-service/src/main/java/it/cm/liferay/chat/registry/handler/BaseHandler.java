package it.cm.liferay.chat.registry.handler;

import it.cm.liferay.chat.registry.client.message.BaseMessage;

import javax.websocket.Session;

/**
 * @author Mauro Celani
 */
public interface BaseHandler<T extends BaseMessage> {

	public void handle(Session session, T t);

}
