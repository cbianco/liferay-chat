package it.cm.liferay.chat.registry.session.listener;

import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.SessionAction;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;
import it.cm.liferay.chat.registry.session.UserSession;
import it.cm.liferay.chat.registry.session.UserSessionRegistryUtil;
import org.osgi.service.component.annotations.Component;

import java.io.IOException;

/**
 * @author Mauro Celani
 */
@Component(
	property = {
		"key=servlet.session.destroy.events"
	},
	service = LifecycleAction.class
)
public class RegistrySessionListener extends SessionAction {

	@Override
	public void run(javax.servlet.http.HttpSession session) {

		long userId = GetterUtil.getLong(session.getAttribute(WebKeys.USER_ID));

		_log.info("User (" + userId + ") made logout and his session" +
				  " will be destroyed");

		UserSession userSession =
			UserSessionRegistryUtil.clearUserSession(userId);

		try {
			userSession.getSession().close();
		}
		catch (IOException e) {
			_log.error(e, e);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		RegistrySessionListener.class);
}
