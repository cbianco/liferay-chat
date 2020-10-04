package it.cm.liferay.chat.registry.decoder;

import it.cm.liferay.chat.registry.client.message.ActiveUserMessage;
import it.cm.liferay.chat.registry.endpoint.ClientToServerMessageType;

/**
 * @author Mauro Celani
 */
public class ActiveUserMessageDecoder
	extends BaseMessageDecoder<ActiveUserMessage> {

	@Override
	public ActiveUserMessage decode(String json) {
		return new ActiveUserMessage(json);
	}

	@Override
	protected ClientToServerMessageType getMessageType() {
		return ClientToServerMessageType.ACTIVE_USER;
	}

}
