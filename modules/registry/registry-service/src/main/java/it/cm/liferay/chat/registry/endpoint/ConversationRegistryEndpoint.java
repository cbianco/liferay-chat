package it.cm.liferay.chat.registry.endpoint;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.servlet.PortalSessionContext;
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.WebKeys;
import io.vavr.CheckedFunction1;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.control.Try;
import it.cm.liferay.chat.registry.client.message.BaseMessage;
import it.cm.liferay.chat.registry.decoder.ActiveUserMessageDecoder;
import it.cm.liferay.chat.registry.decoder.AddMessageMessageDecoder;
import it.cm.liferay.chat.registry.decoder.AddTopicMessageDecoder;
import it.cm.liferay.chat.registry.decoder.ReadTopicMessageDecoder;
import it.cm.liferay.chat.registry.handler.ActiveUserMessageHandler;
import it.cm.liferay.chat.registry.handler.AddMessageMessageHandler;
import it.cm.liferay.chat.registry.handler.AddTopicMessageHandler;
import it.cm.liferay.chat.registry.handler.BaseHandler;
import it.cm.liferay.chat.registry.handler.ReadTopicMessageHandler;
import it.cm.liferay.chat.registry.session.UserSession;
import it.cm.liferay.chat.registry.session.UserSessionRegistryUtil;

import javax.servlet.http.HttpSession;
import javax.websocket.CloseReason;
import javax.websocket.Decoder.Text;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler.Whole;
import javax.websocket.Session;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

/**
 * @author Cristian Bianco
 * @author Mauro Celani
 */
public class ConversationRegistryEndpoint extends Endpoint {

	private static List<Tuple2<Text<? extends BaseMessage>, BaseHandler>>
		decoders = new ArrayList<>(4);

	static {
		decoders.add(Tuple.of(
			new AddMessageMessageDecoder(), new AddMessageMessageHandler()));

		decoders.add(Tuple.of(
			new AddTopicMessageDecoder(), new AddTopicMessageHandler()));

		decoders.add(Tuple.of(
			new ActiveUserMessageDecoder(), new ActiveUserMessageHandler()));

		decoders.add(Tuple.of(
			new ReadTopicMessageDecoder(), new ReadTopicMessageHandler()));
	}

	@Override
	public void onOpen(
		final Session session, EndpointConfig config) {

		if (!_authVerifier(session)) {
			try {
				session.close(
					new CloseReason(
						CloseReason.CloseCodes.VIOLATED_POLICY,
						"AUTH ERROR"));

				_log.warn(
					"Error during open websocket session " +
					"due of no chat user role");
			}
			catch (IOException e) {
				throw new RuntimeException(e);
			}
			return;
		}

		session.addMessageHandler(
			new Whole<String>() {

				@Override
				public void onMessage(String message) {

					decoders
						.stream()
						.filter(t2 -> t2._1.willDecode(message))
						.map(_lift(
							t2 -> Tuple.of(
								t2._1.decode(message), t2._2)))
						.filter(Optional::isPresent)
						.map(Optional::get)
						.forEach(t2 -> t2._2.handle(session, t2._1));

				}

			}
		);

	}

	@Override
	public void onClose(
		final Session session, CloseReason closeReason) {

		UserSessionRegistryUtil.clearSession(session);
	}

	private boolean _authVerifier(Session session) {

		try {
			HttpSession httpSession = _getHttpSession(session);

			User user = (User)httpSession.getAttribute(WebKeys.USER);

			if (user == null) {
				return false;
			}

			return RoleLocalServiceUtil.hasUserRole(
				user.getUserId(),
				user.getCompanyId(),
				UserSession.CHAT_USER_ROLE,
				true
			);

		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return false;
	}

	private HttpSession _getHttpSession(Session session) throws Exception {

		if (_httpSessionIdField == null) {

			_httpSessionIdField = ReflectionUtil
				.getDeclaredField(session.getClass(), "httpSessionId");
		}

		String httpSessionId = (String)_httpSessionIdField.get(session);

		return PortalSessionContext.get(httpSessionId);
	}

	private <A, T> Function<A, Optional<T>> _lift(
		CheckedFunction1<? super A, ? extends T> partialFunction) {

		return a1 ->
			Try.<T>of(
				() -> partialFunction.apply(a1)
			).onFailure(
				a2 -> _log.error(
					"Something went wrong during decoding message: \n" +
					a2.toString())
			).toJavaOptional();
	}

	private Field _httpSessionIdField;

	private static final Log _log = LogFactoryUtil.getLog(
		ConversationRegistryEndpoint.class);

}
