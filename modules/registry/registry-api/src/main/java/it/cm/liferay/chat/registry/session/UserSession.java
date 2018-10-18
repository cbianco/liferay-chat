package it.cm.liferay.chat.registry.session;

import it.cm.liferay.chat.topic.model.Topic;

import javax.websocket.Session;
import java.util.List;

/**
 * @author Mauro Celani
 */
public class UserSession {

	private long _userId;
	private Session _session;
	private List<Topic> _topics;

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

	public List<Topic> getTopics() {
		return _topics;
	}

	public void addTopic(Topic topic) {
		_topics.add(topic);
	}

}
