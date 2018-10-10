package it.cm.liferay.chat.registry.session;

import javax.websocket.Session;

/**
 * @author Mauro Celani
 */
public class UserSession {

	private long _userId;
	private Session _session;

	public UserSession(long userId, Session session) {
		_userId = userId;
		_session = session;
	}

	public long getUserId() {
		return _userId;
	}

	public Session getSession() {
		return _session;
	}

}
