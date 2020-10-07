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
import it.cm.liferay.chat.topic.model.Message;
import it.cm.liferay.chat.topic.model.MessageUser;
import it.cm.liferay.chat.topic.service.base.MessageUserLocalServiceBaseImpl;
import it.cm.liferay.chat.topic.service.persistence.MessageUserPK;

import java.util.Collection;

/**
 * The implementation of the message user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.cm.liferay.chat.topic.service.MessageUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessageUserLocalServiceBaseImpl
 * @see it.cm.liferay.chat.topic.service.MessageUserLocalServiceUtil
 */
public class MessageUserLocalServiceImpl extends MessageUserLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link it.cm.liferay.chat.topic.service.MessageUserLocalServiceUtil} to access the message user local service.
	 */

	@Override
	public void addMessageUser(
			long messageId, long userId, long topicId)
		throws PortalException {

		addMessageUser(messageId, userId, topicId, false);
	}

	@Override
	public void addMessageUser(
			long messageId, long userId, long topicId, boolean read)
		throws PortalException {

		MessageUserPK messageUserPK = new MessageUserPK(messageId, userId);
		MessageUser messageUser = messageUserPersistence.create(messageUserPK);

		messageUser.setTopicId(topicId);
		messageUser.setRead(read);

		messageUserPersistence.update(messageUser);
	}

	@Override
	public int countUnreadTopicMessages(
		long userId, long topicId) {

		return messageUserPersistence.countByU_T_R(
			userId, topicId, false);
	}

	@Override
	public Collection<MessageUser> getUnreadTopicMessages(
		long topicId) {

		return messageUserPersistence.findByT_R(topicId, false);
	}

	@Override
	public boolean isRead(
			long userId, long messageId)
		throws PortalException {

		return messageUserPersistence.findByPrimaryKey(
			new MessageUserPK(messageId, userId))
			.isRead();
	}

	@Override
	public void setReadTopic(
		long userId, long topicId) {

		for (MessageUser messageUser : messageUserPersistence.findByU_T_R(
			userId, topicId, false)) {

			messageUser.setRead(true);

			messageUserPersistence.update(messageUser);
		}
	}

}