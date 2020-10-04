package it.cmd.liferay.chat.react.web.row.checker;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import it.cm.liferay.chat.topic.service.TopicServiceUtil;

import javax.portlet.RenderResponse;

/**
 * @author Mauro Celani
 */
public class UserTopicChecker extends EmptyOnClickRowChecker {

	public UserTopicChecker(RenderResponse renderResponse, long userId1) {

		super(renderResponse);

		_userId1 = userId1;
	}

	@Override
	public boolean isChecked(Object obj) {

		User user2 = null;

		if (obj instanceof User) {
			user2 = (User)obj;
		}
		else if (obj instanceof Object[]) {
			user2 = (User)((Object[])obj)[0];
		}
		else {
			throw new IllegalArgumentException(obj + " is not a user");
		}

		try {
			return TopicServiceUtil.existsTopicByUserIds(
				_userId1, user2.getUserId());
		}
		catch (Exception e) {
			_log.error(e, e);

			return false;
		}
	}

	@Override
	public boolean isDisabled(Object obj) {
		User user2 = (User)obj;

		try {
			if (isChecked(user2)) {
				return true;
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return super.isDisabled(obj);
	}

	private long _userId1;

	private static final Log _log = LogFactoryUtil.getLog(
		UserTopicChecker.class);

}
