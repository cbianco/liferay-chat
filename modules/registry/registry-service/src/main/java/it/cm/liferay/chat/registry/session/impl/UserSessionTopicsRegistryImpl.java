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
import it.cm.liferay.chat.registry.client.message.ClientMessage;
import it.cm.liferay.chat.registry.endpoint.MessageType;
import it.cm.liferay.chat.registry.session.UserSession;
import it.cm.liferay.chat.registry.session.UserSession.UserStatus;
import it.cm.liferay.chat.registry.session.UserSessionRegistry;
import it.cm.liferay.chat.topic.model.Message;
import it.cm.liferay.chat.topic.model.Topic;
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
import java.util.concurrent.ConcurrentHashMap;
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
			_log.info("User (" + userId + ") made login and his session" +
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

		_log.info("Added user to session topic registry: " + userId);

		_sendTopics(socketSession, userId);
	}

	@Override
	public void addUserTopic(
		ClientMessage message) {

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
	public void notifyMessage(Message message) {

		try {
			Collection<Long> topicUserIds =
				_topicService.getTopic(message.getTopicId())
					.getUserIds();

			JSONObject messageJson = JSONFactoryUtil.createJSONObject(
				message.toJsonString());

			messageJson.put(
				MessageType.MSG_TYPE, MessageType.NEW_MESSAGE.name());

			_broadcast(messageJson, t -> topicUserIds.contains(t.getKey()));
		}
		catch (PortalException e) {
			_log.error(e, e);
		}

		updateLastActivityTime(message.getUserId());
	}

	private void _sendTopics(Session session, long userId) {

		Collection<Topic> topicsByUserId =
			_topicService.getTopicsByUserId(userId);

		JSONObject responseJSON = JSONFactoryUtil.createJSONObject();

		responseJSON.put(MessageType.MSG_TYPE, MessageType.TOPICS.name());

		JSONObject topicsJSON = JSONFactoryUtil.createJSONObject();

		for (Topic topic : topicsByUserId) {
			try {
				JSONObject topicJSON = JSONFactoryUtil.createJSONObject();

				long topicId = topic.getTopicId();
				topicJSON.put("topicId", topicId);

				Collection<Long> otherUserIds =
					_topicUserService.getUserIdsByTopicId(topicId);

				otherUserIds.remove(userId);

				JSONArray otherUsersJSON = JSONFactoryUtil.createJSONArray();

				for (long otherUserId : otherUserIds) {

					otherUsersJSON.put(
						_userSessionMap.getJSON(otherUserId));
				}

				topicJSON.put("otherUsers", otherUsersJSON);

				topicsJSON.put(Long.toString(topicId), topicJSON);
			}
				catch (PortalException e) {
				_log.error(e, e);
			}
		}

		responseJSON.put(MessageType.TOPICS.getJsonField(), topicsJSON);

		JSONObject onlineUsersJSON = JSONFactoryUtil.createJSONObject();

		for (UserSession userSession : _userSessionMap.values()) {

			onlineUsersJSON.put(
				Long.toString(userSession.getUserId()), userSession.toJSON());
		}

		responseJSON.put("onlineUsers", onlineUsersJSON);

		try {
			session.getBasicRemote().sendText(
				responseJSON.toJSONString());
		}
		catch (IOException e) {
			// TODO clearSession??
			_log.error(e, e);
		}
	}

	private void _notifyNewUserOthers(long userId) {
		_notifyUserOthers(MessageType.ACTIVE_USER, userId);
	}

	private void _notifyRemovedUserOthers(long userId) {
		_notifyUserOthers(MessageType.INACTIVE_USER, userId);
	}

	private void _notifyUserOthers(
		MessageType messageType, long userId) {

		if (_userSessionMap.containsKey(userId)) {

			JSONObject newUserJSON = JSONFactoryUtil.createJSONObject();
			newUserJSON.put(MessageType.MSG_TYPE, messageType.name());
			newUserJSON.put(
				messageType.getJsonField(),
				_userSessionMap.get(userId)
					.toJSON());

			_broadcast(newUserJSON, t -> t.getKey() != userId);
		}
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
		_userSessionMap.get(userId).updateLastActivityTime();
	}

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
