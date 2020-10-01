package it.cm.liferay.chat.registry.session;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import it.cm.liferay.chat.topic.model.Topic;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Mauro Celani
 */
public class UserSession {

	public enum UserStatus {
		ONLINE,
		OFFLINE,
		INACTIVE;

		// After five minutes the user will be considered inactive
		public static long INACTIVE_MILLIS = 1000 * 60 * 5;

	}

	private long _userId;
	private String _fullName;
	private String _portraitUrl;
	private long _lastActivityTime;
	private Set<Session> _sessions;
	private Set<Topic> _topics;

	public UserSession(long userId, String fullName, String portraitUrl) {
		_userId = userId;
		_fullName = fullName;
		_portraitUrl = portraitUrl;
		updateLastActivityTime();
		_sessions = new HashSet<>();
		_topics = new HashSet<>();
	}

	public void updateLastActivityTime() {
		_lastActivityTime = getTime();
	}

	public String getPortraitUrl() {
		return _portraitUrl;
	}

	public void addTopic(Topic topic) {
		_topics.add(topic);
		updateLastActivityTime();
	}

	public void addSocketSession(Session socketSession) {
		_sessions.add(socketSession);
		updateLastActivityTime();
	}

	public void closeSessions() {
		for (Session _session : _sessions) {
			try {
				_session.close();
			}
			catch (IOException e) {
				_log.error(e, e);
			}
		}
	}

	public long getTime() {
		// TODO Instant??
		return (new Date()).getTime();
	}

	public String getFullName() {
		return _fullName;
	}

	public long getUserId() {
		return _userId;
	}

	public Collection<Topic> getTopics() {
		return _topics;
	}

	public Collection<Session> getSessions() {
		return _sessions;
	}

	public UserStatus getStatus() {
		if (isOnline()) {
			return UserStatus.ONLINE;
		}
		return UserStatus.INACTIVE;
	}

	public boolean isOnline() {
		return _lastActivityTime - getTime() <= UserStatus.INACTIVE_MILLIS;
	}

	public JSONObject toJSON() {

		JSONObject retJSON = JSONFactoryUtil.createJSONObject();

		retJSON.put("userId", _userId);
		retJSON.put("fullName", _fullName);
		retJSON.put("isOnline", isOnline());
		retJSON.put("portraitUrl", _portraitUrl);
		retJSON.put("lastActivityTime", _lastActivityTime);

		return retJSON;
	}

	private static final Log _log = LogFactoryUtil.getLog(UserSession.class);

}
