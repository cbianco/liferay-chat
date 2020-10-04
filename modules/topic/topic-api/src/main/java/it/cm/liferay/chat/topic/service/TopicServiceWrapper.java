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
 * Provides a wrapper for {@link TopicService}.
 *
 * @author Brian Wing Shun Chan
 * @see TopicService
 * @generated
 */
@ProviderType
public class TopicServiceWrapper implements TopicService,
	ServiceWrapper<TopicService> {
	public TopicServiceWrapper(TopicService topicService) {
		_topicService = topicService;
	}

	@Override
	public it.cm.liferay.chat.topic.model.Topic addTopic(long userId1,
		long user2) throws com.liferay.portal.kernel.exception.PortalException {
		return _topicService.addTopic(userId1, user2);
	}

	@Override
	public boolean existsTopicByUserIds(long userId1, long userId2)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _topicService.existsTopicByUserIds(userId1, userId2);
	}

	@Override
	public it.cm.liferay.chat.topic.model.Topic getOrCreateTopicByUserIds(
		long userId1, long userId2)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _topicService.getOrCreateTopicByUserIds(userId1, userId2);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _topicService.getOSGiServiceIdentifier();
	}

	@Override
	public it.cm.liferay.chat.topic.model.Topic getTopic(long topicId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _topicService.getTopic(topicId);
	}

	@Override
	public it.cm.liferay.chat.topic.model.Topic getTopicByUserIds(
		long userId1, long userId2)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _topicService.getTopicByUserIds(userId1, userId2);
	}

	@Override
	public java.util.Collection<it.cm.liferay.chat.topic.model.Topic> getTopicsByUserId(
		long userId) {
		return _topicService.getTopicsByUserId(userId);
	}

	@Override
	public TopicService getWrappedService() {
		return _topicService;
	}

	@Override
	public void setWrappedService(TopicService topicService) {
		_topicService = topicService;
	}

	private TopicService _topicService;
}