package it.cm.liferay.chat.registry.session.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserConstants;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import it.cm.liferay.chat.registry.session.UserSession;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Mauro Celani
 */
public class UserSessionMap {

	public UserSessionMap() {
		_userSessionMap = new ConcurrentHashMap<>();
	}

	public void clear() {
		_userSessionMap.clear();
		_userSessionMap = null;
	}

	public boolean containsKey(long userId) {
		return _userSessionMap.containsKey(userId);
	}

	public Set<Map.Entry<Long, UserSession>> entrySet() {
		return _userSessionMap.entrySet();
	}

	public UserSession get(long userId) {
		return _userSessionMap.get(userId);
	}

	public JSONObject getJSON(long userId) throws PortalException {

		if (_userSessionMap.containsKey(userId)) {

			return _userSessionMap.get(userId).toJSON();
		}

		User user = UserLocalServiceUtil.getUserById(userId);

		JSONObject retJSON = JSONFactoryUtil.createJSONObject();

		retJSON.put("userId", user.getUserId());
		retJSON.put("fullName", user.getFullName());

		retJSON.put("portraitUrl", UserConstants.getPortraitURL(
			PortalUtil.getPathImage(), user.isMale(),
			user.getPortraitId(), user.getUserUuid()));

		Date lastLoginDate = user.getLastLoginDate();
		if (lastLoginDate == null) {
			lastLoginDate = new Date();
		}
		retJSON.put("lastActivityTime", lastLoginDate.getTime());

		return retJSON;
	}

	public Set<Long> keySet() {
		return _userSessionMap.keySet();
	}

	public void put(long userId, UserSession userSession) {
		_userSessionMap.put(userId, userSession);
	}

	public UserSession remove(long userId) {
		return _userSessionMap.remove(userId);
	}

	public int size() {
		return _userSessionMap.size();
	}

	public Collection<UserSession> values() {
		return _userSessionMap.values();
	}

	private Map<Long, UserSession> _userSessionMap;
}
