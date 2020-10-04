package it.cm.liferay.chat.registry.decoder;

import it.cm.liferay.chat.registry.client.message.AddMessageMessage;
import it.cm.liferay.chat.registry.endpoint.ClientToServerMessageType;

/**
 * @author Mauro Celani
 */
public class AddMessageMessageDecoder
	extends BaseMessageDecoder<AddMessageMessage> {

	@Override
	public AddMessageMessage decode(String json) {
		return new AddMessageMessage(json);
	}

	@Override
	protected ClientToServerMessageType getMessageType() {
		return ClientToServerMessageType.ADD_MESSAGE;
	}

}
