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

package it.cm.liferay.chat.topic.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONSerializer;
import it.cm.liferay.chat.topic.model.Message;
import it.cm.liferay.chat.topic.service.base.MessageServiceBaseImpl;
import it.cm.liferay.chat.topic.service.persistence.MessageUserPK;

import java.util.Collection;

/**
 * The implementation of the message remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.cm.liferay.chat.topic.service.MessageService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessageServiceBaseImpl
 * @see it.cm.liferay.chat.topic.service.MessageServiceUtil
 */
public class MessageServiceImpl extends MessageServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link it.cm.liferay.chat.topic.service.MessageServiceUtil} to access the message remote service.
	 */

	@Override
	public Message addMessage(
			long userId, long topicId, String content)
		throws PortalException {

		// TODO Add permission controls

		return messageLocalService.addMessage(userId, topicId, content);
	}

	@Override
	public JSONArray getTopicMessages(
			long userId, long topicId)
		throws PortalException {

		// TODO Add permission controls

		JSONArray messagesJSON = JSONFactoryUtil.createJSONArray();

		messageLocalService.getTopicMessages(topicId)
			.stream()
			.map(msg -> msg.toJSON(userId))
			.forEach(messagesJSON::put);

		return messagesJSON;
	}

	@Override
	public Collection<Message> getTopicMessages(
		long userId, long topicId, int start, int end) {

		// TODO Add permission controls

		return messageLocalService.getTopicMessages(topicId, start, end);
	}

}