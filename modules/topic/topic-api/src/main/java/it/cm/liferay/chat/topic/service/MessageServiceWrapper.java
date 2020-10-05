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
 * Provides a wrapper for {@link MessageService}.
 *
 * @author Brian Wing Shun Chan
 * @see MessageService
 * @generated
 */
@ProviderType
public class MessageServiceWrapper implements MessageService,
	ServiceWrapper<MessageService> {
	public MessageServiceWrapper(MessageService messageService) {
		_messageService = messageService;
	}

	@Override
	public it.cm.liferay.chat.topic.model.Message addMessage(long userId,
		long topicId, String content)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _messageService.addMessage(userId, topicId, content);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _messageService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getTopicMessages(
		long userId, long topicId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _messageService.getTopicMessages(userId, topicId);
	}

	@Override
	public java.util.Collection<it.cm.liferay.chat.topic.model.Message> getTopicMessages(
		long userId, long topicId, int start, int end) {
		return _messageService.getTopicMessages(userId, topicId, start, end);
	}

	@Override
	public MessageService getWrappedService() {
		return _messageService;
	}

	@Override
	public void setWrappedService(MessageService messageService) {
		_messageService = messageService;
	}

	private MessageService _messageService;
}