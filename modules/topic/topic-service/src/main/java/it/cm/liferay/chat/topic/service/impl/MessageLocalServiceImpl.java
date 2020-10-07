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
import com.liferay.portal.kernel.model.User;
import it.cm.liferay.chat.topic.model.Message;
import it.cm.liferay.chat.topic.service.base.MessageLocalServiceBaseImpl;

import java.util.Collection;
import java.util.Date;

/**
 * The implementation of the message local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.cm.liferay.chat.topic.service.MessageLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessageLocalServiceBaseImpl
 * @see it.cm.liferay.chat.topic.service.MessageLocalServiceUtil
 */
public class MessageLocalServiceImpl extends MessageLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link it.cm.liferay.chat.topic.service.MessageLocalServiceUtil} to access the message local service.
	 */

	@Override
	public Message addMessage(
			long userId, long topicId, String content)
		throws PortalException {

		long messageId = counterLocalService.increment(Message.class.getName());
		Message message = messagePersistence.create(messageId);

		User user = userLocalService.getUser(userId);
		Date createDate = new Date();

		message.setCompanyId(user.getCompanyId());
		message.setUserId(userId);
		message.setUserName(user.getFullName());
		message.setCreateDate(createDate);
		message.setModifiedDate(createDate);
		message.setTopicId(topicId);
		message.setContent(content);

		// User Message

		for (long userId2 : topicLocalService.getTopic(topicId)
			.getUserIds()) {

			messageUserLocalService.addMessageUser(
				messageId, userId2, topicId, userId2 == userId);
		}

		messagePersistence.update(message);

		return message;
	}

	@Override
	public Collection<Message> getTopicMessages(long topicId) {

		return messagePersistence.findByTopicId(topicId);
	}

	@Override
	public Collection<Message> getTopicMessages(
		long topicId, int start, int end) {

		return messagePersistence.findByTopicId(topicId, start, end);
	}

}