package it.cm.liferay.chat.registry.client.message;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Mauro Celani
 */
public class AddTopicMessage extends BaseMessage {

	private long _userId1;
	private long _userId2;

	public AddTopicMessage(String json) {

		try {
			JSONObject msgJSON =
				JSONFactoryUtil.createJSONObject(json);

			_userId1 = msgJSON.getLong("userId1");
			_userId2 = msgJSON.getLong("userId2");
		}
		catch (JSONException e) {
			_log.error(e, e);
		}
	}

	@Override
	public String toString() {
		return "User1: " + _userId1 + " User2: " + _userId2;
	}

	public long getUserId1() {
		return _userId1;
	}
	public long getUserId2() {
		return _userId2;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AddTopicMessage.class);

}
