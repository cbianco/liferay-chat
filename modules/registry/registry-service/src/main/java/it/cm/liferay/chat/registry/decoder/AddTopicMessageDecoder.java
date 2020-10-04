package it.cm.liferay.chat.registry.decoder;

import it.cm.liferay.chat.registry.client.message.AddTopicMessage;
import it.cm.liferay.chat.registry.endpoint.ClientToServerMessageType;

/**
 * @author Mauro Celani
 */
public class AddTopicMessageDecoder
	extends BaseMessageDecoder<AddTopicMessage> {

	@Override
	public AddTopicMessage decode(String json) {
		return new AddTopicMessage(json);
	}

	@Override
	protected ClientToServerMessageType getMessageType() {
		return ClientToServerMessageType.ADD_TOPIC;
	}

}
