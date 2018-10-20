package it.cm.liferay.chat.registry.decoder;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import it.cm.liferay.chat.registry.client.message.CreateTopicMessage;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class CreateTopicDecoder implements Decoder.Text<CreateTopicMessage> {

	@Override
	public CreateTopicMessage decode(String s) throws DecodeException {
		return JSONFactoryUtil.looseDeserialize(s, CreateTopicMessage.class);
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

			if (!msg.has("targetUserId")) {
				return false;
			}

			if (!msg.has("companyId")) {
				return false;
			}

			if (!msg.has("groupId")) {
				return false;
			}

			return true;
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void init(EndpointConfig config) {

	}

	@Override
	public void destroy() {

	}
}
