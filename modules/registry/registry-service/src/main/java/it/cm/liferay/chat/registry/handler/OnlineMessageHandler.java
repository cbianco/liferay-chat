package it.cm.liferay.chat.registry.handler;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import it.cm.liferay.chat.registry.client.message.OnlineMessage;
import it.cm.liferay.chat.registry.session.UserSessionRegistryUtil;

import javax.websocket.Session;

/**
 * @author Mauro Celani
 */
public class OnlineMessageHandler implements BaseHandler<OnlineMessage> {

	@Override
	public void handle(
		Session session, OnlineMessage message) {

		try {
			_log.info("It's just arrived a new online message.");
			_log.trace(message);

			// Register himself session
			UserSessionRegistryUtil.addUserSession(
				message.getUserId(), session);
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		OnlineMessageHandler.class);

}
