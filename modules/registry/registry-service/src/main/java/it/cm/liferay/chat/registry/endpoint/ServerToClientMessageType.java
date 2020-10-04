package it.cm.liferay.chat.registry.endpoint;

/**
 * @author Mauro Celani
 */
public enum ServerToClientMessageType {

	// USERS

	ACTIVE_USER("activeUser"),
	INACTIVE_USER("inactiveUser"),

	// MESSAGES

	NEW_MESSAGE("newMessage"),

	// TOPICS

	TOPICS("topics"),
	ADD_TOPIC("addTopic");

	ServerToClientMessageType(String jsonField) {
		_jsonField = jsonField;
	}

	private String _jsonField;

	public String getJsonField() {
		return _jsonField;
	}

	public static final String MSG_TYPE = "msgType";

}
