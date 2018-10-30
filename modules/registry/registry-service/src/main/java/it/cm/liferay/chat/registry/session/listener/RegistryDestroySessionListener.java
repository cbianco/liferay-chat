package it.cm.liferay.chat.registry.session.listener;

import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.SessionAction;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.WebKeys;
import it.cm.liferay.chat.registry.session.UserSession;
import it.cm.liferay.chat.registry.session.UserSessionRegistry;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.servlet.http.HttpSession;

/**
 * @author Mauro Celani
 */
@Component(
	property = {
		"key=" + PropsKeys.SERVLET_SESSION_DESTROY_EVENTS
	},
	service = LifecycleAction.class
)
public class RegistryDestroySessionListener extends SessionAction {

	@Override
	public void run(HttpSession session) {

		long userId = GetterUtil.getLong(session.getAttribute(WebKeys.USER_ID));

		_log.info("User (" + userId + ") made logout and his sessions" +
				  " will be destroyed");

		UserSession userSession = _userSessionRegistry.clearUserSession(userId);

		userSession.closeSessions();
	}

	@Reference
	private UserSessionRegistry _userSessionRegistry;

	private static final Log _log = LogFactoryUtil.getLog(
		RegistryDestroySessionListener.class);
}
