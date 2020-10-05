package it.cm.liferay.chat.registry.handler;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import it.cm.liferay.chat.registry.client.message.ReadTopicMessage;
import it.cm.liferay.chat.registry.session.UserSessionRegistryUtil;
import it.cm.liferay.chat.topic.service.MessageUserServiceUtil;

import javax.websocket.Session;

/**
 * @author Mauro Celani
 */
public class ReadTopicMessageHandler
	implements BaseHandler<ReadTopicMessage> {

	@Override
	public void handle(
		Session session, ReadTopicMessage message) {

		try {
			_log.debug("It's just arrived a new read topic message.");
			_log.trace(message);

			MessageUserServiceUtil.setReadTopic(
				message.getUserId(), message.getTopicId());

			UserSessionRegistryUtil.sendTopics(
				message.getUserId());
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ReadTopicMessageHandler.class);

}
