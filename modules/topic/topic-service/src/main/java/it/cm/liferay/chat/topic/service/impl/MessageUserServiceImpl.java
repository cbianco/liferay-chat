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
import it.cm.liferay.chat.topic.model.MessageUser;
import it.cm.liferay.chat.topic.service.base.MessageUserServiceBaseImpl;

import java.util.Collection;

/**
 * The implementation of the message user remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.cm.liferay.chat.topic.service.MessageUserService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessageUserServiceBaseImpl
 * @see it.cm.liferay.chat.topic.service.MessageUserServiceUtil
 */
public class MessageUserServiceImpl extends MessageUserServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link it.cm.liferay.chat.topic.service.MessageUserServiceUtil} to access the message user remote service.
	 */

	@Override
	public int countUnreadTopicMessages(
		long userId, long topicId) {

		// TODO Add permission controls

		return messageUserLocalService.countUnreadTopicMessages(
			userId, topicId);
	}

	@Override
	public Collection<MessageUser> getUnreadTopicMessages(
		long topicId) {

		// TODO Add permission controls

		return messageUserLocalService.getUnreadTopicMessages(topicId);
	}

	@Override
	public boolean isRead(
			long userId, long messageId)
		throws PortalException {

		// TODO Add permission controls

		return messageUserLocalService.isRead(userId, messageId);
	}

	@Override
	public void setReadTopic(
		long userId, long topicId) {

		// TODO Add permission controls

		messageUserLocalService.setReadTopic(
			userId, topicId);
	}

}