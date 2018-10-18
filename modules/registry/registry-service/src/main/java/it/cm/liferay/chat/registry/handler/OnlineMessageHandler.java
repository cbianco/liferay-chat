package it.cm.liferay.chat.registry.handler;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import it.cm.liferay.chat.registry.client.message.ClientMessage;
import it.cm.liferay.chat.registry.client.message.OnlineMessage;
import it.cm.liferay.chat.registry.session.UserSessionRegistryUtil;

import javax.websocket.EncodeException;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import java.io.IOException;

/**
 * @author Mauro Celani
 */
public class OnlineMessageHandler implements BaseHandler<OnlineMessage> {

	@Override
	public void handle(
		Session session, OnlineMessage message) {

		_log.info("It's just arrived a new online message.");
		_log.trace(message);

		// Register himself session
		UserSessionRegistryUtil.addUserSession(
			message.getUserId(), message.isOnline(), session);

		// Send a message to other connected people
		UserSessionRegistryUtil.notifyOthers(message.getUserId());
	}

	private static final Log _log = LogFactoryUtil.getLog(
		OnlineMessageHandler.class);

}
