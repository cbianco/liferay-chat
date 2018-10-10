package it.cm.liferay.chat.registry.encoder;

import it.cm.liferay.chat.topic.model.Message;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * @author Mauro Celani
 */
public class MessageEncoder implements Encoder.Text<Message> {

	@Override
	public String encode(Message object) throws EncodeException {

		return object.toString();
	}

	@Override
	public void init(EndpointConfig config) {

	}

	@Override
	public void destroy() {

	}
}
