package it.cm.liferay.chat.topic.registry;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import it.cm.liferay.chat.client.message.ClientMessage;
import it.cm.liferay.chat.registry.session.UserSessionRegistry;
import org.osgi.service.component.annotations.Reference;

import javax.websocket.EncodeException;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import java.io.IOException;

/**
 * @author Mauro Celani
 */
public class ConversationRegistryEndpoint extends Endpoint {

	@Override
	public void onOpen(
		final Session session, EndpointConfig config) {

		session.addMessageHandler(
			new MessageHandler.Whole<ClientMessage>() {

				@Override
				public void onMessage(ClientMessage message) {

					_userSessionRegistry.addUserTopicSession(
						message, session);

					_log.debug("It's just arrived a new message.");
					_log.trace(message);

					try {
						RemoteEndpoint.Basic remoteEndpoint =
							session.getBasicRemote();

						remoteEndpoint.sendObject(message);
					}
					catch (IOException | EncodeException e) {
						throw new RuntimeException(e);
					}
				}

			}
		);

	}

	@Reference
	private UserSessionRegistry _userSessionRegistry;

	private static final Log _log = LogFactoryUtil.getLog(
		ConversationRegistryEndpoint.class);

}
