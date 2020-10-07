/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package it.cm.liferay.chat.topic.model.impl;

import aQute.bnd.annotation.ProviderType;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONSerializer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import it.cm.liferay.chat.topic.model.Topic;
import it.cm.liferay.chat.topic.service.MessageService;
import it.cm.liferay.chat.topic.service.MessageUserService;
import it.cm.liferay.chat.topic.service.MessageUserServiceUtil;
import it.cm.liferay.chat.topic.service.TopicService;
import it.cm.liferay.chat.topic.service.TopicServiceUtil;

/**
 * The extended model implementation for the Message service. Represents a row in the &quot;Conversation_Message&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.cm.liferay.chat.topic.model.Message} interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class MessageImpl extends MessageBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a message model instance should use the {@link it.cm.liferay.chat.topic.model.Message} interface instead.
	 */
	public MessageImpl() {
	}

	@Override
	public JSONObject toJSON(long userId) {

		try {
			JSONSerializer jsonSerializer =
				JSONFactoryUtil.createJSONSerializer();

			JSONObject messageJSON = JSONFactoryUtil.createJSONObject(
				jsonSerializer.serialize(this));

			messageJSON.put(
				"read", MessageUserServiceUtil.isRead(
					userId, getMessageId()));

			return messageJSON;
		}
		catch (PortalException e) {
			_log.error(e, e);
		}
		return JSONFactoryUtil.createJSONObject();
	}

	@Override
	public Topic getTopic() throws PortalException {
		return TopicServiceUtil.getTopic(getTopicId());
	}

	private static final Log _log = LogFactoryUtil.getLog(MessageImpl.class);

}