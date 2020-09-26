package it.cm.liferay.chat.registry.session.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import it.cm.liferay.chat.registry.session.UserSessionRegistry;
import it.cm.liferay.chat.topic.model.Message;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Mauro Celani
 */
@Component(
	immediate = true,
	service = ModelListener.class
)
public class MessageModelListener extends BaseModelListener<Message> {

	@Override
	public void onAfterCreate(Message message)
		throws ModelListenerException {

		_userSessionRegistry.notifyMessage(message);

		super.onAfterCreate(message);
	}

	@Reference
	private UserSessionRegistry _userSessionRegistry;

	private static final Log _log = LogFactoryUtil.getLog(
		MessageModelListener.class);

}
