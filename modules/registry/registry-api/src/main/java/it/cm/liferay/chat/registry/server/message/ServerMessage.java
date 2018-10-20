package it.cm.liferay.chat.registry.server.message;

import it.cm.liferay.chat.registry.common.BaseMessage;

import java.util.HashMap;
import java.util.Map;

public class ServerMessage extends BaseMessage {

	public ServerMessage add(String key, Object value) {
		props.put(key, value);
		return this;
	}

	public static ServerMessage of(String key, Object value) {
		return new ServerMessage().add(key, value);
	}

	private Map<String, Object> props = new HashMap<>();

}
