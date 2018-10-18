package it.cm.liferay.chat.registry.decoder;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import it.cm.liferay.chat.registry.client.message.OnlineMessage;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 * @author Mauro Celani
 */
public class OnlineMessageDecoder implements Decoder.Text<OnlineMessage> {

	@Override
	public void init(EndpointConfig config) {

	}

	@Override
	public void destroy() {

	}

	@Override
	public OnlineMessage decode(String json) throws DecodeException {
		return new OnlineMessage(json);
	}

	@Override
	public boolean willDecode(String json) {
		try {
			JSONObject msg = JSONFactoryUtil.createJSONObject(json);

			if (!msg.has("userId")) {
				return false;
			}

			if (!msg.has("online")) {
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
		OnlineMessageDecoder.class);

}
