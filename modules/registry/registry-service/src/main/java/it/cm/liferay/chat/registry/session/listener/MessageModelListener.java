package it.cm.liferay.chat.registry.session.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import it.cm.liferay.chat.registry.session.UserSessionRegistryUtil;
import it.cm.liferay.chat.topic.model.Message;

/**
 * @author Mauro Celani
 */
public class MessageModelListener extends BaseModelListener<Message> {

	@Override
	public void onAfterCreate(Message message) throws ModelListenerException {

		UserSessionRegistryUtil.updateLastActivityTime(message.getUserId());

		super.onAfterCreate(message);
	}

	private static final Log _log = LogFactoryUtil.getLog(
		MessageModelListener.class);

}
