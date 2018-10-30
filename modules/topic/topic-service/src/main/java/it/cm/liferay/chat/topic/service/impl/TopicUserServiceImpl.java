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
	public Collection<Long> getTopicIdByUserId(
			long userId)
		throws PortalException {

		// TODO Add permission controls
		return topicUserLocalService.getTopicIdByUserId(userId);
	}

	@Override
	public long getTopicByUserIds(
			long userId1, long userId2)
		throws PortalException {

		// TODO Add permission controls

		Collection<Long> user1TopicIds =
			topicUserLocalService.getTopicIdByUserId(userId1);

		Collection<Long> user2TopicIds =
			topicUserLocalService.getTopicIdByUserId(userId2);

		user1TopicIds.retainAll(user2TopicIds);

		for (Long topicId : user1TopicIds) {
			if (topicUserLocalService.countByTopicId(topicId) == 2) {
				return topicId;
			}
		}
		throw new NoSuchTopicException();
	}

	@Override
	public Collection<Long> getUserIdsByTopicId(
			long topicId)
		throws PortalException {

		// TODO Add permission controls
		return topicUserLocalService.getUserIdsByTopicId(topicId);
	}

}