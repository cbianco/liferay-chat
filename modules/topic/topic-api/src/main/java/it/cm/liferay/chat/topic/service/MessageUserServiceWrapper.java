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

package it.cm.liferay.chat.topic.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MessageUserService}.
 *
 * @author Brian Wing Shun Chan
 * @see MessageUserService
 * @generated
 */
@ProviderType
public class MessageUserServiceWrapper implements MessageUserService,
	ServiceWrapper<MessageUserService> {
	public MessageUserServiceWrapper(MessageUserService messageUserService) {
		_messageUserService = messageUserService;
	}

	@Override
	public int countUnreadTopicMessages(long userId, long topicId) {
		return _messageUserService.countUnreadTopicMessages(userId, topicId);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _messageUserService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.Collection<it.cm.liferay.chat.topic.model.MessageUser> getUnreadTopicMessages(
		long topicId) {
		return _messageUserService.getUnreadTopicMessages(topicId);
	}

	@Override
	public void setReadTopic(long userId, long topicId) {
		_messageUserService.setReadTopic(userId, topicId);
	}

	@Override
	public MessageUserService getWrappedService() {
		return _messageUserService;
	}

	@Override
	public void setWrappedService(MessageUserService messageUserService) {
		_messageUserService = messageUserService;
	}

	private MessageUserService _messageUserService;
}