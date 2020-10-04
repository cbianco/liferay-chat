package it.cm.liferay.chat.registry.decoder;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import it.cm.liferay.chat.registry.client.message.BaseMessage;
import it.cm.liferay.chat.registry.endpoint.ClientToServerMessageType;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 * @author Mauro Celani
 */
public abstract class BaseMessageDecoder<T extends BaseMessage>
	implements Decoder.Text<T> {

	@Override
	public void init(EndpointConfig config) {}

	@Override
	public void destroy() {}

	public abstract T decode(String json) throws DecodeException;

	@Override
	public boolean willDecode(String json) {
		try {
			JSONObject msg = JSONFactoryUtil.createJSONObject(json);

			return msg.has(ClientToServerMessageType.MSG_TYPE) &&
				msg.getString(ClientToServerMessageType.MSG_TYPE)
					.equals(getMessageType().name());
		}
		catch (JSONException e) {
			_log.error(e, e);
		}
		return false;
	}

	protected abstract ClientToServerMessageType getMessageType();

	private static final Log _log = LogFactoryUtil.getLog(
		BaseMessageDecoder.class);

}
