package it.cm.liferay.chat.registry.endpoint;

/**
 * @author Mauro Celani
 */
public enum ClientToServerMessageType {

	// USERS

	ACTIVE_USER,

	// TOPIC

	ADD_TOPIC,
	READ_TOPIC,

	// MESSAGES

	ADD_MESSAGE;

	public static final String MSG_TYPE = "msgType";

}
