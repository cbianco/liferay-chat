package it.cm.liferay.chat.registry.session.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import it.cm.liferay.chat.registry.session.UserSessionRegistry;
import it.cm.liferay.chat.topic.model.Topic;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Mauro Celani
 */
@Component(
	immediate = true,
	service = ModelListener.class
)
public class TopicModelListener extends BaseModelListener<Topic> {

	@Override
	public void onAfterCreate(Topic topic)
		throws ModelListenerException {

		_userSessionRegistry.notifyTopic(topic);

		super.onAfterCreate(topic);
	}

	@Reference
	private UserSessionRegistry _userSessionRegistry;

	private static final Log _log = LogFactoryUtil.getLog(
		TopicModelListener.class);

}
