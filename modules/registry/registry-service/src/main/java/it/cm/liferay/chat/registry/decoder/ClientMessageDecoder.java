package it.cm.liferay.chat.registry.decoder;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import it.cm.liferay.chat.registry.client.message.ClientMessage;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 * @author Mauro Celani
 */
public class ClientMessageDecoder implements Decoder.Text<ClientMessage> {

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
		try {
			JSONObject msg = JSONFactoryUtil.createJSONObject(json);

			if (!msg.has("userId")) {
				return false;
			}

			if (!msg.has("topicId")) {
				return false;
			}

			if (!msg.has("content")) {
				return false;
			}

			return true;
		}
		catch (JSONException e) {
			_log.error(e, e);
		}
		return false;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ClientMessageDecoder.class);

}
