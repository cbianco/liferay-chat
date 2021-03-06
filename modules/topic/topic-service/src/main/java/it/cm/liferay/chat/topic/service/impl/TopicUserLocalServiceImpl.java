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
import it.cm.liferay.chat.topic.model.TopicUser;
import it.cm.liferay.chat.topic.model.TopicUserModel;
import it.cm.liferay.chat.topic.service.base.TopicUserLocalServiceBaseImpl;
import it.cm.liferay.chat.topic.service.persistence.TopicUserPK;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * The implementation of the topic user local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link it.cm.liferay.chat.topic.service.TopicUserLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TopicUserLocalServiceBaseImpl
 * @see it.cm.liferay.chat.topic.service.TopicUserLocalServiceUtil
 */
public class TopicUserLocalServiceImpl extends TopicUserLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link it.cm.liferay.chat.topic.service.TopicUserLocalServiceUtil} to access the topic user local service.
	 */

	@Override
	public void addTopicUser(
			long topicId, long userId)
		throws PortalException {

		User user = userLocalService.getUser(userId);

		TopicUserPK topicUserPK = new TopicUserPK(topicId, userId);
		TopicUser topicUser = topicUserPersistence.create(topicUserPK);
		topicUser.setCompanyId(user.getCompanyId());
		topicUserPersistence.update(topicUser);
	}

	@Override
	public int countByTopicId(
		long topicId)
		throws PortalException {

		return topicUserPersistence.countByTopicId(topicId);
	}

	@Override
	public Collection<Long> getUserIdsByTopicId(long topicId) {

		return topicUserPersistence
			.findByTopicId(topicId)
			.stream()
			.map(TopicUserModel::getUserId)
			.collect(Collectors.toSet());
	}


	@Override
	public Collection<Long> getTopicIdsByUserId(
		long userId)
		throws PortalException {

		return topicUserPersistence
			.findByUserId(userId)
			.stream()
			.map(TopicUserModel::getTopicId)
			.collect(Collectors.toList());
	}

}