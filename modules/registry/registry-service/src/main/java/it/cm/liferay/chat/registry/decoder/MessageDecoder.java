package it.cm.liferay.chat.registry.decoder;

import it.cm.liferay.chat.registry.client.message.ClientMessage;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 * @author Mauro Celani
 */
public class MessageDecoder implements Decoder.Text<ClientMessage> {

	@Override
	public void init(EndpointConfig config) {

	}

	@Override
	public void destroy() {

	}

	@Override
	public ClientMessage decode(String json) throws DecodeException {
		return new ClientMessage(json);
	}

	@Override
	public boolean willDecode(String json) {
		// TODO Check if is valid JSON
		return true;
	}
}
