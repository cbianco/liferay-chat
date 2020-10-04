package it.cm.liferay.chat.registry.endpoint;

/**
 * @author Mauro Celani
 */
public enum ClientToServerMessageType {

	// USERS

	ACTIVE_USER,
	ADD_TOPIC,

	// MESSAGES

	ADD_MESSAGE;

	public static final String MSG_TYPE = "msgType";

}
