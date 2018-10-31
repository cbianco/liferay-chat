package it.cm.liferay.chat.registry.client.message;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Mauro Celani
 */
public class OnlineMessage implements BaseMessage {

	private long _userId;

	public OnlineMessage(String json) {

		try {
			JSONObject msgJSON =
				JSONFactoryUtil.createJSONObject(json);

			_userId = msgJSON.getLong("userId");
		}
		catch (JSONException e) {
			_log.error(e, e);
		}
	}

	@Override
	public String toString() {
		return "User: " + _userId;
	}

	public long getUserId() {
		return _userId;
	}

	private static final Log _log = LogFactoryUtil.getLog(OnlineMessage.class);

}
