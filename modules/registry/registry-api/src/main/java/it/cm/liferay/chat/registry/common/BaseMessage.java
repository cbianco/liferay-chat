package it.cm.liferay.chat.registry.common;

import com.liferay.portal.kernel.json.JSONFactoryUtil;

/**
 * @author Mauro Celani
 */
public class BaseMessage {

	public final String toJson() {
		return JSONFactoryUtil.looseSerialize(this);
	}

}
