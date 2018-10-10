package it.cm.liferay.chat.registry.session.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import it.cm.liferay.chat.client.message.ClientMessage;
import it.cm.liferay.chat.registry.session.UserSession;
import it.cm.liferay.chat.registry.session.UserSessionRegistry;
import it.cm.liferay.chat.topic.model.Topic;
import it.cm.liferay.chat.topic.service.TopicService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.websocket.Session;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Mauro Celani
 */
@Component(
	immediate = true,
	service = UserSessionRegistry.class
)
public class UserSessionTopicsRegistryImpl implements UserSessionRegistry {

	private Map<UserSession, List<Topic>> _userSessionTopicsMap =
		new ConcurrentHashMap<>();

	@Override
	public void addUserTopicSession(
		ClientMessage message, Session session) {

		UserSession userSession = new UserSession(message.getUserId(), session);

		long topicId = message.getTopicId();

		if (!_userSessionTopicsMap.containsKey(userSession)) {

			_userSessionTopicsMap.put(
				userSession,
				new LinkedList<>());
		}

		try {
			_userSessionTopicsMap.get(userSession)
				.add(_topicService.getTopic(topicId));
		}
		catch (PortalException e) {
			_log.error(e, e);
		}

	}

	@Reference
	private TopicService _topicService;

	private static final Log _log = LogFactoryUtil.getLog(
		UserSessionTopicsRegistryImpl.class);

}
