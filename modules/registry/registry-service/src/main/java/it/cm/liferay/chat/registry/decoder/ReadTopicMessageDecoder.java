package it.cm.liferay.chat.registry.decoder;

import it.cm.liferay.chat.registry.client.message.ReadTopicMessage;
import it.cm.liferay.chat.registry.endpoint.ClientToServerMessageType;

/**
 * @author Mauro Celani
 */
public class ReadTopicMessageDecoder
	extends BaseMessageDecoder<ReadTopicMessage> {

	@Override
	public ReadTopicMessage decode(String json) {
		return new ReadTopicMessage(json);
	}

	@Override
	protected ClientToServerMessageType getMessageType() {
		return ClientToServerMessageType.READ_TOPIC;
	}

}
