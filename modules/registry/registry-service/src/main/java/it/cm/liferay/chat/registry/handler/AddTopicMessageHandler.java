package it.cm.liferay.chat.registry.handler;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import it.cm.liferay.chat.registry.client.message.AddTopicMessage;
import it.cm.liferay.chat.topic.service.TopicLocalServiceUtil;

import javax.websocket.Session;

/**
 * @author Mauro Celani
 */
public class AddTopicMessageHandler
	implements BaseHandler<AddTopicMessage> {

	@Override
	public void handle(
		Session session, AddTopicMessage message) {

		try {
			_log.info("It's just arrived a new add topic message.");
			_log.trace(message);

			TopicLocalServiceUtil.addTopic(
				message.getUserId1(), new long[]{ message.getUserId2() });
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AddTopicMessageHandler.class);

}
