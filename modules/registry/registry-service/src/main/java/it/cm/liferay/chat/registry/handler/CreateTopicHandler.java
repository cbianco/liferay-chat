package it.cm.liferay.chat.registry.handler;

import it.cm.liferay.chat.registry.client.message.CreateTopicMessage;
import it.cm.liferay.chat.registry.session.UserSessionRegistryUtil;

import javax.websocket.Session;

public class CreateTopicHandler implements BaseHandler<CreateTopicMessage> {

	@Override
	public void handle(Session session, CreateTopicMessage message) {

		try {

			final long topicId = UserSessionRegistryUtil.openTopic(
				message.getUserId(), message.getTargetUserId(),
				message.getCompanyid(), message.getGroupId()
			);

			session.getBasicRemote().sendText(
				"{\"topicId\" : \"" + topicId+ "\"}");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
