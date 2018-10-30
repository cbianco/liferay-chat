package it.cm.liferay.chat.registry.handler;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import it.cm.liferay.chat.registry.client.message.ClientMessage;

import javax.websocket.EncodeException;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import java.io.IOException;

/**
 * @author Mauro Celani
 */
public class ClientMessageHandler implements BaseHandler<ClientMessage> {

	@Override
	public void handle(
		Session session, ClientMessage message) {

		_log.info("It's just arrived a new message.");
		_log.trace(message);

		try {
			RemoteEndpoint.Basic remoteEndpoint =
				session.getBasicRemote();

			remoteEndpoint.sendObject(message);
		}
		catch (IOException | EncodeException e) {
			_log.error(e, e);
			throw new RuntimeException(e);
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ClientMessageHandler.class);

}
