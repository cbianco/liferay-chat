package it.cm.liferay.chat.registry.client.message;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Mauro Celani
 */
public class AddMessageMessage extends BaseMessage {

	private long _userId;
	private long _topicId;
	private String _content;

	public AddMessageMessage(String json) {

		try {
			JSONObject msgJSON =
				JSONFactoryUtil.createJSONObject(json);

			_userId = msgJSON.getLong("userId");
			_topicId = msgJSON.getLong("topicId");
			_content = msgJSON.getString("content");
		}
		catch (JSONException e) {
			_log.error(e, e);
		}
	}

	@Override
	public String toString() {
		return "\nFrom: " + _userId +
			   "\nTo: " + _topicId +
			   "\nContent: " + _content;
	}

	public long getUserId() {
		return _userId;
	}

	public String getContent() {
		return _content;
	}

	public long getTopicId() {
		return _topicId;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		AddMessageMessage.class);

}
