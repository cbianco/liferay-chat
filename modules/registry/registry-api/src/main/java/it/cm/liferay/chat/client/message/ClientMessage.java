package it.cm.liferay.chat.client.message;

/**
 * @author Mauro Celani
 */
public class ClientMessage {

	private long _userId;
	private long _topicId;
	private String _content;

	public ClientMessage(String json) {
		// TODO Decode JSON
	}

	@Override
	public String toString() {
		return "\nFrom: " + _userId +
			   "\nTo: " + _topicId +
			   "\nContent: " + _content;
	}

	public long getUserId() {
		return _userId;
	}

	public String getContent() {
		return _content;
	}

	public long getTopicId() {
		return _topicId;
	}

}
