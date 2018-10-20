package it.cm.liferay.chat.registry.server.message;

import it.cm.liferay.chat.registry.common.BaseMessage;

public class NotifyMessage extends BaseMessage {

	private NotifyMessage(long userId) {
		this.userId = userId;
	}

	public static NotifyMessage of(long userId) {
		return new NotifyMessage(userId);
	}

	public long getUserId() {
		return userId;
	}

	private final long userId;

}
