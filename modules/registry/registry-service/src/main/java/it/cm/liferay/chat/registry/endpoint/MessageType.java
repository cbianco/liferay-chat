package it.cm.liferay.chat.registry.endpoint;

/**
 * @author Mauro Celani
 */
public enum MessageType {

	NEW_USER("newUser"),
	REMOVE_USER("removeUser"),
	OTHERS("others");

	MessageType(String jsonField) {
		_jsonField = jsonField;
	}

	private String _jsonField;

	public String getJsonField() {
		return _jsonField;
	}

	public static final String MSG_TYPE = "msgType";

}
