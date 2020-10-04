package it.cm.liferay.chat.registry.handler;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import it.cm.liferay.chat.registry.client.message.AddMessageMessage;
import it.cm.liferay.chat.topic.service.MessageServiceUtil;

import javax.websocket.Session;

/**
 * @author Mauro Celani
 */
public class AddMessageMessageHandler
	implements BaseHandler<AddMessageMessage> {

	@Override
	public void handle(
		Session session, AddMessageMessage message) {

		_log.debug("It's just arrived a new message.");
		_log.trace(message);

		try {
			MessageServiceUtil.addMessage(
				message.getUserId(),
				message.getTopicId(),
				message.getContent()
			);
		}
		catch (PortalException e) {
			_log.error(e, e);
			throw new RuntimeException(e);
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AddMessageMessageHandler.class);

}
