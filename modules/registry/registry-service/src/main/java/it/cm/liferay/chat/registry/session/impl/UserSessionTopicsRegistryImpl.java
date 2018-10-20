package it.cm.liferay.chat.registry.session.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import it.cm.liferay.chat.registry.client.message.ClientMessage;
import it.cm.liferay.chat.registry.server.message.NotifyMessage;
import it.cm.liferay.chat.registry.server.message.ServerMessage;
import it.cm.liferay.chat.registry.session.UserSession;
import it.cm.liferay.chat.registry.session.UserSessionRegistry;
import it.cm.liferay.chat.topic.model.Topic;
import it.cm.liferay.chat.topic.service.TopicService;
import it.cm.liferay.chat.topic.service.TopicUserService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author Mauro Celani
 */
@Component(
	immediate = true,
	service = UserSessionRegistry.class
)
public class UserSessionTopicsRegistryImpl implements UserSessionRegistry {

	private Map<Long, UserSession> _userSessionTopicsMap =
		new ConcurrentHashMap<>();

	@Override
	public void addUserSession(
		long userId, boolean online, Session session) {

		// TODO manage online/offline flag
		// TODO manage multiple same user session (two browser tabs, desktop vs mobile)

		if (!_userSessionTopicsMap.containsKey(userId)) {

			_log.info("Added user to session topic registry: " + userId);

			_userSessionTopicsMap.put(
				userId, new UserSession(userId, session));
		}
	}

	@Override
	public void addUserTopic(ClientMessage message) {

		addUserTopic(message.getUserId(), message.getTopicId());
	}

	public void addUserTopic(long userId, long topicId) {

		try {
			_log.info("Try to add user(" + userId + ")" +
				" to topic registry: " + topicId);


			_userSessionTopicsMap.get(userId)
				.addTopic(_topicService.getTopic(topicId));

			_topicUserService.addTopicUser(topicId, userId);

		}
		catch (PortalException e) {
			_log.error(e, e);
		}

	}

	@Override
	public long openTopic(
			long currentUserId, long targetUserId, long companyId, long groupId)
		throws PortalException {

		final List<Map.Entry<Long, UserSession>> collect =
			_userSessionTopicsMap.entrySet()
				.stream()
				.filter(t2 ->
					t2.getKey() == currentUserId || t2.getKey() == targetUserId)
				.collect(Collectors.toList());

		if(collect.size() == 2) {
			Topic topic =  _topicService.addTopic(
				companyId, groupId, currentUserId);

			collect.forEach(
				lus -> this.addUserTopic(lus.getKey(), topic.getTopicId()));

			System.out.println("ciao " + topic);

			return topic.getTopicId();

		}

		return 0;
	}

	@Override
	public UserSession clearUserSession(long userId) {
		return _userSessionTopicsMap.remove(userId);
	}

	@Override
	public UserSession getUserSession(
		long userId) {

		return _userSessionTopicsMap.get(userId);
	}

	@Override
	public Collection<Long> getOnlineUsers(
		long userId) {

		List<Long> userList = new LinkedList<>(_userSessionTopicsMap.keySet());

		userList.remove(userId);

		return userList;
	}

	@Override
	public void notifyOthers(long userId) {
		_userSessionTopicsMap.entrySet()
			.stream()
			.filter(t -> t.getKey() != userId)
			.map(t -> t.getValue().getSession())
			.forEach(s -> notify(s, userId));
	}

	private void notify(Session session, long userId) {

		try {

			RemoteEndpoint.Basic basicRemote = session.getBasicRemote();

			basicRemote.sendText(NotifyMessage.of(userId).toJson());
		}
		catch (Exception e) {
			_log.error(e, e);
		}

	}

	@Reference
	private TopicService _topicService;

	@Reference
	private TopicUserService _topicUserService;

	private static final Log _log = LogFactoryUtil.getLog(
		UserSessionTopicsRegistryImpl.class);

}
