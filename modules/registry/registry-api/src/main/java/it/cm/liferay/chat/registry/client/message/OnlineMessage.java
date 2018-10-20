package it.cm.liferay.chat.registry.client.message;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import it.cm.liferay.chat.registry.common.BaseMessage;

/**
 * @author Mauro Celani
 */
public class OnlineMessage extends BaseMessage {

	private long _userId;
	private boolean _online;

	public OnlineMessage(String json) {

		try {
			JSONObject msgJSON =
				JSONFactoryUtil.createJSONObject(json);

			_userId = msgJSON.getLong("userId");
			_online = msgJSON.getBoolean("online");
		}
		catch (JSONException e) {
			_log.error(e, e);
		}
	}

	@Override
	public String toString() {
		return "User: " + _userId +
			   "(Online: " + _online + ")";
	}

	public long getUserId() {
		return _userId;
	}

	public boolean isOnline() {
		return _online;
	}

	private static final Log _log = LogFactoryUtil.getLog(OnlineMessage.class);

}
