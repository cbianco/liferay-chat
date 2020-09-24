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
import it.cm.liferay.chat.topic.service.TopicService;
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
import java.util.Set;
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

	@Activate
	protected void activate(Map<String, Object> properties) {

		_userSessionTopicsMap = new ConcurrentHashMap<>();
	}

	@Deactivate
	protected void deactivate(Map<String, Object> properties) {

		_userSessionTopicsMap.clear();
		_userSessionTopicsMap = null;
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

				_userSessionTopicsMap.put(
					userId, new UserSession(
						userId, user.getFullName(), portraitUrl));
			}
			catch (PortalException e) {
				_log.error(e, e);
			}

			_notifyNewUserOthers(userId);
		}

		_userSessionTopicsMap.get(userId)
			.addSocketSession(socketSession);

		_log.info("Added user to session topic registry: " + userId);

		_getOthers(socketSession, userId);
	}

	@Override
	public void addUserTopic(
		ClientMessage message) {

		long userId = message.getUserId();
		long topicId = message.getTopicId();

		try {
			_log.info("Try to add user(" + userId + ")" +
					  " to topic registry: " + topicId);

			_userSessionTopicsMap.get(userId)
				.addTopic(_topicService.getTopic(topicId));
		}
		catch (PortalException e) {
			_log.error(e, e);
		}

	}

	@Override
	public UserSession clearUserSession(long userId) {

		_notifyRemovedUserOthers(userId);

		return _userSessionTopicsMap.remove(userId);
	}

	@Override
	public void clearSession(Session session) {

		for (long userId : _userSessionTopicsMap.keySet()) {

			UserSession userSession = _userSessionTopicsMap.get(userId);

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

		return _userSessionTopicsMap.get(userId);
	}

	@Override
	public UserStatus getUserStatus(
		long userId) {

		if (isOnline(userId)) {
			return _userSessionTopicsMap.get(userId)
				.getStatus();
		}
		return UserStatus.OFFLINE;
	}

	@Override
	public Collection<Long> getOnlineUsers(
		long userId) {

		List<Long> userList = new LinkedList<>(_userSessionTopicsMap.keySet());

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
		return _userSessionTopicsMap.containsKey(userId);
	}

	private void _getOthers(Session session, long userId) {

		Set<UserSession> others =
			_userSessionTopicsMap.entrySet()
				.stream()
				.filter(t -> t.getKey() != userId)
				.map(t -> t.getValue())
				.collect(Collectors.toSet());

		JSONObject othersJSON = JSONFactoryUtil.createJSONObject();

		othersJSON.put(MessageType.MSG_TYPE, MessageType.OTHERS.name());

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for (UserSession other : others) {
			jsonArray.put(other.toJSON());
		}

		othersJSON.put(MessageType.OTHERS.getJsonField(), jsonArray);

		try {
			session.getBasicRemote().sendText(
				othersJSON.toJSONString());
		}
		catch (IOException e) {
			// TODO clearSession??
			_log.error(e, e);
		}
	}

	private void _notifyNewUserOthers(long userId) {
		_notifyUserOthers(MessageType.NEW_USER, userId);
	}

	private void _notifyRemovedUserOthers(long userId) {
		_notifyUserOthers(MessageType.REMOVE_USER, userId);
	}

	private void _notifyUserOthers(MessageType messageType, long userId) {

		JSONObject newUserJSON = JSONFactoryUtil.createJSONObject();
		newUserJSON.put(MessageType.MSG_TYPE, messageType.name());
		newUserJSON.put(
			messageType.getJsonField(),
			_userSessionTopicsMap.get(userId)
				.toJSON());

		_userSessionTopicsMap.entrySet()
			.stream()
			.filter(t -> t.getKey() != userId)
			.flatMap(t -> t.getValue().getSessions().stream())
			.forEach(session -> {
				try {
					session.getBasicRemote().sendText(
						newUserJSON.toJSONString()
					);
				}
				catch (IOException e) {
					// TODO clearSession??
					_log.error(e, e);
				}
			});
	}

	public void updateLastActivityTime(long userId) {
		_userSessionTopicsMap.get(userId).updateLastActivityTime();
	}

	@Reference
	private Portal _portal;

	@Reference
	private TopicService _topicService;

	@Reference
	private UserLocalService _userLocalService;

	private Map<Long, UserSession> _userSessionTopicsMap;

	private static final Log _log = LogFactoryUtil.getLog(
		UserSessionTopicsRegistryImpl.class);

}
