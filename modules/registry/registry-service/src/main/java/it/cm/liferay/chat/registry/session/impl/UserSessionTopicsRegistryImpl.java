package it.cm.liferay.chat.registry.session.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserConstants;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.Portal;
import it.cm.liferay.chat.registry.client.message.AddMessageMessage;
import it.cm.liferay.chat.registry.endpoint.ServerToClientMessageType;
import it.cm.liferay.chat.registry.session.UserSession;
import it.cm.liferay.chat.registry.session.UserSession.UserStatus;
import it.cm.liferay.chat.registry.session.UserSessionRegistry;
import it.cm.liferay.chat.topic.model.Message;
import it.cm.liferay.chat.topic.model.Topic;
import it.cm.liferay.chat.topic.service.MessageService;
import it.cm.liferay.chat.topic.service.MessageUserService;
import it.cm.liferay.chat.topic.service.TopicService;
import it.cm.liferay.chat.topic.service.TopicUserService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;

/**
 * @author Mauro Celani
 */
@Component(
	immediate = true,
	service = UserSessionRegistry.class
)
public class UserSessionTopicsRegistryImpl implements UserSessionRegistry {

	@Activate
	protected void activate(Map<String, Object> properties) {

		_userSessionMap = new UserSessionMap();
	}

	@Deactivate
	protected void deactivate(Map<String, Object> properties) {

		_userSessionMap.clear();
	}

		/**
		 * Manage multiple same user session (two browser tabs, desktop vs mobile)
		 * @param userId
		 * @param socketSession
		 */
	@Override
	public void addUserSession(
		long userId, Session socketSession) {

		if (!isOnline(userId)) {
			_log.debug("User (" + userId + ") made login and his session" +
					  " will be created");

			try {
				User user = _userLocalService.getUser(userId);

				String portraitUrl = UserConstants.getPortraitURL(
					_portal.getPathImage(), user.isMale(),
					user.getPortraitId(), user.getUserUuid());

				_userSessionMap.put(
					userId, new UserSession(
						userId, user.getFullName(), portraitUrl));
			}
			catch (PortalException e) {
				_log.error(e, e);
			}

			_notifyNewUserOthers(userId);
		}

		_userSessionMap.get(userId)
			.addSocketSession(socketSession);

		_log.debug("Added user to session topic registry: " + userId);

		sendTopics(userId);
	}

	@Override
	public void addUserTopic(
		AddMessageMessage message) {

		long userId = message.getUserId();
		long topicId = message.getTopicId();

		try {
			_log.info("Try to add user(" + userId + ")" +
					  " to topic registry: " + topicId);

			_userSessionMap.get(userId)
				.addTopic(_topicService.getTopic(topicId));
		}
		catch (PortalException e) {
			_log.error(e, e);
		}

	}

	@Override
	public UserSession clearUserSession(long userId) {

		_notifyRemovedUserOthers(userId);

		return _userSessionMap.remove(userId);
	}

	@Override
	public void clearSession(Session session) {

		for (long userId : _userSessionMap.keySet()) {

			UserSession userSession = _userSessionMap.get(userId);

			if (userSession.getSessions().contains(session)) {

				try {
					session.close();

					// CHECK IF IT IS THE LAST ONE
					if (userSession.getSessions().size() == 1) {
						clearUserSession(userId);
					}
					else {
						userSession.getSessions().remove(session);
					}
				}
				catch (IOException e) {
					_log.error(e, e);
				}

				break;
			}
		}

	}

	@Override
	public UserSession getUserSession(
		long userId) {

		return _userSessionMap.get(userId);
	}

	@Override
	public UserStatus getUserStatus(
		long userId) {

		if (isOnline(userId)) {
			return _userSessionMap.get(userId)
				.getStatus();
		}
		return UserStatus.OFFLINE;
	}

	@Override
	public Collection<Long> getOnlineUsers(
		long userId) {

		List<Long> userList = new LinkedList<>(_userSessionMap.keySet());

		userList.remove(userId);

		return userList;
	}

	/**
	 * Online or Inactive
	 * @param userId
	 * @return
	 */
	@Override
	public boolean isOnline(long userId) {
		return _userSessionMap.containsKey(userId);
	}

	@Override
	public void notifyMessageCreation(Message message) {

		try {
			Collection<Long> topicUserIds =
				_topicService.getTopic(message.getTopicId())
					.getUserIds();

			JSONObject messageJson = JSONFactoryUtil.createJSONObject(
				message.toJsonString());

			messageJson.put(
				ServerToClientMessageType.MSG_TYPE,
				ServerToClientMessageType.NEW_MESSAGE.name());

			_broadcast(messageJson, t -> topicUserIds.contains(t.getKey()));
		}
		catch (PortalException e) {
			_log.error(e, e);
		}

		updateLastActivityTime(message.getUserId());
	}

	@Override
	public void notifyTopicCreation(Topic topic) {

		try {
			JSONObject topicJson = JSONFactoryUtil.createJSONObject();

			topicJson.put(
				ServerToClientMessageType.MSG_TYPE,
				ServerToClientMessageType.ADD_TOPIC.name());

			topicJson.put(
				ServerToClientMessageType.ADD_TOPIC.getJsonField(),
				_getTopicJSON(topic, topic.getUserId()));

			_multicast(topicJson, topic.getUserIds());
		}
		catch (PortalException e) {
			_log.error(e, e);
		}

		updateLastActivityTime(topic.getUserId());
	}

	@Override
	public void sendTopics(long userId) {

		Collection<Topic> topicsByUserId =
			_topicService.getTopicsByUserId(userId);

		JSONObject responseJSON = JSONFactoryUtil.createJSONObject();

		responseJSON.put(
			ServerToClientMessageType.MSG_TYPE,
			ServerToClientMessageType.TOPICS.name());

		JSONObject topicsJSON = JSONFactoryUtil.createJSONObject();

		for (Topic topic : topicsByUserId) {
			try {
				topicsJSON.put(
					Long.toString(
						topic.getTopicId()), _getTopicJSON(topic, userId));
			}
			catch (PortalException e) {
				_log.error(e, e);
			}
		}

		responseJSON.put(
			ServerToClientMessageType.TOPICS.getJsonField(), topicsJSON);

		JSONObject onlineUsersJSON = JSONFactoryUtil.createJSONObject();

		for (UserSession userSession : _userSessionMap.values()) {

			onlineUsersJSON.put(
				Long.toString(userSession.getUserId()), userSession.toJSON());
		}

		responseJSON.put("onlineUsers", onlineUsersJSON);

		_unicast(responseJSON, userId);
	}

	private JSONObject _getTopicJSON(
			Topic topic, long userId)
		throws PortalException {

		JSONObject topicJSON = JSONFactoryUtil.createJSONObject();

		long topicId = topic.getTopicId();
		topicJSON.put("topicId", topicId);

		topicJSON.put(
			"messages", _messageService.getTopicMessages(userId, topicId));

		topicJSON.put(
			"unreads", _messageUserService.countUnreadTopicMessages(
				userId, topicId));

		Collection<Long> userIds =
			_topicUserService.getUserIdsByTopicId(topicId);

		JSONArray usersJSON = JSONFactoryUtil.createJSONArray();

		for (long userId2 : userIds) {

			usersJSON.put(
				_userSessionMap.getJSON(userId2));
		}

		topicJSON.put("users", usersJSON);

		return topicJSON;
	}

	private void _notifyNewUserOthers(long userId) {
		_notifyUserOthers(ServerToClientMessageType.ACTIVE_USER, userId);
	}

	private void _notifyRemovedUserOthers(long userId) {
		_notifyUserOthers(ServerToClientMessageType.INACTIVE_USER, userId);
	}

	private void _notifyUserOthers(
		ServerToClientMessageType messageType, long userId) {

		if (_userSessionMap.containsKey(userId)) {

			JSONObject newUserJSON = JSONFactoryUtil.createJSONObject();

			newUserJSON.put(
				ServerToClientMessageType.MSG_TYPE, messageType.name());

			newUserJSON.put(
				messageType.getJsonField(),
				_userSessionMap.get(userId)
					.toJSON());

			_broadcast(newUserJSON, t -> t.getKey() != userId);
		}
	}

	private void _unicast(
		JSONObject messageJSON, long userId) {

		_broadcast(messageJSON, t -> t.getKey().equals(userId));
	}

	private void _multicast(
		JSONObject messageJSON, Collection<Long> userIds) {

		_broadcast(messageJSON, t -> userIds.contains(t.getKey()));
	}

	private void _broadcast(
		JSONObject messageJSON,
		Predicate<? super Entry<Long, UserSession>> predicate) {

		_userSessionMap.entrySet()
			.stream()
			.filter(predicate)
			.flatMap(t -> t.getValue().getSessions().stream())
			.forEach(session -> {
				try {
					session.getBasicRemote().sendText(
						messageJSON.toJSONString()
					);
				}
				catch (IOException e) {
					// TODO clearSession??
					_log.error(e, e);
				}
			});
	}

	public void updateLastActivityTime(long userId) {

		UserSession userSession = _userSessionMap.get(userId);

		if (userSession != null) {
			userSession.updateLastActivityTime();
		}
	}

	@Reference
	private MessageService _messageService;

	@Reference
	private MessageUserService _messageUserService;

	@Reference
	private Portal _portal;

	@Reference
	private TopicService _topicService;

	@Reference
	private TopicUserService _topicUserService;

	@Reference
	private UserLocalService _userLocalService;

	private UserSessionMap _userSessionMap;

	private static final Log _log = LogFactoryUtil.getLog(
		UserSessionTopicsRegistryImpl.class);

}
