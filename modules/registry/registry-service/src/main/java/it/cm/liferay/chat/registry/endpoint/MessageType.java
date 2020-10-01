package it.cm.liferay.chat.registry.endpoint;

/**
 * @author Mauro Celani
 */
public enum MessageType {

	// USERS

	ACTIVE_USER("activeUser"),
	INACTIVE_USER("inactiveUser"),
	TOPICS("topics"),

	// MESSAGES

	NEW_MESSAGE("newMessage");

	MessageType(String jsonField) {
		_jsonField = jsonField;
	}

	private String _jsonField;

	public String getJsonField() {
		return _jsonField;
	}

	public static final String MSG_TYPE = "msgType";

}
