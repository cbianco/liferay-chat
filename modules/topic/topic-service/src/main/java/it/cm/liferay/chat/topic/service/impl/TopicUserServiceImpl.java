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
import it.cm.liferay.chat.topic.exception.NoSuchTopicException;
import it.cm.liferay.chat.topic.model.Topic;
import it.cm.liferay.chat.topic.service.base.TopicUserServiceBaseImpl;

import java.util.Collection;

/**
 * The implementation of the topic user remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.cm.liferay.chat.topic.service.TopicUserService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TopicUserServiceBaseImpl
 * @see it.cm.liferay.chat.topic.service.TopicUserServiceUtil
 */
public class TopicUserServiceImpl extends TopicUserServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link it.cm.liferay.chat.topic.service.TopicUserServiceUtil} to access the topic user remote service.
	 */

	@Override
	public Collection<Long> getTopicIdsByUserId(
			long companyId, long userId)
		throws PortalException {

		// TODO Add permission controls

		return topicUserLocalService.getTopicIdsByUserId(companyId, userId);
	}

	@Override
	public Topic getTopicByUserIds(
			long companyId, long userId1, long userId2)
		throws PortalException {

		// TODO Add permission controls

		Collection<Topic> user1Topics =
			topicUserLocalService.getTopicsByUserId(companyId, userId1);

		Collection<Topic> user2Topics =
			topicUserLocalService.getTopicsByUserId(companyId, userId2);

		return user1Topics
				.stream()
				.filter(user2Topics::contains)
				.filter(t -> t.fetchUserIds().size() == 2)
				.findAny()
				.orElseThrow(NoSuchTopicException::new);
	}

	@Override
	public Collection<Long> getUserIdsByTopicId(
			long companyId, long topicId)
		throws PortalException {

		// TODO Add permission controls

		return topicUserLocalService.getUserIdsByTopicId(companyId, topicId);
	}

}